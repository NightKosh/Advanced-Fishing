package nightkosh.advanced_fishing.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Tabs {

    public static final CreativeTabs FISH_TAB =  new CreativeTabs("tabFish") {
        @Override
        public ItemStack getIconItemStack() {
            return new ItemStack(Items.FISH, 1, 5);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.FISH, 1, 5);
        }
    };
}
