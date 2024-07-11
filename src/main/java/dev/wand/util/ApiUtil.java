package dev.wand.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiUtil {

    public String getResponseMessage(int responseCode) {
        return switch (responseCode) {
            case 200 -> "Success";
            case 201 -> "Created";
            case 204 -> "No Content";
            case 400 -> "Bad Request";
            case 401 -> "Unauthorized";
            case 403 -> "Forbidden";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            case 502 -> "Bad Gateway";
            case 503 -> "Service Unavailable";
            default -> "Unknown Response Code";
        };
    }
}
