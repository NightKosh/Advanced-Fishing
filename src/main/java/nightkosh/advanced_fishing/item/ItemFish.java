package nightkosh.advanced_fishing.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import nightkosh.advanced_fishing.api.EnumFishType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemFish extends Item {

    private final EnumFishType fishType;

    public ItemFish(EnumFishType fishType) {
        super(new Item.Properties()
                .stacksTo(64)
                .food(new FoodProperties.Builder()
                        .nutrition(fishType.getHealAmount())
                        .saturationMod(fishType.getSaturationModifier())
                        .build()));
        this.fishType = fishType;
    }

    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull LivingEntity entity) {
        switch (fishType) {
            case BLUE_JELLYFISH:
            case GREEN_JELLYFISH:
            case CURSED_KOI:
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 2));
                break;
            case MAGMA_JELLYFISH:
            case FLAREFIN_KOI:
            case BLAZE_PIKE:
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 2));
                entity.setSecondsOnFire(5);
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
            case BONE_FISH:
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 2));
                break;
            case SPOOKYFIN:
                entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 2));
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 2));
                break;
            case WITHERED_CRUCIAN:
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 2));
                break;
            case CAVE_TROUT:
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1));
                break;
            case MANDARINFISH:
                if (entity instanceof Player player) {
                    player.giveExperiencePoints(5);
                }
                break;
        }

        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack, @Nullable Level level,
            @Nonnull List<Component> tooltips, @Nonnull TooltipFlag flag) {
        switch (fishType) {
            case BLUE_JELLYFISH:
            case GREEN_JELLYFISH:
            case CURSED_KOI:
                tooltips.add(Component.translatable("fish_effects.advanced_fishing.poison"));
                break;
            case MAGMA_JELLYFISH:
            case FLAREFIN_KOI:
            case BLAZE_PIKE:
                tooltips.add(Component.translatable("fish_effects.advanced_fishing.fire"));
                break;
            case SPOOKYFIN:
                tooltips.add(Component.translatable("fish_effects.advanced_fishing.blindness"));
                break;
            case WITHERED_CRUCIAN:
                tooltips.add(Component.translatable("fish_effects.advanced_fishing.wither"));
                break;
            case CAVE_TROUT:
                tooltips.add(Component.translatable("fish_effects.advanced_fishing.damage_resistance"));
                break;
            case MANDARINFISH:
                tooltips.add(Component.translatable("fish_effects.advanced_fishing.experience"));
                break;
        }

        super.appendHoverText(stack, level, tooltips, flag);
    }

}
