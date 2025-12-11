package nightkosh.advanced_fishing.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFConfig;
import nightkosh.advanced_fishing.core.AFItems;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID, bus = EventBusSubscriber.Bus.GAME)
public class AFBrewingRecipes {

    @SubscribeEvent
    public static void onCommonSetup(RegisterBrewingRecipesEvent event) {
        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("BrewingRecipes event registration triggered");
        }

        event.getBuilder().addRecipe(
                Ingredient.of(PotionContents.createItemStack(Items.POTION, Potions.AWKWARD)),
                Ingredient.of(Items.TROPICAL_FISH),
                PotionContents.createItemStack(Items.POTION, Potions.LUCK));

        event.getBuilder().addRecipe(
                Ingredient.of(PotionContents.createItemStack(Items.POTION, Potions.AWKWARD)),
                Ingredient.of(AFItems.getFish(EnumFishType.MANDARINFISH)),
                new ItemStack(Items.EXPERIENCE_BOTTLE)
        );
    }

}
