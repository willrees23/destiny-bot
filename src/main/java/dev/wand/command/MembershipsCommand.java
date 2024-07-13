package dev.wand.command;

import dev.wand.auth.AuthData;
import dev.wand.request.AuthedDestinyRequest;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.AutoCompleteQuery;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.io.IOException;

public class MembershipsCommand extends AuthedSlashCommand {

    public MembershipsCommand() {
        super("memberships", "Get the memberships of the current user.");
    }

    @Override
    public void executeAuth(SlashCommandInteractionEvent event, AuthData data) {
        // https://www.bungie.net/Platform/User/GetMembershipsForCurrentUser/
        try {
            AuthedDestinyRequest request = new AuthedDestinyRequest("https://www.bungie.net/Platform/User/GetMembershipsForCurrentUser/", "GET", event.getUser());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
