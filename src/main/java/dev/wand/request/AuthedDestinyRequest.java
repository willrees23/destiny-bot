package dev.wand.request;

import dev.wand.auth.AuthData;
import dev.wand.auth.AuthHandler;
import lombok.Getter;
import net.dv8tion.jda.api.entities.User;

import java.io.IOException;

@Getter
public class AuthedDestinyRequest extends GenericDestinyRequest {
    private final String authToken;

    public AuthedDestinyRequest(String endpoint, String method, String authToken) throws IOException {
        super(endpoint, method);
        this.authToken = authToken;
        addHeader("Authorization", "Bearer " + authToken); // Example of adding an auth header

        build();
    }

    public AuthedDestinyRequest(String endpoint, String method, AuthData data) throws IOException {
        super(endpoint, method);
        this.authToken = data.getAccessToken();
        addHeader("Authorization", "Bearer " + authToken); // Example of adding an auth header

        build();
    }

    public AuthedDestinyRequest(String endpoint, String method, User user) throws IOException {
        super(endpoint, method);
        this.authToken = AuthHandler.getAuthData(user.getId()).getAccessToken();
        addHeader("Authorization", "Bearer " + authToken); // Example of adding an auth header

        build();
    }
}