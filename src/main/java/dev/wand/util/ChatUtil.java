package dev.wand.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.wand.Main;
import dev.wand.response.wrapper.WrapperGetProfile;
import dev.wand.response.wrapper.WrapperManifestItem;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import net.dec4234.javadestinyapi.material.DestinyAPI;
import net.dec4234.javadestinyapi.material.manifest.DestinyManifest;
import net.dec4234.javadestinyapi.material.manifest.ManifestEntityTypes;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@UtilityClass
public class ChatUtil {

    // function that takes list of items and returns embed to show inventory in chat
    public MessageEmbed getInventoryEmbed(WrapperGetProfile.Item item, int size, int index) {
        // create embed builder
        // if vault is true, filter items to only show vault items, which is item location == 2
        EmbedBuilder builder = getEmbedBuilder(item, size, index);

        // return built embed
        return builder.build();
    }

    @SneakyThrows
    private static @NotNull EmbedBuilder getEmbedBuilder(WrapperGetProfile.Item item, int size, int index) {
        EmbedBuilder builder = new EmbedBuilder();

        DestinyManifest manifest = Main.getManifest();
        JsonObject obj = manifest.manifestGET(ManifestEntityTypes.INVENTORYITEM, item.getItemHash());
        // use jackon object mapper to map json object to java object
        WrapperManifestItem itemManifest = new ObjectMapper().readValue(obj.toString(), WrapperManifestItem.class);

        // set title of embed
        builder.setTitle(itemManifest.getDisplayProperties().getName() + " (" + (index + 1) + "/" + size + ")");
        builder.setDescription("*" + itemManifest.getFlavorText() + "*");
        builder.addField(
                "Weapon Type", itemManifest.getItemTypeAndTierDisplayName(), true
        );
        builder.addField(
                "Weapon Slot", "test", true
        );
        builder.addField(" ", "[View on Light.gg](https://light.gg/db/items/" + item.getItemHash() + ")", false);
        builder.setThumbnail("https://www.bungie.net" + itemManifest.getDisplayProperties().getIcon());
        builder.setImage("https://www.bungie.net" + itemManifest.getScreenshot());
        builder.setFooter("Instance ID: " + item.getItemInstanceId(), null);
        builder.setColor(Color.decode("#2f3136"));

        return builder;
    }
}
