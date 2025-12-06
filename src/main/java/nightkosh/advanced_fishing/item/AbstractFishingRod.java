package nightkosh.advanced_fishing.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import nightkosh.advanced_fishing.entity.projectile.AbstractFishHook;

import javax.annotation.Nonnull;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AbstractFishingRod extends FishingRodItem {

    public AbstractFishingRod(Item.Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level level, Player player, @Nonnull InteractionHand hand) {
        var stack = player.getItemInHand(hand);

        if (player.fishing != null) {
            if (!level.isClientSide()) {
                stack.hurtAndBreak(player.fishing.retrieve(stack), player, p -> p.broadcastBreakEvent(hand));
            }

            playBobberRetrieveSound(level, player);
            player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
        } else {
            playBobberThrowSound(level, player);
            if (!level.isClientSide()) {
                level.addFreshEntity(
                        getHook(player, level,
                                EnchantmentHelper.getFishingLuckBonus(stack),
                                EnchantmentHelper.getFishingSpeedBonus(stack)));
            }

            player.awardStat(Stats.ITEM_USED.get(this));
            player.gameEvent(GameEvent.ITEM_INTERACT_START);
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Nonnull
    protected abstract AbstractFishHook getHook(Player player, Level level, int luck, int lureSpeed);

    protected void playBobberRetrieveSound(Level level, Player player) {
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.NEUTRAL,
                1.0F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
    }

    protected void playBobberThrowSound(Level level, Player player) {
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.FISHING_BOBBER_THROW, SoundSource.NEUTRAL,
                0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
    }

}
