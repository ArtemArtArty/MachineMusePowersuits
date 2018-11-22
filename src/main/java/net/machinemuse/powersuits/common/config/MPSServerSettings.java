package net.machinemuse.powersuits.common.config;

import io.netty.buffer.ByteBufInputStream;
import net.machinemuse.numina.network.MusePackager;
import net.machinemuse.numina.network.MusePacket;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Map;
import java.util.TreeMap;

/**
 * Caution: make sure the order of the packets matches between Read and Write.
 */
public class MPSServerSettings {
    /**
     * General -----------------------------------------------------------------------------------
     */
    public final boolean useOldAutoFeeder;
    public final double maximumFlyingSpeedmps;
    public final double getWeightCapacity;
    public final double maximumArmorPerPiece;
    public final double getSalvageChance;

    /**
     * Heat ---------------------------------------------------------------------------------------
     */
    public final double baseMaxHeatPowerFist;
    public final double baseMaxHeatHelmet;
    public final double baseMaxHeatChest;
    public final double baseMaxHeatLegs;
    public final double baseMaxHeatFeet;

    /**
     * Max Modules of Type -----------------------------------------------------------------------
     */
    public final int maxArmorModules;
    public final int maxEnergyStorageModules;
    public final int maxEnergyGenModules;
    public final int maxToolModules;
    public final int maxWeaponModules;
    public final int maxMovementModules;
    public final int maxCosmeticModules;
    public final int maxVisionModules;
    public final int maxEnvironmentalModules;
    public final int maxSpecialModules;
    public final int maxMiningEnhancementModules;

    /**
     * Modules -----------------------------------------------------------------------------------
     */
    public final Map<String, Boolean> allowedModules;
    public final Map<String, Double> propertyDouble;
    public final Map<String, Integer> propertyInteger;


    /**
     * Cosmetics ---------------------------------------------------------------------------------
     */
    public final boolean useLegacyCosmeticSystem;
    public final boolean allowHighPollyArmorModuels;
    public final boolean allowPowerFistCustomization;

    public final Map<String, NBTTagCompound> cosmeticPresetsPowerFist;
    public final Map<String, NBTTagCompound> cosmeticPresetsPowerArmorHelmet;
    public final Map<String, NBTTagCompound> cosmeticPresetsPowerArmorChestplate;
    public final Map<String, NBTTagCompound> cosmeticPresetsPowerArmorLeggings;
    public final Map<String, NBTTagCompound> cosmeticPresetsPowerArmorBoots;

