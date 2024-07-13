package dev.wand.response.wrapper;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.wand.endpoint.DestinyEndpoint;
import dev.wand.request.GenericDestinyRequest;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
public class WrapperGetProfile {
    @JsonProperty("responseMintedTimestamp")
    private String responseMintedTimestamp;

    @JsonProperty("secondaryComponentsMintedTimestamp")
    private String secondaryComponentsMintedTimestamp;

    @JsonProperty("characterInventories")
    public CharacterInventories characterInventories;

    @JsonProperty("profile")
    Profile profile;

    @Getter
    public static class Profile {
        @JsonProperty("data")
        Data data;

        @JsonProperty("privacy")
        private float privacy;
    }

    @Getter
    public static class Data {
        @JsonProperty("userInfo")
        UserInfo userInfo;

        @JsonProperty("dateLastPlayed")
        private String dateLastPlayed;

        @JsonProperty("versionsOwned")
        private float versionsOwned;

        @JsonProperty("characterIds")
        ArrayList<Object> characterIds = new ArrayList<Object>();

        @JsonProperty("seasonHashes")
        ArrayList<Object> seasonHashes = new ArrayList<Object>();

        @JsonProperty("eventCardHashesOwned")
        ArrayList<Object> eventCardHashesOwned = new ArrayList<Object>();

        @JsonProperty("currentSeasonHash")
        private float currentSeasonHash;

        @JsonProperty("currentSeasonRewardPowerCap")
        private float currentSeasonRewardPowerCap;

        @JsonProperty("currentGuardianRank")
        private float currentGuardianRank;

        @JsonProperty("lifetimeHighestGuardianRank")
        private float lifetimeHighestGuardianRank;

        @JsonProperty("renewedGuardianRank")
        private float renewedGuardianRank;
    }

    @Getter
    public static class UserInfo {
        @JsonProperty("crossSaveOverride")
        private float crossSaveOverride;

        @JsonProperty("applicableMembershipTypes")
        ArrayList<Object> applicableMembershipTypes = new ArrayList<Object>();

        @JsonProperty("isPublic")
        private boolean isPublic;

        @JsonProperty("membershipType")
        private float membershipType;

        @JsonProperty("membershipId")
        private String membershipId;

        @JsonProperty("displayName")
        private String displayName;

        @JsonProperty("bungieGlobalDisplayName")
        private String bungieGlobalDisplayName;

        @JsonProperty("bungieGlobalDisplayNameCode")
        private float bungieGlobalDisplayNameCode;
    }

    @Getter
    public static class CharacterInventories {
        @JsonProperty("data")
        private CharacterData data;

        @JsonProperty("privacy")
        private int privacy;
    }

    @Getter
    public static class CharacterData {
        private Map<String, CharacterInventory> characters = new HashMap<>();

        @JsonAnySetter
        public void setCharacter(String key, CharacterInventory value) {
            this.characters.put(key, value);
        }

    }

    @Getter
    public static class CharacterInventory {
        @JsonProperty("items")
        private ArrayList<Item> items;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class Item {

        public WrapperManifestItem getItemDefinition() throws IOException {
            // request item definition from the manifest
            GenericDestinyRequest request = DestinyEndpoint.Generic.DESTINY2_SEARCH_MANIFEST
                    .hitWithPath("GET",
                            Map.of(
                                    "entityType", "DestinyInventoryItemDefinition",
                                    "hashIdentifier", itemHash)
                    );
            return request.getDestinyResponse(WrapperManifestItem.class).getResponse();
        }

        @JsonProperty("itemHash")
        private String itemHash;

        @JsonProperty("itemInstanceId")
        private String itemInstanceId;

        @JsonProperty("quantity")
        private int quantity;

        @JsonProperty("bindStatus")
        private int bindStatus;

        @JsonProperty("location")
        private int location;

        @JsonProperty("bucketHash")
        private Object bucketHash;

        @JsonProperty("transferStatus")
        private int transferStatus;

        @JsonProperty("lockable")
        private boolean lockable;

        @JsonProperty("state")
        private int state;

        @JsonProperty("dismantlePermission")
        private int dismantlePermission;

        @JsonProperty("isWrapper")
        private boolean isWrapper;

        @JsonProperty("tooltipNotificationIndexes")
        private ArrayList<Integer> tooltipNotificationIndexes;

        @JsonProperty("versionNumber")
        private int versionNumber;

        @JsonProperty("metricHash")
        private long metricHash;

        @JsonProperty("metricObjective")
        private MetricObjective metricObjective;

        @JsonProperty("itemValueVisibility")
        private ArrayList<Boolean> itemValueVisibility;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class MetricObjective {
        @JsonProperty("objectiveHash")
        private int objectiveHash;

        @JsonProperty("progress")
        private int progress;

        @JsonProperty("completionValue")
        private int completionValue;

        @JsonProperty("complete")
        private boolean complete;

        @JsonProperty("visible")
        private boolean visible;
    }
}
