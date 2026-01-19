package nightkosh.advanced_fishing.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.entity.projectile.AFishHook;
import nightkosh.advanced_fishing.entity.projectile.LavaFishHook;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlazingFishingRod extends AbstractFishingRod {

    private static final ResourceKey RK = ResourceKey.create(
            Registries.ITEM,
            fromNamespaceAndPath(ModInfo.ID, "blazing_fishing_pole"));

    public ItemBlazingFishingRod() {
        super(new Item.Properties()
                .fireResistant()
                .rarity(Rarity.EPIC)
                .durability(250)
                .repairable(Items.BLAZE_ROD)
                .enchantable(25)
                .setId(RK));
    }

    @Nonnull
    @Override
    protected AFishHook getHook(Player player, Level level, int luck, int lureSpeed, boolean hasGlowingEnchantment) {
        return new LavaFishHook(player, level, luck, lureSpeed, hasGlowingEnchantment);
    }

}
