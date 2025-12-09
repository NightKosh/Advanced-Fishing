package nightkosh.advanced_fishing.gametest;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFItems;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

@GameTestHolder(ModInfo.ID)
@PrefixGameTestTemplate(false)
public class BrewingRecipesTests {

    private static final String TEMPLATE = "empty";

    @GameTest(template = TEMPLATE)
    public static void brewingLuckPotion(GameTestHelper helper) {
        defaultTest(helper, "brewing_luck_potion",
                PotionUtils.setPotion(
                        new ItemStack(Items.POTION),
                        Potions.AWKWARD
                ),
                new ItemStack(Items.TROPICAL_FISH),
                PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LUCK));
    }

    @GameTest(template = TEMPLATE)
    public static void brewingExperiencePotion(GameTestHelper helper) {
        defaultTest(helper, "brewing_experience_potion",
                PotionUtils.setPotion(
                        new ItemStack(Items.POTION),
                        Potions.AWKWARD
                ),
                new ItemStack(AFItems.getFish(EnumFishType.MANDARINFISH)),
                new ItemStack(Items.EXPERIENCE_BOTTLE));
    }

    protected static void defaultTest(
            GameTestHelper helper, String recipeName,
            ItemStack basePotion, ItemStack ingredient, ItemStack expectedPotion) {
        var resultPotion = BrewingRecipeRegistry.getOutput(basePotion, ingredient);

        if (resultPotion.isEmpty()) {
            helper.fail("Can't find " + recipeName + " potion recipe in BrewingRecipeRegistry.");
            return;
        }

        if (!resultPotion.getHoverName().getString().equals(expectedPotion.getHoverName().getString())) {
            helper.fail("Expected " + expectedPotion.getHoverName().getString() + " but get " + resultPotion.getHoverName().getString());
            return;
        }

        LOGGER.info("Test for " + recipeName + " brewing recipe passed!");

        helper.succeed();
    }

}
