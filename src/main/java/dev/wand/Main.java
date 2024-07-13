package dev.wand;

import com.github.ygimenez.method.Pages;
import com.github.ygimenez.model.PaginatorBuilder;
import dev.wand.auth.AuthHandler;
import dev.wand.command.*;
import dev.wand.listener.ReadyListener;
import dev.wand.listener.ShutdownListener;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import lombok.SneakyThrows;
import net.dec4234.javadestinyapi.material.DestinyAPI;
import net.dec4234.javadestinyapi.material.manifest.DestinyManifest;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import xyz.dynxsty.dih4jda.DIH4JDA;
import xyz.dynxsty.dih4jda.DIH4JDABuilder;
import xyz.dynxsty.dih4jda.exceptions.DIH4JDAException;
import xyz.dynxsty.dih4jda.interactions.commands.application.RegistrationType;

public class Main {

    @Getter
    private static DestinyManifest manifest;
    public static String DESTINY_API_KEY, DESTINY_CLIENT_SECRET;

    @SneakyThrows
    public static void main(String[] args)
            throws InterruptedException {
        // Note: It is important to register your ReadyListener before building
        Dotenv env = Dotenv.load();

        String BOT_TOKEN = env.get("BOT_TOKEN");
        Main.DESTINY_API_KEY = env.get("DESTINY_API_KEY");
        Main.DESTINY_CLIENT_SECRET = env.get("DESTINY_CLIENT_SECRET");

        JDA jda = JDABuilder.createDefault(BOT_TOKEN)
                .addEventListeners(new ReadyListener(), new ShutdownListener())
                .build();

        DIH4JDA.setDefaultRegistrationType(RegistrationType.GUILD);

        DIH4JDA dih4jda = null;
        try {
            dih4jda = DIH4JDABuilder
                    .setJDA(jda) // Your JDA instance
                    .setGuildSmartQueue(true)
                    .build();

            dih4jda.addSlashCommands(
                    new AuthorizeCommand(),
                    new InventoryCommand(),
                    new MembershipsCommand(),
                    new UserCommand(),
                    new TransferItemCommand()
            );
        } catch (DIH4JDAException e) {
            e.printStackTrace();
        }

        Pages.activate(PaginatorBuilder.createSimplePaginator(jda));

        // optionally block until JDA is ready
        jda.awaitReady();

        System.out.println("Bot ready, initialising Destiny API...");
        DestinyAPI api = new DestinyAPI(DESTINY_API_KEY); // Initialise the Destiny API

        manifest = new DestinyManifest();

        System.out.println("Destiny API initialised. Initialising auth routes...");
        AuthHandler.listen(); // Initialise the routes
        System.out.println("Routes initialised.");
    }
}