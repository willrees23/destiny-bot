package dev.wand.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.wand.Main;
import dev.wand.auth.AuthData;
import lombok.experimental.UtilityClass;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@UtilityClass
public class ItemUtil {

    public boolean transferItem(AuthData authData, String itemRefHash, int stackSize, boolean toVault, String itemId, String characterId, int membershipType) {
        Map<String, Object> map = Map.of(
                "itemReferenceHash", itemRefHash,
                "stackSize", stackSize,
                "transferToVault", toVault,
                "itemId", itemId,
                "characterId", characterId,
                "membershipType", membershipType
        );

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(map);

            System.out.print(body);

            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost("https://www.bungie.net/Platform/Destiny2/Actions/Items/TransferItem/");
            post.addHeader("Authorization", "Bearer " + authData.getAccessToken());
            // add api key
            post.addHeader("X-Api-Key", Main.DESTINY_API_KEY);
            post.addHeader("Content-Type", "application/json");
            post.setEntity(new StringEntity(body));
            try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(post)) {
                int status = response.getStatusLine().getStatusCode();
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                if (status != 200) {
                    System.out.print(
// read every line
                            reader.lines().map(Object::toString).reduce("", (a, b) -> a + b)
                    );
                    return false;
                }


                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (UnsupportedEncodingException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
