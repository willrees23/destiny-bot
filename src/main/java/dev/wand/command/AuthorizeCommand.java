package dev.wand.command;

import dev.wand.auth.AuthData;
import dev.wand.auth.AuthHandler;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import xyz.dynxsty.dih4jda.interactions.commands.application.SlashCommand;

public class AuthorizeCommand extends SlashCommand {

    public AuthorizeCommand() {
        setCommandData(
                Commands.slash("authorize", "Authorize with Destiny")
        );
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        // send an embed with a button
        String discordId = event.getUser().getId();

        if (AuthHandler.hasAuthData(discordId)) {
            event.reply("You are already authorized.").setEphemeral(true).queue();
            return;
        }

        AuthData data = AuthHandler.getAuthData(discordId);

        MessageEmbed embed = new EmbedBuilder()
                .setTitle("Authorize with Destiny")
                .setDescription("Click the button below to authorize with Destiny. " + (data != null && data.isAccessExpired() ? "Your previous token has expired." : ""))
                .build();

        event.replyEmbeds(embed).addActionRow(
                Button.link(AuthHandler.autoAuthURL(event.getUser().getId()), "Authorize")).setEphemeral(true)
                .queue();

        AuthHandler.putEvent(discordId, event);
    }
}
