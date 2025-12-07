package nightkosh.advanced_fishing.entity.projectile;

import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import nightkosh.advanced_fishing.core.AFEntities;

import java.util.List;

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

    public LavaFishHook(Player player, Level level, int luck, int lureSpeed) {
        super(AFEntities.getLavaFishHook(), player, level, luck, lureSpeed);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        if (source.is(DamageTypes.LAVA)
                || source.is(DamageTypes.IN_FIRE)
                || source.is(DamageTypes.ON_FIRE)
                || source.is(DamageTypes.HOT_FLOOR)) {
            return true;
        }
        return super.isInvulnerableTo(source);
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
