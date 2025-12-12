package nightkosh.advanced_fishing.gametest;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFItems;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

@GameTestHolder(ModInfo.ID)
@PrefixGameTestTemplate(false)
public class CampfireCookingRecipesTests {

    private static final String TEMPLATE = "empty";

    @GameTest(template = TEMPLATE)
    public static void cookedAbyssalLurker(GameTestHelper helper) {
        defaultTest(helper, "cooked_abyssal_lurker",
                AFItems.getFish(EnumFishType.ABYSSAL_LURKER),
                new ItemStack(Items.COOKED_COD, 3));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedAngelfish(GameTestHelper helper) {
        defaultTest(helper, "cooked_angelfish",
                AFItems.getFish(EnumFishType.ANGELFISH),
                new ItemStack(Items.COOKED_COD, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedAnglerFish(GameTestHelper helper) {
        defaultTest(helper, "cooked_angler_fish",
                AFItems.getFish(EnumFishType.ANGLER_FISH),
                new ItemStack(Items.COOKED_COD, 3));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedBlazePike(GameTestHelper helper) {
        defaultTest(helper, "cooked_blaze_pike",
                AFItems.getFish(EnumFishType.BLAZE_PIKE),
                new ItemStack(Items.COOKED_COD, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedBlueJellyfish(GameTestHelper helper) {
        defaultTest(helper, "cooked_blue_jellyfish",
                AFItems.getFish(EnumFishType.BLUE_JELLYFISH),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedBrownShroomfin(GameTestHelper helper) {
        defaultTest(helper, "cooked_brown_shroomfin",
                AFItems.getFish(EnumFishType.BROWN_SHROOMFIN),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedCatfish(GameTestHelper helper) {
        defaultTest(helper, "cooked_catfish",
                AFItems.getFish(EnumFishType.CATFISH),
                new ItemStack(Items.COOKED_COD, 3));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedCaveTrout(GameTestHelper helper) {
        defaultTest(helper, "cooked_cave_trout",
                AFItems.getFish(EnumFishType.CAVE_TROUT),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedChargedBullhead(GameTestHelper helper) {
        defaultTest(helper, "cooked_charged_bullhead",
                AFItems.getFish(EnumFishType.CHARGED_BULLHEAD),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedChorusKoi(GameTestHelper helper) {
        defaultTest(helper, "cooked_chorus_koi",
                AFItems.getFish(EnumFishType.CHORUS_KOI),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedCrystalMullet(GameTestHelper helper) {
        defaultTest(helper, "cooked_crystal_mullet",
                AFItems.getFish(EnumFishType.CRYSTAL_MULLET),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedEnderShad(GameTestHelper helper) {
        defaultTest(helper, "cooked_ender_shad",
                AFItems.getFish(EnumFishType.ENDER_SHAD),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedExplosiveCrucian(GameTestHelper helper) {
        defaultTest(helper, "cooked_explosive_crucian",
                AFItems.getFish(EnumFishType.EXPLOSIVE_CRUCIAN),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedFlarefinKoi(GameTestHelper helper) {
        defaultTest(helper, "cooked_flarefin_koi",
                AFItems.getFish(EnumFishType.FLAREFIN_KOI),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedFrostMinnow(GameTestHelper helper) {
        defaultTest(helper, "cooked_frost_minnow",
                AFItems.getFish(EnumFishType.FROST_MINNOW),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedFungiCatfish(GameTestHelper helper) {
        defaultTest(helper, "cooked_fungi_catfish",
                AFItems.getFish(EnumFishType.FUNGI_CATFISH),
                new ItemStack(Items.COOKED_COD, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedGlacierAnchovy(GameTestHelper helper) {
        defaultTest(helper, "cooked_glacier_anchovy",
                AFItems.getFish(EnumFishType.GLACIER_ANCHOVY),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedGoldenKoi(GameTestHelper helper) {
        defaultTest(helper, "cooked_golden_koi",
                AFItems.getFish(EnumFishType.GOLDEN_KOI),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedMagmaJellyfish(GameTestHelper helper) {
        defaultTest(helper, "cooked_magma_jellyfish",
                AFItems.getFish(EnumFishType.MAGMA_JELLYFISH),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedMandarinfish(GameTestHelper helper) {
        defaultTest(helper, "cooked_mandarinfish",
                AFItems.getFish(EnumFishType.MANDARINFISH),
                new ItemStack(Items.COOKED_COD, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedMudTuna(GameTestHelper helper) {
        defaultTest(helper, "cooked_mud_tuna",
                AFItems.getFish(EnumFishType.MUD_TUNA),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedNetherSturgeon(GameTestHelper helper) {
        defaultTest(helper, "cooked_nether_sturgeon",
                AFItems.getFish(EnumFishType.NETHER_STURGEON),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookeObsidianBream(GameTestHelper helper) {
        defaultTest(helper, "cooked_obsidian_bream",
                AFItems.getFish(EnumFishType.OBSIDIAN_BREAM),
                new ItemStack(Items.COOKED_COD, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedPearlSardine(GameTestHelper helper) {
        defaultTest(helper, "cooked_pearl_sardine",
                AFItems.getFish(EnumFishType.PEARL_SARDINE),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedPike(GameTestHelper helper) {
        defaultTest(helper, "cooked_pike",
                AFItems.getFish(EnumFishType.PIKE),
                new ItemStack(Items.COOKED_COD, 3));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedPiranha(GameTestHelper helper) {
        defaultTest(helper, "cooked_piranha",
                AFItems.getFish(EnumFishType.PIRANHA),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedPufferfish(GameTestHelper helper) {
        defaultTest(helper, "cooked_pufferfish",
                Items.PUFFERFISH,
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedQuartzChub(GameTestHelper helper) {
        defaultTest(helper, "cooked_quartz_chub",
                AFItems.getFish(EnumFishType.QUARTZ_CHUB),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedRedShroomfin(GameTestHelper helper) {
        defaultTest(helper, "cooked_red_shroomfin",
                AFItems.getFish(EnumFishType.RED_SHROOMFIN),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedRuffe(GameTestHelper helper) {
        defaultTest(helper, "cooked_ruffe",
                AFItems.getFish(EnumFishType.RUFFE),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedSandyBass(GameTestHelper helper) {
        defaultTest(helper, "cooked_sandy_bass",
                AFItems.getFish(EnumFishType.SANDY_BASS),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedSnowyWalleye(GameTestHelper helper) {
        defaultTest(helper, "cooked_snowy_walleye",
                AFItems.getFish(EnumFishType.SNOWY_WALLEYE),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedSparklingEel(GameTestHelper helper) {
        defaultTest(helper, "cooked_sparkling_eel",
                AFItems.getFish(EnumFishType.SPARKLING_EEL),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedSpecularSnapper(GameTestHelper helper) {
        defaultTest(helper, "cooked_specular_snapper",
                AFItems.getFish(EnumFishType.SPECULAR_SNAPPER),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedSpongeEater(GameTestHelper helper) {
        defaultTest(helper, "cooked_sponge_eater",
                AFItems.getFish(EnumFishType.SPONGE_EATER),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedSquid(GameTestHelper helper) {
        defaultTest(helper, "cooked_squid",
                AFItems.getFish(EnumFishType.SQUID),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedSunfish(GameTestHelper helper) {
        defaultTest(helper, "cooked_sunfish",
                AFItems.getFish(EnumFishType.SUNFISH),
                new ItemStack(Items.COOKED_COD, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedSwampPlaice(GameTestHelper helper) {
        defaultTest(helper, "cooked_swamp_plaice",
                AFItems.getFish(EnumFishType.SWAMP_PLAICE),
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedTropicalFish(GameTestHelper helper) {
        defaultTest(helper, "cooked_tropical_fish",
                Items.TROPICAL_FISH,
                new ItemStack(Items.COOKED_COD));
    }

    @GameTest(template = TEMPLATE)
    public static void cookedWitheredCrucian(GameTestHelper helper) {
        defaultTest(helper, "cooked_withered_crucian",
                AFItems.getFish(EnumFishType.WITHERED_CRUCIAN),
                new ItemStack(Items.COOKED_COD));
    }

    protected static void defaultTest(GameTestHelper helper, String recipeName, Item input, ItemStack expected) {
        var level = helper.getLevel();

        var res = new ResourceLocation(ModInfo.ID, "campfire/" + recipeName);
        var recipeByKey = level.getRecipeManager().byKey(res);

        if (recipeByKey.isEmpty()) {
            helper.fail("Can't find " + res + " recipe in RecipeManager.");
            return;
        }

        if (!(recipeByKey.get().value() instanceof CampfireCookingRecipe)) {
            helper.fail("Recipe " + recipeName + " isn't an instance of CampfireCookingRecipe: " + recipeByKey.get().value());
            return;
        }

        var container = new SimpleContainer(1);
        container.setItem(0, new ItemStack(input));

        var recipeOpt = level.getRecipeManager().getRecipeFor(RecipeType.CAMPFIRE_COOKING, container, level);
        if (recipeOpt.isEmpty()) {
            helper.fail("Can't find " + recipeName + " campfire cooking recipe.");
            return;
        }

        var recipe = recipeOpt.get().value();
        var result = recipe.assemble(container, level.registryAccess());
        if (!result.is(expected.getItem())) {
            helper.fail("Expected " + expected.getHoverName().getString() + " item but get " + result.getHoverName().getString());
            return;
        }

        if (result.getCount() != expected.getCount()) {
            helper.fail("Expected " + expected.getCount() + " items but get " + result.getCount());
            return;
        }

        if (Math.abs(recipe.getExperience() - 0.35f) > 0.0001f) {
            helper.fail("Expected 0.35 experience points, but get " + recipe.getExperience());
            return;
        }

        if (recipe.getCookingTime() != 600) {
            helper.fail("Expected cookingTime = 600, but get " + recipe.getCookingTime());
            return;
        }

        LOGGER.info("Test for " + recipeName + " campfire cooking recipe passed!");

        helper.succeed();
    }

}
