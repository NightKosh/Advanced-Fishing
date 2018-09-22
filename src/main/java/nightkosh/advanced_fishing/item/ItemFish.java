package nightkosh.advanced_fishing.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.Tabs;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemFish extends Item {

    public ItemFish() {
        this.setUnlocalizedName("advanced-fishing.fish");
        this.setRegistryName(ModInfo.ID, "fish");
        this.setCreativeTab(Tabs.FISH_TAB);
        this.setHasSubtypes(true);
    }

    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            for (EnumFishType fish : EnumFishType.values()) {
                items.add(new ItemStack(this, 1, fish.ordinal()));
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.advanced-fishing." + EnumFishType.values()[stack.getMetadata()].getName();
    }
}
