package nightkosh.advanced_fishing.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import nightkosh.advanced_fishing.entity.projectile.AbstractFishHook;

import javax.annotation.Nonnull;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AbstractFishingPole extends ItemFishingRod {

    public AbstractFishingPole() {
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (player.fishEntity != null) {
            int i = player.fishEntity.handleHookRetraction();
            stack.damageItem(i, player);
            player.swingArm(hand);
            playBobberRetrieveSound(world, player);
        } else {
            playBobberThrowSound(world, player);

            if (!world.isRemote) {
                AbstractFishHook hook = getHook(world, player, stack);
                setHookParams(hook, stack);

                world.spawnEntity(hook);
            }

            player.swingArm(hand);
            player.addStat(StatList.getObjectUseStats(this));
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    @Nonnull
    protected abstract AbstractFishHook getHook(World world, EntityPlayer player, ItemStack stack);

    protected void playBobberRetrieveSound(World world, EntityPlayer player) {
        world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_BOBBER_RETRIEVE, SoundCategory.NEUTRAL, 1, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
    }

    protected void playBobberThrowSound(World world, EntityPlayer player) {
        world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_BOBBER_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
    }

    protected void setHookParams(AbstractFishHook hook, ItemStack stack) {
        int speed = EnchantmentHelper.getFishingSpeedBonus(stack);
        if (speed > 0) {
            hook.setLureSpeed(speed);
        }

        int luck = EnchantmentHelper.getFishingLuckBonus(stack);
        if (luck > 0) {
            hook.setLuck(luck);
        }
    }
}
