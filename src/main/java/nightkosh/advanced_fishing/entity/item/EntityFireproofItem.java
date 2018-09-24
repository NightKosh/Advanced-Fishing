package nightkosh.advanced_fishing.entity.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityFireproofItem extends EntityItem {
    public EntityFireproofItem(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.isImmuneToFire = true;
    }

    public EntityFireproofItem(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z, stack);
        this.isImmuneToFire = true;
    }

    public EntityFireproofItem(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    @Override
    public void onUpdate() {
        if (!getItem().getItem().onEntityItemUpdate(this)) {
            if (this.getItem().isEmpty()) {
                this.setDead();
            } else {
                if (!this.world.isRemote) {
                    this.setFlag(6, this.isGlowing());
                }

                this.onEntityUpdate();

                if (this.pickupDelay > 0 && this.pickupDelay != 32767) {
                    this.pickupDelay--;
                }

                this.prevPosX = this.posX;
                this.prevPosY = this.posY;
                this.prevPosZ = this.posZ;
                double d0 = this.motionX;
                double d1 = this.motionY;
                double d2 = this.motionZ;

                if (!this.hasNoGravity()) {
                    this.motionY -= 0.04;
                }

                this.noClip = !this.world.isRemote && this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2D, this.posZ);

                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);

                float f = 0.98F;

                if (this.onGround) {
                    BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                    IBlockState underState = this.world.getBlockState(underPos);
                    f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.98F;
                }

                this.motionX *= f;
                this.motionY *= 0.98;
                this.motionZ *= f;

                if (this.onGround) {
                    this.motionY *= -0.5;
                }

                if (this.age != -32768) {
                    this.age++;
                }

                this.handleWaterMovement();

                if (!this.world.isRemote) {
                    double d3 = this.motionX - d0;
                    double d4 = this.motionY - d1;
                    double d5 = this.motionZ - d2;
                    double d6 = d3 * d3 + d4 * d4 + d5 * d5;

                    if (d6 > 0.01) {
                        this.isAirBorne = true;
                    }
                }

                ItemStack item = this.getItem();
                if (!this.world.isRemote && this.age >= lifespan) {
                    int hook = ForgeEventFactory.onItemExpire(this, item);
                    if (hook < 0) {
                        this.setDead();
                    } else {
                        this.lifespan += hook;
                    }
                }
                if (item.isEmpty()) {
                    this.setDead();
                }
            }
        }
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        return true;
    }
}
