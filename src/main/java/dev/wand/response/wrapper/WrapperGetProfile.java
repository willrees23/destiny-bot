package dev.wand.response.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class WrapperGetProfile {
    @JsonProperty("responseMintedTimestamp")
    private String responseMintedTimestamp;

    @JsonProperty("secondaryComponentsMintedTimestamp")
    private String secondaryComponentsMintedTimestamp;

    @JsonProperty("profile")
    Profile profile;

    @Getter
    public class Profile {
        @JsonProperty("data")
        Data data;

        @JsonProperty("privacy")
        private float privacy;
    }

    @Getter
    public class Data {
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
    public class UserInfo {
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
}
