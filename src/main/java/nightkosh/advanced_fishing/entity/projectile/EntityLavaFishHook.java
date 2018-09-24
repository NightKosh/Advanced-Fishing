package nightkosh.advanced_fishing.entity.projectile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.advanced_fishing.core.Items;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityLavaFishHook extends EntityCustomFishHook {

    public EntityLavaFishHook(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    @SideOnly(Side.CLIENT)
    public EntityLavaFishHook(World world, EntityPlayer player, double x, double y, double z) {
        super(world, player, x, y, z);
        this.isImmuneToFire = true;
    }

    public EntityLavaFishHook(World world, EntityPlayer player) {
        super(world, player);
        this.isImmuneToFire = true;
    }

    @Override
    protected EntityItem getCatchEntityItem(ItemStack stack) {
        return getFireproofCatchEntityItem(stack);
    }

    @Override
    public boolean isInWater() {
        return super.isInWater() || this.isInLava();
    }

    @Override
    protected boolean isFishingPoleStack(ItemStack stack) {
        return stack.getItem() == Items.BLAZING_FISHING_POLE;
    }
}
