package dev.wand.response.wrapper;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WrapperGetCurrentBungieNetUser {
    @JsonProperty("membershipId")
    private String membershipId;

    @JsonProperty("uniqueName")
    private String uniqueName;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("profilePicture")
    private int profilePicture;

    @JsonProperty("profileTheme")
    private int profileTheme;

    @JsonProperty("userTitle")
    private int userTitle;

    @JsonProperty("successMessageFlags")
    private String successMessageFlags;

    @JsonProperty("isDeleted")
    private boolean isDeleted;

    @JsonProperty("about")
    private String about;

    @JsonProperty("firstAccess")
    private String firstAccess;

    @JsonProperty("lastUpdate")
    private String lastUpdate;

    @JsonProperty("context")
    private Context context;

    @JsonProperty("xboxDisplayName")
    private String xboxDisplayName;

    @JsonProperty("showActivity")
    private boolean showActivity;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("localeInheritDefault")
    private boolean localeInheritDefault;

    @JsonProperty("showGroupMessaging")
    private boolean showGroupMessaging;

    @JsonProperty("profilePicturePath")
    private String profilePicturePath;

    @JsonProperty("profileThemeName")
    private String profileThemeName;

    @JsonProperty("userTitleDisplay")
    private String userTitleDisplay;

    @JsonProperty("statusText")
    private String statusText;

    @JsonProperty("statusDate")
    private String statusDate;

    @JsonProperty("steamDisplayName")
    private String steamDisplayName;

    @JsonProperty("cachedBungieGlobalDisplayName")
    private String cachedBungieGlobalDisplayName;

    @JsonProperty("cachedBungieGlobalDisplayNameCode")
    private int cachedBungieGlobalDisplayNameCode;

    @Data
    public static class Context {
        @JsonProperty("isFollowing")
        private boolean isFollowing;

        @JsonProperty("ignoreStatus")
        private IgnoreStatus ignoreStatus;

        @Data
        public static class IgnoreStatus {
            @JsonProperty("isIgnored")
            private boolean isIgnored;

            @JsonProperty("ignoreFlags")
            private int ignoreFlags;
        }
    }
}

