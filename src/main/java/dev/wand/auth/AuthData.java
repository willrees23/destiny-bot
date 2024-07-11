package dev.wand.auth;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

@Data
/**
 * Represents the data returned from the Bungie API when authenticating.
 * This data is used to authenticate requests to the API.
 */
public class AuthData {

    private String accessToken;
    private String tokenType;
    private int expiresIn;
    private String refreshToken;
    private int refreshExpiresIn;
    private String membershipId;
    private long createdAt;

    public AuthData(JsonObject json) {
        this.accessToken = json.get("access_token").getAsString();
        this.tokenType = json.get("token_type").getAsString();
        this.expiresIn = json.get("expires_in").getAsInt();
        this.refreshToken = json.get("refresh_token").getAsString();
        this.refreshExpiresIn = json.get("refresh_expires_in").getAsInt();
        this.membershipId = json.get("membership_id").getAsString();
        this.createdAt = System.currentTimeMillis();
    }

    public AuthData(String jsonString) {
        this(JsonParser.parseString(jsonString).getAsJsonObject());
    }

    public boolean isAccessExpired() {
        return System.currentTimeMillis() - createdAt > expiresIn * 1000L;
    }

    public int getAccessTimeRemaining() {
        long timePassed = System.currentTimeMillis() - createdAt;
        return (int) (expiresIn - timePassed / 1000);
    }
}