    /**
     * Server side instance.
     */
    public MPSServerSettings() {
        /**
         *  General -------------------------------------------------------------------------------
         */
        useOldAutoFeeder = MPSSettings.general.useOldAutoFeeder;
        maximumFlyingSpeedmps = MPSSettings.general.getMaximumFlyingSpeedmps;
        getWeightCapacity = MPSSettings.general.getWeightCapacity;
        maximumArmorPerPiece = MPSSettings.general.getMaximumArmorPerPiece;
        getSalvageChance = MPSSettings.general.getSalvageChance;

        /**
         * Max Base Heat Heat --------------------------------------------------------------------
         */
        baseMaxHeatPowerFist = MPSSettings.general.baseMaxHeatPowerFist;
        baseMaxHeatHelmet = MPSSettings.general.baseMaxHeatHelmet;
        baseMaxHeatChest = MPSSettings.general.baseMaxHeatChest;
        baseMaxHeatLegs = MPSSettings.general.baseMaxHeatLegs;
        baseMaxHeatFeet = MPSSettings.general.baseMaxHeatFeet;

        /**
         * Modules -------------------------------------------------------------------------------
         */
        allowedModules = new TreeMap<>(MPSSettings.modules.allowedModules);
        propertyDouble = new TreeMap<>(MPSSettings.modules.propertyDouble);
        propertyInteger = new TreeMap<>(MPSSettings.modules.propertyInteger);

        /**
         * Max Modules of Type -------------------------------------------------------------------
         */
        maxArmorModules = MPSSettings.limits.maxArmorModules;
        maxEnergyStorageModules = MPSSettings.limits.maxEnergyStorageModules;
        maxEnergyGenModules = MPSSettings.limits.maxEnergyGenModules;
        maxToolModules = MPSSettings.limits.maxToolModules;
        maxWeaponModules = MPSSettings.limits.maxWeaponModules;
        maxMovementModules = MPSSettings.limits.maxMovementModules;
        maxCosmeticModules = MPSSettings.limits.maxCosmeticModules;
        maxVisionModules = MPSSettings.limits.maxVisionModules;
        maxEnvironmentalModules = MPSSettings.limits.maxEnvironmentalModules;
        maxSpecialModules = MPSSettings.limits.maxSpecialModules;
        maxMiningEnhancementModules = MPSSettings.limits.maxMiningEnhancementModules;

        /**
         * Cosmetics ------------------------------------------------------------------------------
         */
        useLegacyCosmeticSystem = MPSSettings.cosmetics.useLegacyCosmeticSystem;
        allowHighPollyArmorModuels = MPSSettings.cosmetics.allowHighPollyArmorModuels;
        allowPowerFistCustomization = MPSSettings.cosmetics.allowPowerFistCustomization;

        cosmeticPresetsPowerFist = MPSSettings.cosmetics.getCosmeticPresetsPowerFist();
        cosmeticPresetsPowerArmorHelmet = MPSSettings.cosmetics.getCosmeticPresetsPowerArmorHelmet();
        cosmeticPresetsPowerArmorChestplate = MPSSettings.cosmetics.getCosmeticPresetsPowerArmorChestplate();
        cosmeticPresetsPowerArmorLeggings = MPSSettings.cosmetics.getCosmeticPresetsPowerArmorLeggings();
        cosmeticPresetsPowerArmorBoots = MPSSettings.cosmetics.getCosmeticPresetsPowerArmorBoots();
    }

    /**
     * Sets all settings from a packet received client side in a new instance held in MPSSettings.
     */
    public MPSServerSettings(final ByteBufInputStream datain) {
        /**
         * General -------------------------------------------------------------------------------
         */
        useOldAutoFeeder = MusePackager.INSTANCE.readBoolean(datain);
        maximumFlyingSpeedmps = MusePackager.INSTANCE.readDouble(datain);
        getWeightCapacity = MusePackager.INSTANCE.readDouble(datain);
        maximumArmorPerPiece = MusePackager.INSTANCE.readDouble(datain);
        getSalvageChance = MusePackager.INSTANCE.readDouble(datain);
        baseMaxHeatPowerFist = MusePackager.INSTANCE.readDouble(datain);
        baseMaxHeatHelmet = MusePackager.INSTANCE.readDouble(datain);
        baseMaxHeatChest = MusePackager.INSTANCE.readDouble(datain);
        baseMaxHeatLegs = MusePackager.INSTANCE.readDouble(datain);
        baseMaxHeatFeet = MusePackager.INSTANCE.readDouble(datain);

        /**
         * Modules -------------------------------------------------------------------------------
         */
        allowedModules = MusePackager.INSTANCE.readMap(datain, String.class, Boolean.class);
        propertyDouble = MusePackager.INSTANCE.readMap(datain, String.class, Double.class);
        propertyInteger = MusePackager.INSTANCE.readMap(datain, String.class, Integer.class);

        /**
         * Max Modules of Type -------------------------------------------------------------------
         */
        maxArmorModules= MusePackager.INSTANCE.readInt(datain);
        maxEnergyStorageModules= MusePackager.INSTANCE.readInt(datain);
        maxEnergyGenModules= MusePackager.INSTANCE.readInt(datain);
        maxToolModules= MusePackager.INSTANCE.readInt(datain);
        maxWeaponModules= MusePackager.INSTANCE.readInt(datain);
        maxMovementModules= MusePackager.INSTANCE.readInt(datain);
        maxCosmeticModules= MusePackager.INSTANCE.readInt(datain);
        maxVisionModules= MusePackager.INSTANCE.readInt(datain);
        maxEnvironmentalModules= MusePackager.INSTANCE.readInt(datain);
        maxSpecialModules= MusePackager.INSTANCE.readInt(datain);
        maxMiningEnhancementModules= MusePackager.INSTANCE.readInt(datain);

        /**
         * Cosmetics ------------------------------------------------------------------------------
         */
        useLegacyCosmeticSystem = MusePackager.INSTANCE.readBoolean(datain);
        allowHighPollyArmorModuels = MusePackager.INSTANCE.readBoolean(datain);
        allowPowerFistCustomization = MusePackager.INSTANCE.readBoolean(datain);
        cosmeticPresetsPowerFist = MusePackager.INSTANCE.readMap(datain, String.class, NBTTagCompound.class);
        cosmeticPresetsPowerArmorHelmet = MusePackager.INSTANCE.readMap(datain, String.class, NBTTagCompound.class);
        cosmeticPresetsPowerArmorChestplate = MusePackager.INSTANCE.readMap(datain, String.class, NBTTagCompound.class);
        cosmeticPresetsPowerArmorLeggings = MusePackager.INSTANCE.readMap(datain, String.class, NBTTagCompound.class);
        cosmeticPresetsPowerArmorBoots = MusePackager.INSTANCE.readMap(datain, String.class, NBTTagCompound.class);
    }

