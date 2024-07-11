package dev.wand.endpoint;

import dev.wand.auth.AuthData;
import dev.wand.request.AuthedDestinyRequest;
import dev.wand.request.DestinyRequest;
import dev.wand.request.GenericDestinyRequest;
import dev.wand.response.wrapper.WrapperGetCurrentBungieNetUser;
import lombok.Getter;

import java.io.IOException;
import java.util.Map;

public interface DestinyEndpoint {

    static DestinyRequest custom(String endpoint, String method, AuthData data) {
        StringBuilder url = new StringBuilder("https://www.bungie.net/Platform" + endpoint);

        try {
            return new AuthedDestinyRequest(url.toString(), method, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static StringBuilder getStringBuilder(Map<String, String> pathParams, Map<String, String> queryParams, StringBuilder url) {
        for (Map.Entry<String, String> entry : pathParams.entrySet()) {
            url = new StringBuilder(url.toString().replace("{" + entry.getKey() + "}", entry.getValue()));
        }

        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            url.append("?").append(entry.getKey()).append("=").append(entry.getValue());
        }
        return url;
    }

    String getEndpoint();

    default String getBaseURL() {
        return "https://www.bungie.net/Platform";
    }

    default String getURL() {
        return getBaseURL() + getEndpoint();
    }

    enum Authed implements DestinyEndpoint {
        USER_GET_CURRENT_BUNGIE_NET_USER("/User/GetCurrentBungieNetUser/"),
        DESTINY2_GET_PROFILE("/Destiny2/{membershipType}/Profile/{destinyMembershipId}/"),
        DESTINY2_GET_LINKED_PROFILES("/Destiny2/{membershipType}/Profile/{destinyMembershipId}/LinkedProfiles/"),
        ;

        private final String endpoint;

        Authed(String endpoint) {
            this.endpoint = endpoint;
        }

        @Override
        public String getEndpoint() {
            return endpoint;
        }

        // hit method that takes authdata + multiple replacement keys and values

        public AuthedDestinyRequest hitWithPath(String method, AuthData data, Map<String, String> pathParams) throws IOException {

            StringBuilder url = new StringBuilder(getURL());
            for (Map.Entry<String, String> entry : pathParams.entrySet()) {
                url = new StringBuilder(url.toString().replace("{" + entry.getKey() + "}", entry.getValue()));
            }

            return new AuthedDestinyRequest(url.toString(), method, data);
        }

        public AuthedDestinyRequest hitWithQuery(String method, AuthData data, Map<String, String> queryParams) throws IOException {

            StringBuilder url = new StringBuilder(getURL());

            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                url.append("?").append(entry.getKey()).append("=").append(entry.getValue());
            }

            return new AuthedDestinyRequest(url.toString(), method, data);
        }

        public AuthedDestinyRequest hit(String method, AuthData data, Map<String, String> pathParams, Map<String, String> queryParams) throws IOException {

            StringBuilder url = new StringBuilder(getURL());
            url = getStringBuilder(pathParams, queryParams, url);

            return new AuthedDestinyRequest(url.toString(), method, data);
        }

        public AuthedDestinyRequest hit(String method, AuthData data) throws IOException {
            return new AuthedDestinyRequest(getURL(), method, data);
        }
    }

    enum Generic implements DestinyEndpoint {
        ;

        private final String endpoint;

        Generic(String endpoint) {
            this.endpoint = endpoint;
        }

        @Override
        public String getEndpoint() {
            return endpoint;
        }

        public GenericDestinyRequest hit(String method) throws IOException {
            return new GenericDestinyRequest(getURL(), method);
        }
    }
}
