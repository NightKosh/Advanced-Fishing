package nightkosh.advanced_fishing.entity.projectile;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.advanced_fishing.core.MaterialManager;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AbstractFishHook extends EntityFishHook {

    protected static final DataParameter<Integer> PLAYER_ID = EntityDataManager.createKey(AbstractFishHook.class, DataSerializers.VARINT);
    protected static final DataParameter<BlockPos> POS = EntityDataManager.createKey(AbstractFishHook.class, DataSerializers.BLOCK_POS);

    public AbstractFishHook(World world) {
        this(world, world.getPlayerEntityByUUID(Minecraft.getMinecraft().getSession().getProfile().getId()));
    }

    @SideOnly(Side.CLIENT)
    public AbstractFishHook(World world, EntityPlayer player, double x, double y, double z) {
        super(world, player, x, y, z);
    }

    public AbstractFishHook(World world, EntityPlayer player) {
        super(world, player);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(PLAYER_ID, this.getAngler() == null ? 0 : this.getAngler().getEntityId());
        this.dataManager.register(POS, this.getPosition());
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        if (PLAYER_ID.equals(key)) {
            if (this.world.isRemote) {
                Entity entity = world.getEntityByID(this.dataManager.get(PLAYER_ID));
                if (entity != null && entity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) entity;
                    this.getAngler().fishEntity = null;
                    this.angler = player;
                    this.angler.fishEntity = this;
                }
            }
        } else if (POS.equals(key)) {
            if (this.world.isRemote) {
                IBlockState state = this.world.getBlockState(this.getPosition());
                if (MaterialManager.MATERIAL_SET.contains(state.getMaterial())) {
                    BlockPos pos = this.dataManager.get(POS);
                    if (pos != null) {
                        this.setPosition(pos.getX(), pos.getY(), pos.getZ());
                    }
                }
            }
        }

        super.notifyDataManagerChange(key);
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();

        if (!this.world.isRemote && this.getAngler() != null) {
            this.getDataManager().set(PLAYER_ID, this.getAngler().getEntityId());
            IBlockState state = this.world.getBlockState(this.getPosition());
            if (MaterialManager.MATERIAL_SET.contains(state.getMaterial())) {
                this.getDataManager().set(POS, this.getPosition());
            }
        }
    }

    protected boolean isFishingPoleStack(ItemStack stack) {
        return stack.getItem() == net.minecraft.init.Items.FISHING_ROD;
    }

}
