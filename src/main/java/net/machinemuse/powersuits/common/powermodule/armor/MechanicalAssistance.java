package net.machinemuse.powersuits.common.powermodule.armor;

import net.machinemuse.api.IModularItem;
import net.machinemuse.api.ModuleManager;
import net.machinemuse.api.moduletrigger.IPlayerTickModule;
import net.machinemuse.api.moduletrigger.IToggleableModule;
import net.machinemuse.powersuits.client.events.MuseIcon;
import net.machinemuse.powersuits.common.items.ItemComponent;
import net.machinemuse.powersuits.common.powermodule.PowerModuleBase;
import net.machinemuse.utils.ElectricItemUtils;
import net.machinemuse.utils.MuseCommonStrings;
import net.machinemuse.utils.MuseItemUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

import static net.machinemuse.powersuits.common.MPSConstants.MODULE_MECH_ASSISTANCE;

/**
 * Created by Eximius88 on 1/17/14.
 */
public class MechanicalAssistance extends PowerModuleBase implements IPlayerTickModule, IToggleableModule {
    public static final String ASSISTANCE = "Robotic Assistance";
    public static final String POWER_USAGE = "Power Usage";


    public MechanicalAssistance(List<IModularItem> validItems) {
        super(validItems);
        addInstallCost(MuseItemUtils.copyAndResize(ItemComponent.artificialMuscle, 4));
        addTradeoffProperty(ASSISTANCE, POWER_USAGE, 500, " Joules/Tick");
        addTradeoffProperty(ASSISTANCE, MuseCommonStrings.WEIGHT, -10000);
    }

    @Override
    public String getCategory() {
        return MuseCommonStrings.CATEGORY_ARMOR;
    }

    @Override
    public String getDataName() {
        return MODULE_MECH_ASSISTANCE;
    }

    @Override
    public String getUnlocalizedName() {
        return "mechAssistance";
    }

    @Override
    public void onPlayerTickActive(EntityPlayer player, ItemStack item) {
        ElectricItemUtils.drainPlayerEnergy(player, ModuleManager.computeModularProperty(item, POWER_USAGE));
    }

    @Override
    public void onPlayerTickInactive(EntityPlayer player, ItemStack item) {
    }

    @Override
    public TextureAtlasSprite getIcon(ItemStack item) {
        return MuseIcon.mechAssistance;
    }
}