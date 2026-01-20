package nightkosh.advanced_fishing.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import nightkosh.advanced_fishing.entity.projectile.AFishHook;

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
    public InteractionResult use(@Nonnull Level level, Player player, @Nonnull InteractionHand hand) {
        var stack = player.getItemInHand(hand);

        if (player.fishing != null) {
            if (!level.isClientSide()) {
                stack.hurtAndBreak(player.fishing.retrieve(stack), player, hand.asEquipmentSlot());
            }

            playBobberRetrieveSound(level, player);
            player.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
        } else {
            playBobberThrowSound(level, player);
            if (!level.isClientSide() && level instanceof ServerLevel serverlevel) {
                Projectile.spawnProjectile(
                        getHook(player, level,
                                EnchantmentHelper.getFishingLuckBonus(serverlevel, stack, player),
                                (int) EnchantmentHelper.getFishingTimeReduction(serverlevel, stack, player) * 20,
                                stack),
                        serverlevel, stack);
            }

            player.awardStat(Stats.ITEM_USED.get(this));
            player.gameEvent(GameEvent.ITEM_INTERACT_START);
        }

        return InteractionResult.SUCCESS;
    }

    @Nonnull
    protected abstract AFishHook getHook(Player player, Level level, int luck, int lureSpeed, ItemStack fishingPole);

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
