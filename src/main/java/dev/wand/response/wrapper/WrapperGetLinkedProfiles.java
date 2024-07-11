package dev.wand.response.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class WrapperGetLinkedProfiles {
    @JsonProperty("profiles")
    public ArrayList<Profile> getProfiles() {
        return this.profiles;
    }

    ArrayList<Profile> profiles;

    @JsonProperty("bnetMembership")
    public BnetMembership getBnetMembership() {
        return this.bnetMembership;
    }

    BnetMembership bnetMembership;

    @JsonProperty("profilesWithErrors")
    public ArrayList<Object> getProfilesWithErrors() {
        return this.profilesWithErrors;
    }

    ArrayList<Object> profilesWithErrors;

    public static class BnetMembership {
        @JsonProperty("supplementalDisplayName")
        public String getSupplementalDisplayName() {
            return this.supplementalDisplayName;
        }

        String supplementalDisplayName;

        @JsonProperty("iconPath")
        public String getIconPath() {
            return this.iconPath;
        }

        String iconPath;

        @JsonProperty("crossSaveOverride")
        public int getCrossSaveOverride() {
            return this.crossSaveOverride;
        }

        int crossSaveOverride;

        @JsonProperty("isPublic")
        public boolean getIsPublic() {
            return this.isPublic;
        }

        boolean isPublic;

        @JsonProperty("membershipType")
        public int getMembershipType() {
            return this.membershipType;
        }

        int membershipType;

        @JsonProperty("membershipId")
        public String getMembershipId() {
            return this.membershipId;
        }

        String membershipId;

        @JsonProperty("displayName")
        public String getDisplayName() {
            return this.displayName;
        }

        String displayName;

        @JsonProperty("bungieGlobalDisplayName")
        public String getBungieGlobalDisplayName() {
            return this.bungieGlobalDisplayName;
        }

        String bungieGlobalDisplayName;

        @JsonProperty("bungieGlobalDisplayNameCode")
        public int getBungieGlobalDisplayNameCode() {
            return this.bungieGlobalDisplayNameCode;
        }

        int bungieGlobalDisplayNameCode;
    }

    public static class BungieNext {
        @JsonProperty("itemHash")
        public Object getItemHash() {
            return this.itemHash;
        }

        Object itemHash;

        @JsonProperty("quantity")
        public int getQuantity() {
            return this.quantity;
        }

        int quantity;

        @JsonProperty("bindStatus")
        public int getBindStatus() {
            return this.bindStatus;
        }

        int bindStatus;

        @JsonProperty("location")
        public int getLocation() {
            return this.location;
        }

        int location;

        @JsonProperty("bucketHash")
        public int getBucketHash() {
            return this.bucketHash;
        }

        int bucketHash;

        @JsonProperty("transferStatus")
        public int getTransferStatus() {
            return this.transferStatus;
        }

        int transferStatus;

        @JsonProperty("lockable")
        public boolean getLockable() {
            return this.lockable;
        }

        boolean lockable;

        @JsonProperty("state")
        public int getState() {
            return this.state;
        }

        int state;

        @JsonProperty("dismantlePermission")
        public int getDismantlePermission() {
            return this.dismantlePermission;
        }

        int dismantlePermission;

        @JsonProperty("isWrapper")
        public boolean getIsWrapper() {
            return this.isWrapper;
        }

        boolean isWrapper;
    }

    public static class PlatformSilver {
        @JsonProperty("platformSilver")
        public PlatformSilver getPlatformSilver() {
            return this.platformSilver;
        }

        PlatformSilver platformSilver;

        @JsonProperty("TigerPsn")
        public TigerPsn getTigerPsn() {
            return this.tigerPsn;
        }

        TigerPsn tigerPsn;

        @JsonProperty("TigerXbox")
        public TigerXbox getTigerXbox() {
            return this.tigerXbox;
        }

        TigerXbox tigerXbox;

        @JsonProperty("TigerBlizzard")
        public TigerBlizzard getTigerBlizzard() {
            return this.tigerBlizzard;
        }

        TigerBlizzard tigerBlizzard;

        @JsonProperty("TigerStadia")
        public TigerStadia getTigerStadia() {
            return this.tigerStadia;
        }

        TigerStadia tigerStadia;

        @JsonProperty("TigerSteam")
        public TigerSteam getTigerSteam() {
            return this.tigerSteam;
        }

        TigerSteam tigerSteam;

        @JsonProperty("BungieNext")
        public BungieNext getBungieNext() {
            return this.bungieNext;
        }

        BungieNext bungieNext;

        @JsonProperty("TigerEgs")
        public TigerEgs getTigerEgs() {
            return this.tigerEgs;
        }

        TigerEgs tigerEgs;
    }

    public static class Profile {
        @JsonProperty("dateLastPlayed")
        public Date getDateLastPlayed() {
            return this.dateLastPlayed;
        }

        Date dateLastPlayed;

        @JsonProperty("isOverridden")
        public boolean getIsOverridden() {
            return this.isOverridden;
        }

        boolean isOverridden;

        @JsonProperty("isCrossSavePrimary")
        public boolean getIsCrossSavePrimary() {
            return this.isCrossSavePrimary;
        }

        boolean isCrossSavePrimary;

        @JsonProperty("platformSilver")
        public PlatformSilver getPlatformSilver() {
            return this.platformSilver;
        }

        PlatformSilver platformSilver;

        @JsonProperty("crossSaveOverride")
        public int getCrossSaveOverride() {
            return this.crossSaveOverride;
        }

        int crossSaveOverride;

        @JsonProperty("applicableMembershipTypes")
        public ArrayList<Integer> getApplicableMembershipTypes() {
            return this.applicableMembershipTypes;
        }

        ArrayList<Integer> applicableMembershipTypes;

        @JsonProperty("isPublic")
        public boolean getIsPublic() {
            return this.isPublic;
        }

        boolean isPublic;

        @JsonProperty("membershipType")
        public int getMembershipType() {
            return this.membershipType;
        }

        int membershipType;

        @JsonProperty("membershipId")
        public String getMembershipId() {
            return this.membershipId;
        }

        String membershipId;

        @JsonProperty("displayName")
        public String getDisplayName() {
            return this.displayName;
        }

        String displayName;

        @JsonProperty("bungieGlobalDisplayName")
        public String getBungieGlobalDisplayName() {
            return this.bungieGlobalDisplayName;
        }

        String bungieGlobalDisplayName;

        @JsonProperty("bungieGlobalDisplayNameCode")
        public int getBungieGlobalDisplayNameCode() {
            return this.bungieGlobalDisplayNameCode;
        }

        int bungieGlobalDisplayNameCode;
    }

    public static class TigerBlizzard {
        @JsonProperty("itemHash")
        public Object getItemHash() {
            return this.itemHash;
        }

        Object itemHash;

        @JsonProperty("quantity")
        public int getQuantity() {
            return this.quantity;
        }

        int quantity;

        @JsonProperty("bindStatus")
        public int getBindStatus() {
            return this.bindStatus;
        }

        int bindStatus;

        @JsonProperty("location")
        public int getLocation() {
            return this.location;
        }

        int location;

        @JsonProperty("bucketHash")
        public Object getBucketHash() {
            return this.bucketHash;
        }

        Object bucketHash;

        @JsonProperty("transferStatus")
        public int getTransferStatus() {
            return this.transferStatus;
        }

        int transferStatus;

        @JsonProperty("lockable")
        public boolean getLockable() {
            return this.lockable;
        }

        boolean lockable;

        @JsonProperty("state")
        public int getState() {
            return this.state;
        }

        int state;

        @JsonProperty("dismantlePermission")
        public int getDismantlePermission() {
            return this.dismantlePermission;
        }

        int dismantlePermission;

        @JsonProperty("isWrapper")
        public boolean getIsWrapper() {
            return this.isWrapper;
        }

        boolean isWrapper;
    }

    public static class TigerEgs {
        @JsonProperty("itemHash")
        public Object getItemHash() {
            return this.itemHash;
        }

        Object itemHash;

        @JsonProperty("quantity")
        public int getQuantity() {
            return this.quantity;
        }

        int quantity;

        @JsonProperty("bindStatus")
        public int getBindStatus() {
            return this.bindStatus;
        }

        int bindStatus;

        @JsonProperty("location")
        public int getLocation() {
            return this.location;
        }

        int location;

        @JsonProperty("bucketHash")
        public int getBucketHash() {
            return this.bucketHash;
        }

        int bucketHash;

        @JsonProperty("transferStatus")
        public int getTransferStatus() {
            return this.transferStatus;
        }

        int transferStatus;

        @JsonProperty("lockable")
        public boolean getLockable() {
            return this.lockable;
        }

        boolean lockable;

        @JsonProperty("state")
        public int getState() {
            return this.state;
        }

        int state;

        @JsonProperty("dismantlePermission")
        public int getDismantlePermission() {
            return this.dismantlePermission;
        }

        int dismantlePermission;

        @JsonProperty("isWrapper")
        public boolean getIsWrapper() {
            return this.isWrapper;
        }

        boolean isWrapper;
    }

    public static class TigerPsn {
        @JsonProperty("itemHash")
        public Object getItemHash() {
            return this.itemHash;
        }

        Object itemHash;

        @JsonProperty("quantity")
        public int getQuantity() {
            return this.quantity;
        }

        int quantity;

        @JsonProperty("bindStatus")
        public int getBindStatus() {
            return this.bindStatus;
        }

        int bindStatus;

        @JsonProperty("location")
        public int getLocation() {
            return this.location;
        }

        int location;

        @JsonProperty("bucketHash")
        public Object getBucketHash() {
            return this.bucketHash;
        }

        Object bucketHash;

        @JsonProperty("transferStatus")
        public int getTransferStatus() {
            return this.transferStatus;
        }

        int transferStatus;

        @JsonProperty("lockable")
        public boolean getLockable() {
            return this.lockable;
        }

        boolean lockable;

        @JsonProperty("state")
        public int getState() {
            return this.state;
        }

        int state;

        @JsonProperty("dismantlePermission")
        public int getDismantlePermission() {
            return this.dismantlePermission;
        }

        int dismantlePermission;

        @JsonProperty("isWrapper")
        public boolean getIsWrapper() {
            return this.isWrapper;
        }

        boolean isWrapper;
    }

    public static class TigerStadia {
        @JsonProperty("itemHash")
        public Object getItemHash() {
            return this.itemHash;
        }

        Object itemHash;

        @JsonProperty("quantity")
        public int getQuantity() {
            return this.quantity;
        }

        int quantity;

        @JsonProperty("bindStatus")
        public int getBindStatus() {
            return this.bindStatus;
        }

        int bindStatus;

        @JsonProperty("location")
        public int getLocation() {
            return this.location;
        }

        int location;

        @JsonProperty("bucketHash")
        public Object getBucketHash() {
            return this.bucketHash;
        }

        Object bucketHash;

        @JsonProperty("transferStatus")
        public int getTransferStatus() {
            return this.transferStatus;
        }

        int transferStatus;

        @JsonProperty("lockable")
        public boolean getLockable() {
            return this.lockable;
        }

        boolean lockable;

        @JsonProperty("state")
        public int getState() {
            return this.state;
        }

        int state;

        @JsonProperty("dismantlePermission")
        public int getDismantlePermission() {
            return this.dismantlePermission;
        }

        int dismantlePermission;

        @JsonProperty("isWrapper")
        public boolean getIsWrapper() {
            return this.isWrapper;
        }

        boolean isWrapper;
    }

    public static class TigerSteam {
        @JsonProperty("itemHash")
        public Object getItemHash() {
            return this.itemHash;
        }

        Object itemHash;

        @JsonProperty("quantity")
        public int getQuantity() {
            return this.quantity;
        }

        int quantity;

        @JsonProperty("bindStatus")
        public int getBindStatus() {
            return this.bindStatus;
        }

        int bindStatus;

        @JsonProperty("location")
        public int getLocation() {
            return this.location;
        }

        int location;

        @JsonProperty("bucketHash")
        public int getBucketHash() {
            return this.bucketHash;
        }

        int bucketHash;

        @JsonProperty("transferStatus")
        public int getTransferStatus() {
            return this.transferStatus;
        }

        int transferStatus;

        @JsonProperty("lockable")
        public boolean getLockable() {
            return this.lockable;
        }

        boolean lockable;

        @JsonProperty("state")
        public int getState() {
            return this.state;
        }

        int state;

        @JsonProperty("dismantlePermission")
        public int getDismantlePermission() {
            return this.dismantlePermission;
        }

        int dismantlePermission;

        @JsonProperty("isWrapper")
        public boolean getIsWrapper() {
            return this.isWrapper;
        }

        boolean isWrapper;
    }

    public static class TigerXbox {
        @JsonProperty("itemHash")
        public Object getItemHash() {
            return this.itemHash;
        }

        Object itemHash;

        @JsonProperty("quantity")
        public int getQuantity() {
            return this.quantity;
        }

        int quantity;

        @JsonProperty("bindStatus")
        public int getBindStatus() {
            return this.bindStatus;
        }

        int bindStatus;

        @JsonProperty("location")
        public int getLocation() {
            return this.location;
        }

        int location;

        @JsonProperty("bucketHash")
        public Object getBucketHash() {
            return this.bucketHash;
        }

        Object bucketHash;

        @JsonProperty("transferStatus")
        public int getTransferStatus() {
            return this.transferStatus;
        }

        int transferStatus;

        @JsonProperty("lockable")
        public boolean getLockable() {
            return this.lockable;
        }

        boolean lockable;

        @JsonProperty("state")
        public int getState() {
            return this.state;
        }

        int state;

        @JsonProperty("dismantlePermission")
        public int getDismantlePermission() {
            return this.dismantlePermission;
        }

        int dismantlePermission;

        @JsonProperty("isWrapper")
        public boolean getIsWrapper() {
            return this.isWrapper;
        }

        boolean isWrapper;
    }
}

