package dev.wand.command;

import dev.wand.auth.AuthData;
import dev.wand.endpoint.DestinyEndpoint;
import dev.wand.request.AuthedDestinyRequest;
import dev.wand.response.wrapper.WrapperGetCurrentBungieNetUser;
import dev.wand.response.wrapper.WrapperGetLinkedProfiles;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.Map;

public class InventoryCommand extends AuthedSlashCommand {
    public InventoryCommand() {
        super("inventory", "Shows your Destiny inventory.");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event, AuthData authData) {
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

            AuthedDestinyRequest profileRequest = (AuthedDestinyRequest) DestinyEndpoint.custom("/Destiny2/1/Profile/4611686018507047338/?components=201,202", "GET", authData);

            if (profileRequest == null) {
                event.getHook().sendMessage("An error occurred. Please try again later.").setEphemeral(true).queue();
                return;
            }

            System.out.println(profileRequest.getError());

            event.getHook().sendMessage("Success").setEphemeral(true).queue();
        } catch (Exception e) {
            event.getHook().sendMessage("An error occurred. Please try again later.").setEphemeral(true).queue();
            System.out.print(e.getMessage());
        }
    }
}
