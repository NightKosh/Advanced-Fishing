package nightkosh.advanced_fishing.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import nightkosh.advanced_fishing.core.ParticlesManager;

import javax.annotation.Nonnull;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Chum extends Entity {

    private static final int LIFETIME_TICKS = 6000; // 5 mins

    public Chum(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.noPhysics = true;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide()) {
            // despawn after 5 minutes
            if (this.tickCount >= LIFETIME_TICKS) {
                this.discard();
                return;
            }

            if (this.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.SPLASH,
                        this.getX() + random.nextInt(5) - 2.5,
                        this.getY(),
                        this.getZ() + random.nextInt(5) - 2.5,
                        1,
                        0, 0, 0, 0);
            }

            this.setDeltaMovement(Vec3.ZERO);

            // stay on top
            var pos = this.blockPosition();
            var fluid = this.level().getFluidState(pos);

            if (!fluid.isEmpty() && fluid.isSource()) {
                double surfaceY = pos.getY() + 1.0;
                this.setPos(this.getX(), surfaceY - 0.01, this.getZ());
            }
        }
    }

    @Override
    protected void defineSynchedData(@Nonnull SynchedEntityData.Builder builder) {

    }

    @Override
    protected void readAdditionalSaveData(@Nonnull ValueInput input) {
        this.tickCount = input.getIntOr("Age", 0);
    }

    @Override
    protected void addAdditionalSaveData(@Nonnull ValueOutput output) {
        output.putInt("Age", this.tickCount);
    }

    @Override
    public boolean hurtServer(@Nonnull ServerLevel level, @Nonnull DamageSource damageSource, float amount) {
        return damageSource.is(DamageTypes.LAVA);
    }

    @Override
    public boolean canCollideWith(@Nonnull Entity entity) {
        return false;
    }

    @Override
    public boolean isColliding(BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return distance < 1024;//32*32
    }

}
