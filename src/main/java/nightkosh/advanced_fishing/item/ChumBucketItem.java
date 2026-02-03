package nightkosh.advanced_fishing.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.entity.projectile.ChumBucket;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChumBucketItem extends Item implements ProjectileItem {

    private static final ResourceKey RK = ResourceKey.create(
            Registries.ITEM,
            fromNamespaceAndPath(ModInfo.ID, "chum_bucket"));

    public static final float PROJECTILE_SHOOT_POWER = 0.5F;
    private static final int MAX_USAGE = 4;

    public ChumBucketItem() {
        super(new Item.Properties()
                .durability(MAX_USAGE)
                .setId(RK));
    }

    @Nonnull
    @Override
    public InteractionResult use(Level level, Player player, @Nonnull InteractionHand hand) {
        var stack = player.getItemInHand(hand);
        level.playSound(
                null,
                player.getX(), player.getY(), player.getZ(),
                SoundEvents.FISHING_BOBBER_THROW,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

        if (level instanceof ServerLevel serverlevel) {
            Projectile.spawnProjectileFromRotation(
                    ChumBucket::new, serverlevel, stack, player, -10, PROJECTILE_SHOOT_POWER, 1);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        deplete(player, stack, hand);
        return InteractionResult.SUCCESS;
    }

    @Nonnull
    @Override
    public Projectile asProjectile(
            @Nonnull Level level, @Nonnull Position pos, @Nonnull ItemStack stack, @Nonnull Direction direction) {
        return new ChumBucket(level, pos.x(), pos.y(), pos.z(), stack);
    }

    @Override
    public boolean isDamageable(@Nonnull ItemStack stack) {
        return false;
    }

    private void deplete(Player player, ItemStack stack, @Nonnull InteractionHand hand) {
        if (stack.nextDamageWillBreak()) {
            player.setItemInHand(hand, new ItemStack(Items.BUCKET));
        } else {
            stack.hurtAndBreak(1, player, hand);
        }
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack, @Nonnull Item.TooltipContext context,
            @Nonnull TooltipDisplay tooltipDisplay, @Nonnull Consumer<Component> consumer,
            @Nonnull TooltipFlag flag) {
        consumer.accept(Component.translatable("item.advanced_fishing.chum_bucket.description"));

        super.appendHoverText(stack, context, tooltipDisplay, consumer, flag);
    }

}
