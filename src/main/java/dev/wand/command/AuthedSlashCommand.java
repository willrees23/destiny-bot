package dev.wand.command;

import dev.wand.auth.AuthData;
import dev.wand.auth.AuthHandler;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import xyz.dynxsty.dih4jda.interactions.commands.application.SlashCommand;

public abstract class AuthedSlashCommand extends SlashCommand {

    public AuthedSlashCommand(String name, String description) {
        setCommandData(
                Commands.slash(
                        name,
                        description
                )
        );
    }

    public AuthedSlashCommand(String name, String description, OptionData... data) {
        setCommandData(
                Commands.slash(
                        name,
                        description
                )
        );
    }

    public abstract void execute(SlashCommandInteractionEvent event, AuthData authData);

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        AuthData authData = AuthHandler.getAuthData(event.getUser().getId());
        if (authData == null) {
            event.reply("You are not authorized. Use </authorize:1260240797945561250>.").setEphemeral(true).queue();
            return;
        }
        if (authData.isAccessExpired()) {
            AuthHandler.removeAuthData(event.getUser().getId());
            event.reply("Your access token has expired. Use </authorize:1260240797945561250> to reauthorize.").setEphemeral(true).queue();
            return;
        }
        execute(event, authData);
    }
}
