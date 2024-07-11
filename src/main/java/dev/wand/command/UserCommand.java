package dev.wand.command;

import net.dec4234.javadestinyapi.material.DestinyAPI;
import net.dec4234.javadestinyapi.material.user.BungieUser;
import net.dec4234.javadestinyapi.material.user.DestinyCharacter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import xyz.dynxsty.dih4jda.interactions.commands.application.SlashCommand;

import java.util.Comparator;
import java.util.List;

public class UserCommand extends SlashCommand {

    public UserCommand() {
        setCommandData(
                Commands.slash("user", "Get information about a user")
                        .addOption(OptionType.STRING, "username", "The username of the user", true)
                        .addOption(OptionType.INTEGER, "discriminator", "The discriminator of the user (ex. #1234)", false)
        );

    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        // tell the user we are searching
        event.reply("Searching...").setEphemeral(true).queue();

        String username = event.getOption("username").getAsString();
        OptionMapping desc = event.getOption("discriminator");

        if (desc == null) {
            // we need to use DestinyAPI.searchUsers and paginate through the results
            event.getHook().editOriginal("This is not implemented yet.").queue();
            return;
        }

        BungieUser user = DestinyAPI.getUserWithName(username + "#" + desc.getAsInt());


        if (user == null) {
            event.getHook().editOriginal("User not found.").queue();
            return;
        }

        String timePlayed = "";
        int time = user.getTimePlayed();
        timePlayed = time / 60 + "h, " + time % 60 + "m";

        List<DestinyCharacter> characters = user.getCharacters();
        StringBuilder characterString = new StringBuilder();
        for (DestinyCharacter character : characters) {
            characterString.append(character.getD2class())
                    .append(" (")
                    .append("`")
                    .append(character.getLightLevel())
                    .append("`) | ");
        }

        DestinyCharacter highestLightLevel = characters.stream().max(Comparator.comparingInt(DestinyCharacter::getLightLevel)).get();

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle(username + "#" + desc.getAsInt())
                .addField("Time played", timePlayed, false)
                .addField("Characters", characterString.toString(), false)
                .setThumbnail(
                        "https://www.bungie.net/" + highestLightLevel.getEmblemPath()
                )
                .setFooter("User ID: " + user.getID());

        // we have already sent a message, so we need to edit
        event.getHook().editOriginal("").setEmbeds(embed.build()).queue();
    }
}