    /**
     * This is a server side operation that gets the values and writes them to the packet.
     * This packet is then sent to a new client on login to sync config values. This allows
     * the server to be able to control these settings.
     */
    public void writeToBuffer(final MusePacket packet) {
        /**
         * General -------------------------------------------------------------------------------
         */
        packet.writeBoolean(useOldAutoFeeder);
        packet.writeDouble(maximumFlyingSpeedmps);
        packet.writeDouble(getWeightCapacity);
        packet.writeDouble(maximumArmorPerPiece);
        packet.writeDouble(getSalvageChance);
        packet.writeDouble(baseMaxHeatPowerFist);
        packet.writeDouble(baseMaxHeatHelmet);
        packet.writeDouble(baseMaxHeatChest);
        packet.writeDouble(baseMaxHeatLegs);
        packet.writeDouble(baseMaxHeatFeet);

        /**
         * Modules -------------------------------------------------------------------------------
         */
        packet.writeMap(allowedModules, true);
        packet.writeMap(propertyDouble, true);
        packet.writeMap(propertyInteger, true);

        /**
         * Max Modules of Type -------------------------------------------------------------------
         */
        packet.writeInt(maxArmorModules);
        packet.writeInt(maxEnergyStorageModules);
        packet.writeInt(maxEnergyGenModules);
        packet.writeInt(maxToolModules);
        packet.writeInt(maxWeaponModules);
        packet.writeInt(maxMovementModules);
        packet.writeInt(maxCosmeticModules);
        packet.writeInt(maxVisionModules);
        packet.writeInt(maxEnvironmentalModules);
        packet.writeInt(maxSpecialModules);
        packet.writeInt(maxMiningEnhancementModules);

        /**
         * Cosmetics ------------------------------------------------------------------------------
         */
        packet.writeBoolean(useLegacyCosmeticSystem);
        packet.writeBoolean(allowHighPollyArmorModuels);
        packet.writeBoolean(allowPowerFistCustomization);
        packet.writeMap(cosmeticPresetsPowerFist, true);
        packet.writeMap(cosmeticPresetsPowerArmorHelmet, true);
        packet.writeMap(cosmeticPresetsPowerArmorChestplate, true);
        packet.writeMap(cosmeticPresetsPowerArmorLeggings, true);
        packet.writeMap(cosmeticPresetsPowerArmorBoots, true);
    }
}