package nightkosh.advanced_fishing.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.Tabs;
import nightkosh.advanced_fishing.entity.projectile.AbstractFishHook;
import nightkosh.advanced_fishing.entity.projectile.EntityLavaFishHook;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlazingFishingPole extends AbstractFishingPole {

    public ItemBlazingFishingPole() {
        this.setMaxDamage(250);
        this.setCreativeTab(Tabs.FISH_TAB);
        this.setUnlocalizedName("advanced-fishing.blazing_fishing_pole");
        this.setRegistryName(ModInfo.ID, "blazing_fishing_pole");

        this.addPropertyOverride(new ResourceLocation("cast"), (stack, worldIn, entityIn) -> {
            if (entityIn == null) {
                return 0;
            } else {
                boolean flag = entityIn.getHeldItemMainhand() == stack;
                boolean flag1 = entityIn.getHeldItemOffhand() == stack;

                if (entityIn.getHeldItemMainhand().getItem() instanceof ItemBlazingFishingPole) {
                    flag1 = false;
                }

                return (flag || flag1) && entityIn instanceof EntityPlayer && ((EntityPlayer) entityIn).fishEntity != null ? 1 : 0;
            }
        });
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Items.BLAZE_ROD;
    }

    @Override
    protected AbstractFishHook getHook(World world, EntityPlayer player, ItemStack stack) {
        return new EntityLavaFishHook(world, player);
    }
}
