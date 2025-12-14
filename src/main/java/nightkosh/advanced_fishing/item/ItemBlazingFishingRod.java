package nightkosh.advanced_fishing.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import nightkosh.advanced_fishing.entity.projectile.AbstractFishHook;
import nightkosh.advanced_fishing.entity.projectile.LavaFishHook;

import javax.annotation.Nonnull;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlazingFishingRod extends AbstractFishingRod {

    public ItemBlazingFishingRod(Item.Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    protected AbstractFishHook getHook(Player player, Level level, int luck, int lureSpeed) {
        return new LavaFishHook(player, level, luck, lureSpeed);
    }

}
