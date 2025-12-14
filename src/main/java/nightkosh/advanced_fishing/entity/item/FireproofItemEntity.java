package nightkosh.advanced_fishing.entity.item;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import nightkosh.advanced_fishing.core.AFConfig;
import nightkosh.advanced_fishing.core.AFEntities;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FireproofItemEntity extends ItemEntity {

    public FireproofItemEntity(EntityType<? extends ItemEntity> entityType, Level level) {
        super(entityType, level);
    }

    public FireproofItemEntity(Level level, double posX, double posY, double posZ, ItemStack stack) {
        super(AFEntities.getFireproofItem(), level);
        this.setPos(posX, posY, posZ);
        this.setDeltaMovement(level.random.nextDouble() * 0.2 - 0.1, 0.2, level.random.nextDouble() * 0.2 - 0.1);
        this.setItem(stack);
        this.lifespan = stack.getEntityLifespan(level);
        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("FireproofItemEntity spawned");
        }
    }

    @Override
    protected void setUnderLavaMovement() {
        this.setUnderwaterMovement();
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

}
