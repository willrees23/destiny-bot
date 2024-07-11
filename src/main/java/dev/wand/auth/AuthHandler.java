package dev.wand.auth;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.wand.endpoint.DestinyEndpoint;
import dev.wand.request.AuthedDestinyRequest;
import dev.wand.response.DestinyResponse;
import dev.wand.response.wrapper.WrapperGetCurrentBungieNetUser;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import spark.Spark;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public class AuthHandler {

    public static final String AUTH_URL = "https://www.bungie.net/en/oAuth/Authorize?client_id=47655&response_type=code";
    public static final String TOKEN_URL = "https://www.bungie.net/Platform/App/OAuth/Token";

    // discord ID -> auth data
    private static final HashMap<String, AuthData> authData = new HashMap<>();

    // discord ID -> event
    private static final HashMap<String, GenericInteractionCreateEvent> eventMap = new HashMap<>();

    public static void listen() {
        // spark
        // setup route for oAuth with destiny
        // route will receive code in query param
        Spark.get("/authorize", (req, res) -> {
            String code = req.queryParams("code");
            if (code == null) {
                res.status(400); // Bad Request
                return "No code provided.";
            }

            String state = req.queryParams("state");
            if (state == null) {
                res.status(400); // Bad Request
                return "No state provided. Contact developer of Discord bot.";
            }

            String auth = Base64.getEncoder().encodeToString(
                    "47655:oj6Y4OfdnOdRQnWteGK4YmL2V0T3Oc3vCdObc4Xh8GE".getBytes(StandardCharsets.UTF_8)
            );

            HttpURLConnection connection = null;
            OutputStream os = null;
            InputStream is = null;
            try {
                connection = (HttpURLConnection) new URI(TOKEN_URL).toURL().openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Authorization", "Basic " + auth);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setDoOutput(true);

                // write body
                os = connection.getOutputStream();
                os.write(("grant_type=authorization_code&code=" + code).getBytes(StandardCharsets.UTF_8));

                // get response body
                int responseCode = connection.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    res.status(responseCode);
                    return "Failed to get token: " + responseCode;
                }

                is = connection.getInputStream();
                String responseBody = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                System.out.println(responseBody);

                AuthData data = new AuthData(responseBody);
                setAuthData(state, data);

                handleEvent(eventMap.get(state), data);

                return responseBody;
            } catch (Exception e) {
                e.printStackTrace();
                res.status(500); // Internal Server Error
                return "Internal server error: " + e.getMessage();
            } finally {
                if (os != null) try {
                    os.close();
                } catch (Exception ignored) {
                }
                if (is != null) try {
                    is.close();
                } catch (Exception ignored) {
                }
                if (connection != null) connection.disconnect();
            }
        });
    }

    private static void handleEvent(GenericInteractionCreateEvent event, AuthData data) {
        if (event instanceof SlashCommandInteractionEvent) {
            SlashCommandInteractionEvent slashEvent = (SlashCommandInteractionEvent) event;

            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle(":ballot_box_with_check: Authorization Successful");

            try {
                AuthedDestinyRequest request = DestinyEndpoint.Authed.USER_GET_CURRENT_BUNGIE_NET_USER.hit("GET", data);
                WrapperGetCurrentBungieNetUser wrapper = request.getDestinyResponse(WrapperGetCurrentBungieNetUser.class).getResponse();


                embed.setDescription("You have successfully authorized with Destiny.")
                        .addField("Unique Name", wrapper.getUniqueName(), true)
                        .addField("Display Name", wrapper.getDisplayName(), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // edit with new embed and remove buttons
            // need to setACtionRow to empty list
            slashEvent.getHook().editOriginalEmbeds(embed.build()).setComponents().queue();
        }
    }

    public static void putEvent(String discordID, GenericInteractionCreateEvent event) {
        eventMap.put(discordID, event);
    }

    public static String autoAuthURL(String discordID) {
        return AUTH_URL + "&state=" + discordID;
    }

    public static AuthData getAuthData(String discordID) {
        return authData.get(discordID);
    }

    public static void setAuthData(String discordID, AuthData data) {
        authData.put(discordID, data);
    }

    public static void removeAuthData(String discordID) {
        authData.remove(discordID);
    }

    public static boolean hasAuthData(String discordID) {
        return authData.containsKey(discordID);
    }
}