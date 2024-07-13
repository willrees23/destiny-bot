package dev.wand.response.wrapper;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WrapperManifestItem {

    @JsonProperty("displayProperties")
    public DisplayProperties getDisplayProperties() {
        return this.displayProperties;
    }

    private DisplayProperties displayProperties;

    @JsonProperty("tooltipNotifications")
    public ArrayList<Object> getTooltipNotifications() {
        return this.tooltipNotifications;
    }

    private ArrayList<Object> tooltipNotifications;

    @JsonProperty("collectibleHash")
    public String getCollectibleHash() {
        return this.collectibleHash;
    }

    private String collectibleHash;

    @JsonProperty("iconWatermark")
    public String getIconWatermark() {
        return this.iconWatermark;
    }

    private String iconWatermark;

    @JsonProperty("iconWatermarkShelved")
    public String getIconWatermarkShelved() {
        return this.iconWatermarkShelved;
    }

    private String iconWatermarkShelved;

    @JsonProperty("backgroundColor")
    public BackgroundColor getBackgroundColor() {
        return this.backgroundColor;
    }

    private BackgroundColor backgroundColor;

    @JsonProperty("screenshot")
    public String getScreenshot() {
        return this.screenshot;
    }

    private String screenshot;

    @JsonProperty("itemTypeDisplayName")
    public String getItemTypeDisplayName() {
        return this.itemTypeDisplayName;
    }

    private String itemTypeDisplayName;

    @JsonProperty("flavorText")
    public String getFlavorText() {
        return this.flavorText;
    }

    private String flavorText;

    @JsonProperty("uiItemDisplayStyle")
    public String getUiItemDisplayStyle() {
        return this.uiItemDisplayStyle;
    }

    private String uiItemDisplayStyle;

    @JsonProperty("itemTypeAndTierDisplayName")
    public String getItemTypeAndTierDisplayName() {
        return this.itemTypeAndTierDisplayName;
    }

    private String itemTypeAndTierDisplayName;

    @JsonProperty("displaySource")
    public String getDisplaySource() {
        return this.displaySource;
    }

    private String displaySource;

    @JsonProperty("action")
    public Action getAction() {
        return this.action;
    }

    private Action action;

    @JsonProperty("inventory")
    public Inventory getInventory() {
        return this.inventory;
    }

    private Inventory inventory;

    @JsonProperty("stats")
    public Stats getStats() {
        return this.stats;
    }

    private Stats stats;

    @JsonProperty("equippingBlock")
    public EquippingBlock getEquippingBlock() {
        return this.equippingBlock;
    }

    private EquippingBlock equippingBlock;

    @JsonProperty("translationBlock")
    public TranslationBlock getTranslationBlock() {
        return this.translationBlock;
    }

    private TranslationBlock translationBlock;

    @JsonProperty("preview")
    public Preview getPreview() {
        return this.preview;
    }

    private Preview preview;

    @JsonProperty("quality")
    public Quality getQuality() {
        return this.quality;
    }

    private Quality quality;

    @JsonProperty("objectives")
    public Objectives getObjectives() {
        return this.objectives;
    }

    private Objectives objectives;

    @JsonProperty("acquireRewardSiteHash")
    public String getAcquireRewardSiteHash() {
        return this.acquireRewardSiteHash;
    }

    private String acquireRewardSiteHash;

    @JsonProperty("acquireUnlockHash")
    public String getAcquireUnlockHash() {
        return this.acquireUnlockHash;
    }

    private String acquireUnlockHash;

    @JsonProperty("sockets")
    public Sockets getSockets() {
        return this.sockets;
    }

    private Sockets sockets;

    @JsonProperty("talentGrid")
    public TalentGrid getTalentGrid() {
        return this.talentGrid;
    }

    private TalentGrid talentGrid;

    @JsonProperty("investmentStats")
    public ArrayList<InvestmentStat> getInvestmentStats() {
        return this.investmentStats;
    }

    private ArrayList<InvestmentStat> investmentStats;

    @JsonProperty("perks")
    public ArrayList<Perk> getPerks() {
        return this.perks;
    }

    private ArrayList<Perk> perks;

    @JsonProperty("loreHash")
    public long getLoreHash() {
        return this.loreHash;
    }

    private long loreHash;

    @JsonProperty("summaryItemHash")
    public long getSummaryItemHash() {
        return this.summaryItemHash;
    }

    private long summaryItemHash;

    @JsonProperty("allowActions")
    public boolean getAllowActions() {
        return this.allowActions;
    }

    private boolean allowActions;

    @JsonProperty("doesPostmasterPullHaveSideEffects")
    public boolean getDoesPostmasterPullHaveSideEffects() {
        return this.doesPostmasterPullHaveSideEffects;
    }

    private boolean doesPostmasterPullHaveSideEffects;

    @JsonProperty("nonTransferrable")
    public boolean getNonTransferrable() {
        return this.nonTransferrable;
    }

    private boolean nonTransferrable;

    @JsonProperty("itemCategoryHashes")
    public ArrayList<String> getItemCategoryHashes() {
        return this.itemCategoryHashes;
    }

    private ArrayList<String> itemCategoryHashes;

    @JsonProperty("specialItemType")
    public int getSpecialItemType() {
        return this.specialItemType;
    }

    private int specialItemType;

    @JsonProperty("itemType")
    public int getItemType() {
        return this.itemType;
    }

    private int itemType;

    @JsonProperty("itemSubType")
    public int getItemSubType() {
        return this.itemSubType;
    }

    private int itemSubType;

    @JsonProperty("classType")
    public int getClassType() {
        return this.classType;
    }

    private int classType;

    @JsonProperty("breakerType")
    public int getBreakerType() {
        return this.breakerType;
    }

    private int breakerType;

    @JsonProperty("equippable")
    public boolean getEquippable() {
        return this.equippable;
    }

    private boolean equippable;

    @JsonProperty("damageTypeHashes")
    public ArrayList<String> getDamageTypeHashes() {
        return this.damageTypeHashes;
    }

    private ArrayList<String> damageTypeHashes;

    @JsonProperty("damageTypes")
    public ArrayList<Integer> getDamageTypes() {
        return this.damageTypes;
    }

    private ArrayList<Integer> damageTypes;

    @JsonProperty("defaultDamageType")
    public int getDefaultDamageType() {
        return this.defaultDamageType;
    }

    private int defaultDamageType;

    @JsonProperty("defaultDamageTypeHash")
    public String getDefaultDamageTypeHash() {
        return this.defaultDamageTypeHash;
    }

    private String defaultDamageTypeHash;

    @JsonProperty("isWrapper")
    public boolean getIsWrapper() {
        return this.isWrapper;
    }

    private boolean isWrapper;

    @JsonProperty("traitIds")
    public ArrayList<String> getTraitIds() {
        return this.traitIds;
    }

    private ArrayList<String> traitIds;

    @JsonProperty("traitHashes")
    public ArrayList<String> getTraitHashes() {
        return this.traitHashes;
    }

    private ArrayList<String> traitHashes;

    @JsonProperty("hash")
    public long getHash() {
        return this.hash;
    }

    private long hash;

    @JsonProperty("index")
    public int getIndex() {
        return this.index;
    }

    private int index;

    @JsonProperty("redacted")
    public boolean getRedacted() {
        return this.redacted;
    }

    private boolean redacted;

    @JsonProperty("blacklisted")
    public boolean getBlacklisted() {
        return this.blacklisted;
    }

    private boolean blacklisted;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Action {
        @JsonProperty("verbName")
        public String getVerbName() {
            return this.verbName;
        }

        private String verbName;

        @JsonProperty("verbDescription")
        public String getVerbDescription() {
            return this.verbDescription;
        }

        private String verbDescription;

        @JsonProperty("isPositive")
        public boolean getIsPositive() {
            return this.isPositive;
        }

        private boolean isPositive;

        @JsonProperty("requiredCooldownSeconds")
        public int getRequiredCooldownSeconds() {
            return this.requiredCooldownSeconds;
        }

        private int requiredCooldownSeconds;

        @JsonProperty("requiredItems")
        public ArrayList<Object> getRequiredItems() {
            return this.requiredItems;
        }

        private ArrayList<Object> requiredItems;

        @JsonProperty("progressionRewards")
        public ArrayList<Object> getProgressionRewards() {
            return this.progressionRewards;
        }

        private ArrayList<Object> progressionRewards;

        @JsonProperty("actionTypeLabel")
        public String getActionTypeLabel() {
            return this.actionTypeLabel;
        }

        private String actionTypeLabel;

        @JsonProperty("rewardSheetHash")
        public String getRewardSheetHash() {
            return this.rewardSheetHash;
        }

        private String rewardSheetHash;

        @JsonProperty("rewardItemHash")
        public String getRewardItemHash() {
            return this.rewardItemHash;
        }

        private String rewardItemHash;

        @JsonProperty("rewardSiteHash")
        public String getRewardSiteHash() {
            return this.rewardSiteHash;
        }

        private String rewardSiteHash;

        @JsonProperty("requiredCooldownHash")
        public String getRequiredCooldownHash() {
            return this.requiredCooldownHash;
        }

        private String requiredCooldownHash;

        @JsonProperty("deleteOnAction")
        public boolean getDeleteOnAction() {
            return this.deleteOnAction;
        }

        private boolean deleteOnAction;

        @JsonProperty("consumeEntireStack")
        public boolean getConsumeEntireStack() {
            return this.consumeEntireStack;
        }

        private boolean consumeEntireStack;

        @JsonProperty("useOnAcquire")
        public boolean getUseOnAcquire() {
            return this.useOnAcquire;
        }

        private boolean useOnAcquire;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Arrangement {
        @JsonProperty("classHash")
        public String getClassHash() {
            return this.classHash;
        }

        private String classHash;

        @JsonProperty("artArrangementHash")
        public long getArtArrangementHash() {
            return this.artArrangementHash;
        }

        private long artArrangementHash;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BackgroundColor {
        @JsonProperty("red")
        public int getRed() {
            return this.red;
        }

        private int red;

        @JsonProperty("green")
        public int getGreen() {
            return this.green;
        }

        private int green;

        @JsonProperty("blue")
        public int getBlue() {
            return this.blue;
        }

        private int blue;

        @JsonProperty("alpha")
        public int getAlpha() {
            return this.alpha;
        }

        private int alpha;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DisplayProperties {
        @JsonProperty("description")
        public String getDescription() {
            return this.description;
        }

        private String description;

        @JsonProperty("name")
        public String getName() {
            return this.name;
        }

        private String name;

        @JsonProperty("icon")
        public String getIcon() {
            return this.icon;
        }

        private String icon;

        @JsonProperty("hasIcon")
        public boolean getHasIcon() {
            return this.hasIcon;
        }

        private boolean hasIcon;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EquippingBlock {
        @JsonProperty("uniqueLabel")
        public String getUniqueLabel() {
            return this.uniqueLabel;
        }

        private String uniqueLabel;

        @JsonProperty("uniqueLabelHash")
        public long getUniqueLabelHash() {
            return this.uniqueLabelHash;
        }

        private long uniqueLabelHash;

        @JsonProperty("equipmentSlotTypeHash")
        public long getEquipmentSlotTypeHash() {
            return this.equipmentSlotTypeHash;
        }

        private long equipmentSlotTypeHash;

        @JsonProperty("attributes")
        public int getAttributes() {
            return this.attributes;
        }

        private int attributes;

        @JsonProperty("equippingSoundHash")
        public String getEquippingSoundHash() {
            return this.equippingSoundHash;
        }

        private String equippingSoundHash;

        @JsonProperty("hornSoundHash")
        public String getHornSoundHash() {
            return this.hornSoundHash;
        }

        private String hornSoundHash;

        @JsonProperty("ammoType")
        public int getAmmoType() {
            return this.ammoType;
        }

        private int ammoType;

        @JsonProperty("displayStrings")
        public ArrayList<String> getDisplayStrings() {
            return this.displayStrings;
        }

        private ArrayList<String> displayStrings;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IntrinsicSocket {
        @JsonProperty("plugItemHash")
        public long getPlugItemHash() {
            return this.plugItemHash;
        }

        private long plugItemHash;

        @JsonProperty("socketTypeHash")
        public long getSocketTypeHash() {
            return this.socketTypeHash;
        }

        private long socketTypeHash;

        @JsonProperty("defaultVisible")
        public boolean getDefaultVisible() {
            return this.defaultVisible;
        }

        private boolean defaultVisible;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Inventory {
        @JsonProperty("maxStackSize")
        public int getMaxStackSize() {
            return this.maxStackSize;
        }

        private int maxStackSize;

        @JsonProperty("bucketTypeHash")
        public long getBucketTypeHash() {
            return this.bucketTypeHash;
        }

        private long bucketTypeHash;

        @JsonProperty("recoveryBucketTypeHash")
        public String getRecoveryBucketTypeHash() {
            return this.recoveryBucketTypeHash;
        }

        private String recoveryBucketTypeHash;

        @JsonProperty("tierTypeHash")
        public long getTierTypeHash() {
            return this.tierTypeHash;
        }

        private long tierTypeHash;

        @JsonProperty("isInstanceItem")
        public boolean getIsInstanceItem() {
            return this.isInstanceItem;
        }

        private boolean isInstanceItem;

        @JsonProperty("nonTransferrableOriginal")
        public boolean getNonTransferrableOriginal() {
            return this.nonTransferrableOriginal;
        }

        private boolean nonTransferrableOriginal;

        @JsonProperty("tierTypeName")
        public String getTierTypeName() {
            return this.tierTypeName;
        }

        private String tierTypeName;

        @JsonProperty("tierType")
        public int getTierType() {
            return this.tierType;
        }

        private int tierType;

        @JsonProperty("expirationTooltip")
        public String getExpirationTooltip() {
            return this.expirationTooltip;
        }

        private String expirationTooltip;

        @JsonProperty("expiredInActivityMessage")
        public String getExpiredInActivityMessage() {
            return this.expiredInActivityMessage;
        }

        private String expiredInActivityMessage;

        @JsonProperty("expiredInOrbitMessage")
        public String getExpiredInOrbitMessage() {
            return this.expiredInOrbitMessage;
        }

        private String expiredInOrbitMessage;

        @JsonProperty("suppressExpirationWhenObjectivesComplete")
        public boolean getSuppressExpirationWhenObjectivesComplete() {
            return this.suppressExpirationWhenObjectivesComplete;
        }

        private boolean suppressExpirationWhenObjectivesComplete;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InvestmentStat {
        @JsonProperty("statTypeHash")
        public Object getStatTypeHash() {
            return this.statTypeHash;
        }

        private Object statTypeHash;

        @JsonProperty("value")
        public int getValue() {
            return this.value;
        }

        private int value;

        @JsonProperty("isConditionallyActive")
        public boolean getIsConditionallyActive() {
            return this.isConditionallyActive;
        }

        private boolean isConditionallyActive;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LockedDye {
        @JsonProperty("channelHash")
        public String getChannelHash() {
            return this.channelHash;
        }

        private String channelHash;

        @JsonProperty("dyeHash")
        public long getDyeHash() {
            return this.dyeHash;
        }

        private long dyeHash;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Objectives {
        @JsonProperty("objectiveHashes")
        public ArrayList<String> getObjectiveHashes() {
            return this.objectiveHashes;
        }

        private ArrayList<String> objectiveHashes;

        @JsonProperty("displayActivityHashes")
        public ArrayList<String> getDisplayActivityHashes() {
            return this.displayActivityHashes;
        }

        private ArrayList<String> displayActivityHashes;

        @JsonProperty("requireFullObjectiveCompletion")
        public boolean getRequireFullObjectiveCompletion() {
            return this.requireFullObjectiveCompletion;
        }

        private boolean requireFullObjectiveCompletion;

        @JsonProperty("questlineItemHash")
        public String getQuestlineItemHash() {
            return this.questlineItemHash;
        }

        private String questlineItemHash;

        @JsonProperty("narrative")
        public String getNarrative() {
            return this.narrative;
        }

        private String narrative;

        @JsonProperty("objectiveVerbName")
        public String getObjectiveVerbName() {
            return this.objectiveVerbName;
        }

        private String objectiveVerbName;

        @JsonProperty("questTypeIdentifier")
        public String getQuestTypeIdentifier() {
            return this.questTypeIdentifier;
        }

        private String questTypeIdentifier;

        @JsonProperty("questTypeHash")
        public long getQuestTypeHash() {
            return this.questTypeHash;
        }

        private long questTypeHash;

        @JsonProperty("completionRewardSiteHash")
        public String getCompletionRewardSiteHash() {
            return this.completionRewardSiteHash;
        }

        private String completionRewardSiteHash;

        @JsonProperty("nextQuestStepRewardSiteHash")
        public String getNextQuestStepRewardSiteHash() {
            return this.nextQuestStepRewardSiteHash;
        }

        private String nextQuestStepRewardSiteHash;

        @JsonProperty("timestampUnlockValueHash")
        public String getTimestampUnlockValueHash() {
            return this.timestampUnlockValueHash;
        }

        private String timestampUnlockValueHash;

        @JsonProperty("isGlobalObjectiveItem")
        public boolean getIsGlobalObjectiveItem() {
            return this.isGlobalObjectiveItem;
        }

        private boolean isGlobalObjectiveItem;

        @JsonProperty("useOnObjectiveCompletion")
        public boolean getUseOnObjectiveCompletion() {
            return this.useOnObjectiveCompletion;
        }

        private boolean useOnObjectiveCompletion;

        @JsonProperty("inhibitCompletionUnlockValueHash")
        public String getInhibitCompletionUnlockValueHash() {
            return this.inhibitCompletionUnlockValueHash;
        }

        private String inhibitCompletionUnlockValueHash;

        @JsonProperty("perObjectiveDisplayProperties")
        public ArrayList<PerObjectiveDisplayProperty> getPerObjectiveDisplayProperties() {
            return this.perObjectiveDisplayProperties;
        }

        private ArrayList<PerObjectiveDisplayProperty> perObjectiveDisplayProperties;

        @JsonProperty("displayAsStatTracker")
        public boolean getDisplayAsStatTracker() {
            return this.displayAsStatTracker;
        }

        private boolean displayAsStatTracker;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Perk {
        @JsonProperty("requirementDisplayString")
        public String getRequirementDisplayString() {
            return this.requirementDisplayString;
        }

        private String requirementDisplayString;

        @JsonProperty("perkHash")
        public long getPerkHash() {
            return this.perkHash;
        }

        private long perkHash;

        @JsonProperty("perkVisibility")
        public int getPerkVisibility() {
            return this.perkVisibility;
        }

        private int perkVisibility;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PerObjectiveDisplayProperty {
        @JsonProperty("displayOnItemPreviewScreen")
        public boolean getDisplayOnItemPreviewScreen() {
            return this.displayOnItemPreviewScreen;
        }

        private boolean displayOnItemPreviewScreen;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Preview {
        @JsonProperty("screenStyle")
        public String getScreenStyle() {
            return this.screenStyle;
        }

        private String screenStyle;

        @JsonProperty("previewVendorHash")
        public String getPreviewVendorHash() {
            return this.previewVendorHash;
        }

        private String previewVendorHash;

        @JsonProperty("previewActionString")
        public String getPreviewActionString() {
            return this.previewActionString;
        }

        private String previewActionString;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Quality {
        @JsonProperty("itemLevels")
        public ArrayList<Object> getItemLevels() {
            return this.itemLevels;
        }

        private ArrayList<Object> itemLevels;

        @JsonProperty("qualityLevel")
        public int getQualityLevel() {
            return this.qualityLevel;
        }

        private int qualityLevel;

        @JsonProperty("infusionCategoryName")
        public String getInfusionCategoryName() {
            return this.infusionCategoryName;
        }

        private String infusionCategoryName;

        @JsonProperty("infusionCategoryHash")
        public long getInfusionCategoryHash() {
            return this.infusionCategoryHash;
        }

        private long infusionCategoryHash;

        @JsonProperty("infusionCategoryHashes")
        public ArrayList<String> getInfusionCategoryHashes() {
            return this.infusionCategoryHashes;
        }

        private ArrayList<String> infusionCategoryHashes;

        @JsonProperty("progressionLevelRequirementHash")
        public String getProgressionLevelRequirementHash() {
            return this.progressionLevelRequirementHash;
        }

        private String progressionLevelRequirementHash;

        @JsonProperty("currentVersion")
        public int getCurrentVersion() {
            return this.currentVersion;
        }

        private int currentVersion;

        @JsonProperty("versions")
        public ArrayList<Version> getVersions() {
            return this.versions;
        }

        private ArrayList<Version> versions;

        @JsonProperty("displayVersionWatermarkIcons")
        public ArrayList<String> getDisplayVersionWatermarkIcons() {
            return this.displayVersionWatermarkIcons;
        }

        private ArrayList<String> displayVersionWatermarkIcons;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReusablePlugItem {
        @JsonProperty("plugItemHash")
        public String getPlugItemHash() {
            return this.plugItemHash;
        }

        private String plugItemHash;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SocketCategory {
        @JsonProperty("socketCategoryHash")
        public Object getSocketCategoryHash() {
            return this.socketCategoryHash;
        }

        private Object socketCategoryHash;

        @JsonProperty("socketIndexes")
        public ArrayList<Integer> getSocketIndexes() {
            return this.socketIndexes;
        }

        private ArrayList<Integer> socketIndexes;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SocketEntry {
        @JsonProperty("socketTypeHash")
        public Object getSocketTypeHash() {
            return this.socketTypeHash;
        }

        private Object socketTypeHash;

        @JsonProperty("singleInitialItemHash")
        public Object getSingleInitialItemHash() {
            return this.singleInitialItemHash;
        }

        private Object singleInitialItemHash;

        @JsonProperty("reusablePlugItems")
        public ArrayList<ReusablePlugItem> getReusablePlugItems() {
            return this.reusablePlugItems;
        }

        private ArrayList<ReusablePlugItem> reusablePlugItems;

        @JsonProperty("preventInitializationOnVendorPurchase")
        public boolean getPreventInitializationOnVendorPurchase() {
            return this.preventInitializationOnVendorPurchase;
        }

        private boolean preventInitializationOnVendorPurchase;

        @JsonProperty("preventInitializationWhenVersioning")
        public boolean getPreventInitializationWhenVersioning() {
            return this.preventInitializationWhenVersioning;
        }

        private boolean preventInitializationWhenVersioning;

        @JsonProperty("hidePerksInItemTooltip")
        public boolean getHidePerksInItemTooltip() {
            return this.hidePerksInItemTooltip;
        }

        private boolean hidePerksInItemTooltip;

        @JsonProperty("plugSources")
        public int getPlugSources() {
            return this.plugSources;
        }

        private int plugSources;

        @JsonProperty("reusablePlugSetHash")
        public String getReusablePlugSetHash() {
            return this.reusablePlugSetHash;
        }

        private String reusablePlugSetHash;

        @JsonProperty("overridesUiAppearance")
        public boolean getOverridesUiAppearance() {
            return this.overridesUiAppearance;
        }

        private boolean overridesUiAppearance;

        @JsonProperty("defaultVisible")
        public boolean getDefaultVisible() {
            return this.defaultVisible;
        }

        private boolean defaultVisible;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sockets {
        @JsonProperty("detail")
        public String getDetail() {
            return this.detail;
        }

        private String detail;

        @JsonProperty("socketEntries")
        public ArrayList<SocketEntry> getSocketEntries() {
            return this.socketEntries;
        }

        private ArrayList<SocketEntry> socketEntries;

        @JsonProperty("intrinsicSockets")
        public ArrayList<IntrinsicSocket> getIntrinsicSockets() {
            return this.intrinsicSockets;
        }

        private ArrayList<IntrinsicSocket> intrinsicSockets;

        @JsonProperty("socketCategories")
        public ArrayList<SocketCategory> getSocketCategories() {
            return this.socketCategories;
        }

        private ArrayList<SocketCategory> socketCategories;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Setter
    public static class StatData {
        @JsonProperty("statHash")
        public String getStatHash() {
            return this.statHash;
        }

        private String statHash;

        @JsonProperty("value")
        public int getValue() {
            return this.value;
        }

        private int value;

        @JsonProperty("minimum")
        public int getMinimum() {
            return this.minimum;
        }

        private int minimum;

        @JsonProperty("maximum")
        public int getMaximum() {
            return this.maximum;
        }

        private int maximum;

        @JsonProperty("displayMaximum")
        public int getDisplayMaximum() {
            return this.displayMaximum;
        }

        private int displayMaximum;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class Stats {
        @JsonProperty("disablePrimaryStatDisplay")
        private boolean disablePrimaryStatDisplay;

        @JsonProperty("statGroupHash")
        private String statGroupHash;

        @JsonProperty("hasDisplayableStats")
        private boolean hasDisplayableStats;

        @JsonProperty("primaryBaseStatHash")
        private String primaryBaseStatHash;

        @JsonProperty("stats")
        private StatDataList data;

        // theres a list of dynamic keys under key called stats
        @JsonIgnoreProperties(ignoreUnknown = true)
        @Getter
        public static class StatDataList {
            private Map<String, StatData> statsList = new HashMap<>();

            @JsonAnySetter
            public void setData(String key, StatData value) {
                this.statsList.put(key, value);
            }

        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TalentGrid {
        @JsonProperty("talentGridHash")
        public String getTalentGridHash() {
            return this.talentGridHash;
        }

        private String talentGridHash;

        @JsonProperty("itemDetailString")
        public String getItemDetailString() {
            return this.itemDetailString;
        }

        private String itemDetailString;

        @JsonProperty("hudDamageType")
        public int getHudDamageType() {
            return this.hudDamageType;
        }

        private int hudDamageType;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TranslationBlock {
        @JsonProperty("weaponPatternHash")
        public long getWeaponPatternHash() {
            return this.weaponPatternHash;
        }

        private long weaponPatternHash;

        @JsonProperty("defaultDyes")
        public ArrayList<Object> getDefaultDyes() {
            return this.defaultDyes;
        }

        private ArrayList<Object> defaultDyes;

        @JsonProperty("lockedDyes")
        public ArrayList<LockedDye> getLockedDyes() {
            return this.lockedDyes;
        }

        private ArrayList<LockedDye> lockedDyes;

        @JsonProperty("customDyes")
        public ArrayList<Object> getCustomDyes() {
            return this.customDyes;
        }

        private ArrayList<Object> customDyes;

        @JsonProperty("arrangements")
        public ArrayList<Arrangement> getArrangements() {
            return this.arrangements;
        }

        private ArrayList<Arrangement> arrangements;

        @JsonProperty("hasGeometry")
        public boolean getHasGeometry() {
            return this.hasGeometry;
        }

        private boolean hasGeometry;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Version {
        @JsonProperty("powerCapHash")
        public long getPowerCapHash() {
            return this.powerCapHash;
        }

        private long powerCapHash;
    }
}

