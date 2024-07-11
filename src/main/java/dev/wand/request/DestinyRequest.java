package dev.wand.request;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.wand.response.DestinyResponse;
import dev.wand.util.ApiUtil;
import lombok.Getter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class DestinyRequest {

    protected String endpoint;
    protected String method;
    protected Map<String, String> headers;
    protected Map<String, String> params;

    // store result HttpURLConnection
    HttpURLConnection connection;

    protected void printDebug() throws IOException {
        int code = connection.getResponseCode();
        System.out.println(method.toUpperCase() + " -> " + endpoint + " -> " + code + " " + ApiUtil.getResponseMessage(code));
    }

    public DestinyRequest(String endpoint, String method) {
        this.endpoint = endpoint;
        this.method = method;
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
    }

    public String getBody() {
        // get the body of the response
        byte[] body = new byte[0];
        try {
            body = connection.getInputStream().readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(body, StandardCharsets.UTF_8);
    }

    public String getError() {
        // get the body of the response
        byte[] body = new byte[0];
        try {
            body = connection.getErrorStream().readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(body, StandardCharsets.UTF_8);
    }

    public <T> DestinyResponse<T> getDestinyResponse(Class<T> responseType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructParametricType(DestinyResponse.class, responseType);
        DestinyResponse<T> apiResponse = mapper.readValue(getBody(), type);
        return apiResponse;
    }


    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public void addParam(String key, String value) {
        this.params.put(key, value);
    }

    public HttpURLConnection buildRequest() throws IOException {
        URL url = new URL(endpoint + "?" + getParamsString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        return connection;
    }

    protected void build() {
        try {
            this.connection = buildRequest();
            connection.setReadTimeout(5000);
            printDebug();
        } catch (IOException e) {
            System.out.println("Error building request");
        }
    }

    protected String getParamsString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            result.append("&");
        }

        String resultString = result.toString();
        return !resultString.isEmpty() ? resultString.substring(0, resultString.length() - 1) : resultString;
    }
}
