package dev.wand.util;

import com.google.gson.JsonObject;
import dev.wand.Main;
import dev.wand.response.wrapper.WrapperGetProfile;
import dev.wand.response.wrapper.WrapperManifestItem;
import lombok.experimental.UtilityClass;
import net.dec4234.javadestinyapi.material.DestinyAPI;
import net.dec4234.javadestinyapi.material.manifest.DestinyManifest;
import net.dec4234.javadestinyapi.material.manifest.ManifestEntityTypes;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

@UtilityClass
public class ChatUtil {

    // function that takes list of items and returns embed to show inventory in chat
    public MessageEmbed getInventoryEmbed(List<WrapperGetProfile.Item> items, boolean vault) {
        // create embed builder
        // if vault is true, filter items to only show vault items, which is item location == 2


        EmbedBuilder builder = getEmbedBuilder(items, vault);

        // return built embed
        return builder.build();
    }

    private static @NotNull EmbedBuilder getEmbedBuilder(List<WrapperGetProfile.Item> items, boolean vault) {
        EmbedBuilder builder = new EmbedBuilder();

        // set title of embed
        builder.setTitle("Items in your " + (vault ? "Vault" : "Inventory"));

        // loop through items and add fields to embed
        for (WrapperGetProfile.Item item : items) {
            // get item definition from item hash
            DestinyManifest manifest = Main.getManifest();
            JsonObject obj = manifest.manifestGET(ManifestEntityTypes.INVENTORYITEM, item.getItemHash());

            obj = obj.getAsJsonObject("displayProperties");
            String itemName = obj.get("name").getAsString();

            // add field to embed with item name and item quantity
            builder.addField(itemName, "Quantity: " + item.getQuantity(), true);
        }
        return builder;
    }
}
