package dev.wand.command;

import dev.wand.auth.AuthData;
import dev.wand.request.AuthedDestinyRequest;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.io.IOException;

public class MembershipsCommand extends AuthedSlashCommand {

    public MembershipsCommand() {
        super("memberships", "Shows your Destiny account memberships.");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event, AuthData data) {
        // https://www.bungie.net/Platform/User/GetMembershipsForCurrentUser/
        try {
            AuthedDestinyRequest request = new AuthedDestinyRequest("https://www.bungie.net/Platform/User/GetMembershipsForCurrentUser/", "GET", event.getUser());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
