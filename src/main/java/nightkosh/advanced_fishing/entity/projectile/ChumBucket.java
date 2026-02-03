package nightkosh.advanced_fishing.entity.projectile;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import nightkosh.advanced_fishing.core.AFEntities;
import nightkosh.advanced_fishing.core.AFItems;

import javax.annotation.Nonnull;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChumBucket extends ThrowableItemProjectile {

    private static final ItemStack PARTICLE_ITEM = new ItemStack(Items.ROTTEN_FLESH);

    public ChumBucket(EntityType<? extends ChumBucket> entityType, Level level) {
        super(entityType, level);
    }

    public ChumBucket(Level level, LivingEntity entity, ItemStack stack) {
        super(AFEntities.CHUM_BUCKET.get(), entity, level, stack);
    }

    public ChumBucket(Level level, double x, double y, double z, ItemStack stack) {
        super(AFEntities.CHUM_BUCKET.get(), x, y, z, level, stack);
    }

    @Nonnull
    @Override
    protected Item getDefaultItem() {
        return AFItems.CHUM_BUCKET.get();
    }

    private ParticleOptions getParticle() {
        return new ItemParticleOption(ParticleTypes.ITEM, PARTICLE_ITEM);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            var particleoptions = this.getParticle();

            for (int i = 0; i < 8; i++) {
                this.level().addParticle(
                        particleoptions,
                        this.getX(), this.getY(), this.getZ(),
                        0, 0, 0);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide() && this.isInFluidType()) {
            this.onHitWater();
        }
    }

    @Override
    protected void onHit(@Nonnull HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(@Nonnull EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        hitResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0);
    }

    protected void onHitWater() {
        if (this.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.SPLASH,
                    this.getX(), this.getY() + 1, this.getZ(),
                    5,
                    0, 0, 0, 0);
        }

        this.level().playSound(
                null,
                this.getX(), this.getY(), this.getZ(),
                SoundEvents.WATER_AMBIENT,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (this.level().getRandom().nextFloat() * 0.4F + 0.8F));

        this.level().broadcastEntityEvent(this, (byte) 3);

        var chum = AFEntities.CHUM.get().create(this.level(), EntitySpawnReason.TRIGGERED);
        chum.snapTo(this.getX(), this.getY(), this.getZ(), 0, 0);
        this.level().addFreshEntity(chum);

        this.discard();
    }

}
