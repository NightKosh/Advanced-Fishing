package nightkosh.advanced_fishing.gametest;

import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFItems;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

//TODO
//@GameTestHolder(ModInfo.ID)
//@PrefixGameTestTemplate(false)
public class BrewingRecipesTests {

    private static final String TEMPLATE = "empty";
//
//    @GameTest(template = TEMPLATE)
//    public static void brewingLuckPotion(GameTestHelper helper) {
//        defaultTest(helper, "brewing_luck_potion",
//                PotionContents.createItemStack(Items.POTION, Potions.AWKWARD),
//                new ItemStack(Items.TROPICAL_FISH),
//                PotionContents.createItemStack(Items.POTION, Potions.LUCK));
//    }
//
//    @GameTest(template = TEMPLATE)
//    public static void brewingExperiencePotion(GameTestHelper helper) {
//        defaultTest(helper, "brewing_experience_potion",
//                PotionContents.createItemStack(Items.POTION, Potions.AWKWARD),
//                new ItemStack(AFItems.getFish(EnumFishType.MANDARINFISH)),
//                new ItemStack(Items.EXPERIENCE_BOTTLE));
//    }

    protected static void defaultTest(
            GameTestHelper helper, String recipeName,
            ItemStack basePotion, ItemStack ingredient, ItemStack expectedPotion) {

        var server = helper.getLevel().getServer();
        var potionBrewing = server.potionBrewing();
        var resultPotion = potionBrewing.mix(ingredient.copy(), basePotion.copy());

        if (resultPotion.isEmpty() || ItemStack.isSameItemSameComponents(resultPotion, basePotion)) {
            helper.fail("Can't find " + recipeName + " potion recipe in BrewingRecipeRegistry.");
            return;
        }

        if (!ItemStack.isSameItemSameComponents(resultPotion, expectedPotion)) {
            helper.fail("Expected " + expectedPotion.getHoverName().getString() + " but get " + resultPotion.getHoverName().getString());
            return;
        }

        LOGGER.info("Test for " + recipeName + " brewing recipe passed!");

        helper.succeed();
    }

}
