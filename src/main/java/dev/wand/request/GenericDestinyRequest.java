package dev.wand.request;

import dev.wand.Main;
import dev.wand.auth.AuthHandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class GenericDestinyRequest extends DestinyRequest {

    public GenericDestinyRequest(String endpoint, String method) throws IOException {
        super(endpoint, method);
        addHeader("X-API-Key", Main.DESTINY_API_KEY);

        this.connection = buildRequest();
    }
}

