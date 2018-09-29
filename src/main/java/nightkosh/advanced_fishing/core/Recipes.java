package nightkosh.advanced_fishing.core;

import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Recipes {

    private static final ResourceLocation GROUP = new ResourceLocation(ModInfo.ID);


    public static void smeltingRecipesRegistration() {
        for (int i = EnumFishType.BLUE_JELLYFISH.ordinal(); i < EnumFishType.MAGIKARP.ordinal(); i++) {//All except MAGIKARP
            GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, i), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        }

        //vanilla
        GameRegistry.addSmelting(new ItemStack(net.minecraft.init.Items.FISH, 1, ItemFishFood.FishType.PUFFERFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(net.minecraft.init.Items.FISH, 1, ItemFishFood.FishType.CLOWNFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
    }

    public static void addLuckPotionRecipe() {
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(net.minecraft.init.Items.FISH, 1, 2)), PotionType.getPotionTypeForName("luck"));
    }
}
