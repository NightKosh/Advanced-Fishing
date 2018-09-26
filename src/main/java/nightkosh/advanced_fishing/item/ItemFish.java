package nightkosh.advanced_fishing.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.Tabs;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemFish extends ItemFood {

    public ItemFish() {
        super(0, 0, false);
        this.setUnlocalizedName("advanced-fishing.fish");
        this.setRegistryName(ModInfo.ID, "fish");
        this.setCreativeTab(Tabs.FISH_TAB);
        this.setHasSubtypes(true);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            for (EnumFishType fish : EnumFishType.values()) {
                items.add(new ItemStack(this, 1, fish.ordinal()));
            }
        }
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        return EnumFishType.values()[stack.getMetadata()].getHealAmount();
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        return EnumFishType.values()[stack.getMetadata()].getSaturationModifier();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        EnumFishType fishType = EnumFishType.values()[stack.getMetadata()];

        switch (fishType) {
            case BLUE_JELLYFISH:
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, 200, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
                break;
            case MAGMA_JELLYFISH:
            case FLAREFIN_KOI:
            case BLAZE_PIKE:
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
                player.setFire(5);
                break;
            case OBSIDIAN_BREAM:
            case SANDY_BASS:
            case MUD_TUNA:
            case EXPLOSIVE_CRUCIAN:
            case NETHER_STURGEON:
            case QUARTZ_CHUB:
            case ENDER_SHAD:
            case RED_SHROOMFIN:
            case BROWN_SHROOMFIN:
            case FUNGI_CATFISH:
            case SWAMP_PLAICE:
            case CRYSTAL_MULLET:
            case CHARGED_BULLHEAD:
            case ABYSSAL_LURKER:
            case MAGIKARP:
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
                break;
            case WITHERED_CRUCIAN:
                player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
                break;
            case CAVE_TROUT:
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 1));
                break;
        }

        super.onFoodEaten(stack, worldIn, player);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.advanced-fishing." + EnumFishType.values()[stack.getMetadata()].getName();
    }
}
