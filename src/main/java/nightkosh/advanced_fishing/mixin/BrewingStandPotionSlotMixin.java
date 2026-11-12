package nightkosh.advanced_fishing.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import nightkosh.advanced_fishing.core.AFAdvancements;
import nightkosh.advanced_fishing.core.AFConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

@Mixin(targets = "net.minecraft.world.inventory.BrewingStandMenu$PotionSlot")
public abstract class BrewingStandPotionSlotMixin {

    @Inject(method = "onTake", at = @At("TAIL"))
    private void advancedFishing$onTake(Player player, ItemStack stack, CallbackInfo ci) {
        if (player instanceof ServerPlayer serverPlayer && stack.is(Items.EXPERIENCE_BOTTLE)) {
            if (AFConfig.DEBUG_MODE.get()) {
                LOGGER.info("EXPERIENCE_BOTTLE has been brewed by {}. Going to give WISDOM_IN_A_BOTTLE advancement.", player.getScoreboardName());
            }
            AFAdvancements.giveAdvancement(player, player.level(), AFAdvancements.WISDOM_IN_A_BOTTLE);
        }
    }

}
