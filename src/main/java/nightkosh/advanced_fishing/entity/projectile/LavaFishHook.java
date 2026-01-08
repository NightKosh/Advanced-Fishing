package nightkosh.advanced_fishing.entity.projectile;

import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import nightkosh.advanced_fishing.core.AFConfig;
import nightkosh.advanced_fishing.core.AFEntities;

import java.util.List;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LavaFishHook extends AdvancedFishHook {

    private static final List<TagKey<Fluid>> SUPPORTED_LIQUID_TYPE = List.of(FluidTags.WATER, FluidTags.LAVA);

    public LavaFishHook(EntityType<? extends LavaFishHook> entityType, Level level) {
        super(entityType, level);
    }

    public LavaFishHook(Player player, Level level, int luck, int lureSpeed, boolean hasGlowingEnchantment) {
        super(AFEntities.getLavaFishHook(), player, level, luck, lureSpeed, hasGlowingEnchantment);
    }

    @Override
    protected void spawnLog() {
        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("LavaFishHook spawned");
        }
    }

    @Override
    protected ItemEntity getCatchEntityItem(ItemStack stack) {
        return getFireproofCatchEntityItem(stack);
    }

    @Override
    protected List<TagKey<Fluid>> getSupportedLiquidType() {
        return SUPPORTED_LIQUID_TYPE;
    }

}
