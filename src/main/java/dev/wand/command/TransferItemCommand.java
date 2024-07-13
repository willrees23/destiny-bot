package dev.wand.command;

import dev.wand.auth.AuthData;
import dev.wand.endpoint.DestinyEndpoint;
import dev.wand.request.AuthedDestinyRequest;
import dev.wand.response.wrapper.WrapperGetCurrentBungieNetUser;
import dev.wand.response.wrapper.WrapperGetLinkedProfiles;
import dev.wand.response.wrapper.WrapperGetProfile;
import dev.wand.util.ItemUtil;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Map;

public class TransferItemCommand extends AuthedSlashCommand{

    public TransferItemCommand() {
        super("transfer", "Transfer an item to/from your vault.");
        addOptions(
                new OptionData(OptionType.STRING, "platform", "The platform the item is on.")
                        .addChoice("Xbox", "1")
                        .addChoice("PlayStation", "2")
                        .addChoice("Steam", "3")
                        .setRequired(true)
                ,
                new OptionData(OptionType.STRING, "itemhash", "The item hash to transfer.")
                        .setRequired(true),
                new OptionData(OptionType.STRING, "itemrefhash", "The item reference hash to transfer.")
                        .setRequired(true),
                new OptionData(OptionType.INTEGER, "amount", "The amount of the item to transfer.")
                        .setRequired(true),
                new OptionData(OptionType.BOOLEAN, "vault", "Whether to transfer to the vault.")
                        .setRequired(true)
        );
    }

    @Override
    public void executeAuth(SlashCommandInteractionEvent event, AuthData authData) {
        event.deferReply(true).queue();

        String platform = event.getOption("platform").getAsString();
        String item = event.getOption("itemhash").getAsString();
        String itemRefHash = event.getOption("itemrefhash").getAsString();
        int amount = event.getOption("amount").getAsInt();
        boolean vault = event.getOption("vault").getAsBoolean();

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

            boolean success = ItemUtil.transferItem(
                    authData,
                    item,
                    amount,
                    vault,
                    itemRefHash,
                    charId,
                    Integer.parseInt(platform)
            );

            event.getHook().sendMessage(success ? "Item transferred successfully." : "Failed to transfer item.").setEphemeral(true).queue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
