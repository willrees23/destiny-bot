package dev.wand.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ygimenez.method.Pages;
import com.github.ygimenez.model.InteractPage;
import com.github.ygimenez.model.Page;
import dev.wand.Main;
import dev.wand.auth.AuthData;
import dev.wand.endpoint.DestinyEndpoint;
import dev.wand.request.AuthedDestinyRequest;
import dev.wand.request.GenericDestinyRequest;
import dev.wand.response.wrapper.WrapperGetCurrentBungieNetUser;
import dev.wand.response.wrapper.WrapperGetLinkedProfiles;
import dev.wand.response.wrapper.WrapperGetProfile;
import dev.wand.response.wrapper.WrapperManifestItem;
import dev.wand.util.ChatUtil;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.AutoCompleteQuery;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryCommand extends AuthedSlashCommand {
    public InventoryCommand() {
        super("inventory", "Get the items in your inventory.");
        addOptions(
                new OptionData(OptionType.BOOLEAN, "vault", "Whether to get items from the vault.")
        );
    }

    @Override
    public void executeAuth(SlashCommandInteractionEvent event, AuthData authData) {
        event.deferReply(true).queue();
        try {
            AuthedDestinyRequest currentUserRequest = DestinyEndpoint.Authed.USER_GET_CURRENT_BUNGIE_NET_USER.hit("GET", authData);
            WrapperGetCurrentBungieNetUser wrapperCurrentUser = currentUserRequest.getDestinyResponse(WrapperGetCurrentBungieNetUser.class).getResponse();

            Map<String, String> pathParams = Map.of(
                    "membershipType", "1",
                    "destinyMembershipId", wrapperCurrentUser.getMembershipId()
            );

            AuthedDestinyRequest linkedRequest = DestinyEndpoint.Authed.DESTINY2_GET_LINKED_PROFILES.hitWithPath("GET", authData, pathParams);
            WrapperGetLinkedProfiles wrapperLinkedProfiles = linkedRequest.getDestinyResponse(WrapperGetLinkedProfiles.class).getResponse();

            // get profile where membershipType is 3
            String destinyMembershipId = wrapperLinkedProfiles.getProfiles().stream()
                    .filter(profile -> profile.getMembershipType() == 3)
                    .findFirst()
                    .map(WrapperGetLinkedProfiles.Profile::getMembershipId)
                    .orElse(null);

            if (destinyMembershipId == null) {
                event.getHook().sendMessage("You do not have a Destiny 2 profile linked to your Bungie account.").setEphemeral(true).queue();
                return;
            }

            pathParams = Map.of(
                    "membershipType", "3",
                    "destinyMembershipId", destinyMembershipId
            );
            Map<String, String> queryParams = Map.of(
                    "components", "100,201"
            );

            AuthedDestinyRequest profileRequest = DestinyEndpoint.Authed.DESTINY2_GET_PROFILE.hit("GET", authData, pathParams, queryParams);
            WrapperGetProfile wrapperProfile = profileRequest.getDestinyResponse(WrapperGetProfile.class).getResponse();

            // reply with the first 5 items' names, ref hash, and instance id

            String charId = (String) wrapperProfile.getProfile().getData().getCharacterIds().get(0);

            List<WrapperGetProfile.Item> items = wrapperProfile.getCharacterInventories().getData().getCharacters().get(charId).getItems();
            List<Page> pages = new ArrayList<>();

            OptionMapping vaultOption = event.getOption("vault");
            boolean vault = vaultOption != null && vaultOption.getAsBoolean();

            if (vault) {
                items = items.stream().filter(item -> item.getLocation() == 2).toList();
            } else {
                // if vault is false, filter items to only show items that are in inventory, which is item location == 1
                items = items.stream().filter(item -> item.getLocation() == 1).toList();
            }

            // only 25 items can be shown in one embed, so we need to split the items into pages
            for (int i = 0; i < items.size(); i += 24) {
                List<WrapperGetProfile.Item> subList = items.subList(i, Math.min(i + 24, items.size()));
                pages.add(
                        InteractPage.of(
                                ChatUtil.getInventoryEmbed(subList, vault)
                        )
                );
            }

            event.getHook().sendMessageEmbeds((MessageEmbed) pages.get(0).getContent()).queue(success -> {
                Pages.paginate(success, pages, true);
            });
        } catch (Exception e) {

            event.getHook().sendMessage("An error occurred. Please try again later.").setEphemeral(true).queue();
            System.out.print(e.getMessage());
        }
    }
}
