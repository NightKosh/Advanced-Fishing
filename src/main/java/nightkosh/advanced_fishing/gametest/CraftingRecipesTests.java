package nightkosh.advanced_fishing.gametest;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFItems;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;
import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

@GameTestHolder(ModInfo.ID)
@PrefixGameTestTemplate(false)
public class CraftingRecipesTests {

    private static final String TEMPLATE = "empty";

    @GameTest(template = TEMPLATE)
    public static void fishToBlazeRod(GameTestHelper helper) {
        defaultTest(helper, "fish_to_blaze_rod",
                AFItems.getFish(EnumFishType.BLAZE_PIKE),
                new ItemStack(Items.BLAZE_ROD, 1));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToBone(GameTestHelper helper) {
        defaultTest(helper, "fish_to_bone",
                AFItems.getFish(EnumFishType.BONE_FISH),
                new ItemStack(Items.BONE, 3));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToBrownMushroom(GameTestHelper helper) {
        defaultTest(helper, "fish_to_brown_mushroom",
                AFItems.getFish(EnumFishType.BROWN_SHROOMFIN),
                new ItemStack(Items.BROWN_MUSHROOM, 5));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToChorusFruit(GameTestHelper helper) {
        defaultTest(helper, "fish_to_chorus_fruit",
                AFItems.getFish(EnumFishType.CHORUS_KOI),
                new ItemStack(Items.CHORUS_FRUIT));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToClay(GameTestHelper helper) {
        defaultTest(helper, "fish_to_clay",
                AFItems.getFish(EnumFishType.MUD_TUNA),
                new ItemStack(Items.CLAY_BALL, 4));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToEndStone(GameTestHelper helper) {
        defaultTest(helper, "fish_to_end_stone",
                AFItems.getFish(EnumFishType.ENDER_SHAD),
                new ItemStack(Items.END_STONE));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToEnderPearl(GameTestHelper helper) {
        defaultTest(helper, "fish_to_ender_pearl",
                AFItems.getFish(EnumFishType.PEARL_SARDINE),
                new ItemStack(Items.ENDER_PEARL));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToGlowstoneDust(GameTestHelper helper) {
        defaultTest(helper, "fish_to_glowstone_dust",
                AFItems.getFish(EnumFishType.FLAREFIN_KOI),
                new ItemStack(Items.GLOWSTONE_DUST, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToGoldenNugget(GameTestHelper helper) {
        defaultTest(helper, "fish_to_golden_nugget",
                AFItems.getFish(EnumFishType.SUNFISH),
                new ItemStack(Items.GOLD_NUGGET, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToGunpowder(GameTestHelper helper) {
        defaultTest(helper, "fish_to_gunpowder",
                AFItems.getFish(EnumFishType.EXPLOSIVE_CRUCIAN),
                new ItemStack(Items.GUNPOWDER, 3));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToIce(GameTestHelper helper) {
        defaultTest(helper, "fish_to_ice",
                AFItems.getFish(EnumFishType.FROST_MINNOW),
                new ItemStack(Items.ICE));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToInkSac(GameTestHelper helper) {
        defaultTest(helper, "fish_to_ink_sac",
                AFItems.getFish(EnumFishType.SQUID),
                new ItemStack(Items.INK_SAC, 3));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToLava(GameTestHelper helper) {
        defaultTest(helper, "fish_to_lava",
                List.of(Pair.of(0, AFItems.getFish(EnumFishType.MAGMA_JELLYFISH)), Pair.of(1, Items.BUCKET)),
                new ItemStack(Items.LAVA_BUCKET));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToLazurit(GameTestHelper helper) {
        defaultTest(helper, "fish_to_lazurit",
                AFItems.getFish(EnumFishType.CRYSTAL_MULLET),
                new ItemStack(Items.LAPIS_LAZULI, 5));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToLilyPad(GameTestHelper helper) {
        defaultTest(helper, "fish_to_lily_pad",
                AFItems.getFish(EnumFishType.SWAMP_PLAICE),
                new ItemStack(Items.LILY_PAD));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToMagmaCream(GameTestHelper helper) {
        defaultTest(helper, "fish_to_magma_cream",
                AFItems.getFish(EnumFishType.MAGMA_JELLYFISH),
                new ItemStack(Items.MAGMA_CREAM));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToNetherWart(GameTestHelper helper) {
        defaultTest(helper, "fish_to_nether_wart",
                AFItems.getFish(EnumFishType.FUNGI_CATFISH),
                new ItemStack(Items.NETHER_WART, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToNetherrack(GameTestHelper helper) {
        defaultTest(helper, "fish_to_netherrack",
                AFItems.getFish(EnumFishType.NETHER_STURGEON),
                new ItemStack(Items.NETHERRACK));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToObsidian(GameTestHelper helper) {
        defaultTest(helper, "fish_to_obsidian",
                AFItems.getFish(EnumFishType.OBSIDIAN_BREAM),
                new ItemStack(Items.OBSIDIAN));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToPacketIce(GameTestHelper helper) {
        defaultTest(helper, "fish_to_packet_ice",
                AFItems.getFish(EnumFishType.GLACIER_ANCHOVY),
                new ItemStack(Items.PACKED_ICE));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToPrizmarineCrystal(GameTestHelper helper) {
        defaultTest(helper, "fish_to_prizmarine_crystal",
                AFItems.getFish(EnumFishType.ANGLER_FISH),
                new ItemStack(Items.PRISMARINE_CRYSTALS, 2));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToPrizmarineShard(GameTestHelper helper) {
        defaultTest(helper, "fish_to_prizmarine_shard",
                AFItems.getFish(EnumFishType.ABYSSAL_LURKER),
                new ItemStack(Items.PRISMARINE_SHARD, 4));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToQuartz(GameTestHelper helper) {
        defaultTest(helper, "fish_to_quartz",
                AFItems.getFish(EnumFishType.QUARTZ_CHUB),
                new ItemStack(Items.QUARTZ, 4));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToRedMushroom(GameTestHelper helper) {
        defaultTest(helper, "fish_to_red_mushroom",
                AFItems.getFish(EnumFishType.RED_SHROOMFIN),
                new ItemStack(Items.RED_MUSHROOM, 5));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToRedstone(GameTestHelper helper) {
        defaultTest(helper, "fish_to_redstone",
                AFItems.getFish(EnumFishType.CHARGED_BULLHEAD),
                new ItemStack(Items.REDSTONE, 5));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToSand(GameTestHelper helper) {
        defaultTest(helper, "fish_to_sand",
                AFItems.getFish(EnumFishType.SANDY_BASS),
                new ItemStack(Items.SAND));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToSnow(GameTestHelper helper) {
        defaultTest(helper, "fish_to_snow",
                AFItems.getFish(EnumFishType.SNOWY_WALLEYE),
                new ItemStack(Items.SNOWBALL, 4));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToSoulSand(GameTestHelper helper) {
        defaultTest(helper, "fish_to_soul_sand",
                AFItems.getFish(EnumFishType.WITHERED_CRUCIAN),
                new ItemStack(Items.SOUL_SAND));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToSponge(GameTestHelper helper) {
        defaultTest(helper, "fish_to_sponge",
                List.of(Pair.of(0, AFItems.getFish(EnumFishType.SPONGE_EATER)),
                        Pair.of(1, AFItems.getFish(EnumFishType.SPONGE_EATER)),
                        Pair.of(3, AFItems.getFish(EnumFishType.SPONGE_EATER)),
                        Pair.of(4, AFItems.getFish(EnumFishType.SPONGE_EATER))),
                new ItemStack(Items.SPONGE));
    }

    @GameTest(template = TEMPLATE)
    public static void fishToWater(GameTestHelper helper) {
        defaultTest(helper, "fish_to_water",
                List.of(Pair.of(0, AFItems.getFish(EnumFishType.BLUE_JELLYFISH)), Pair.of(1, Items.BUCKET)),
                new ItemStack(Items.WATER_BUCKET));
    }

    protected static void defaultTest(GameTestHelper helper, String recipeName, Item input, ItemStack expected) {
        defaultTest(helper, recipeName, List.of(Pair.of(0, input)), expected);
    }

    protected static void defaultTest(GameTestHelper helper, String recipeName, List<Pair<Integer, Item>> inputs, ItemStack expected) {
        var level = helper.getLevel();

        var res = fromNamespaceAndPath(ModInfo.ID, recipeName);
        var recipeByKey = level.getRecipeManager().byKey(res);

        if (recipeByKey.isEmpty()) {
            helper.fail("Can't find " + res + " recipe in RecipeManager.");
            return;
        }

        if (!(recipeByKey.get() instanceof CraftingRecipe)) {
            helper.fail("Recipe " + recipeName + " isn't an instance of CraftingRecipe: " + recipeByKey.get());
            return;
        }

        var dummyMenu = new AbstractContainerMenu(MenuType.CRAFTING, 0) {

            @Override
            public boolean stillValid(Player player) {
                return true;
            }

            @Override
            public ItemStack quickMoveStack(Player player, int index) {
                return ItemStack.EMPTY;
            }
        };

        var crafting = new CraftingContainer(dummyMenu, 3, 3);
        for (var pair : inputs) {
            crafting.setItem(pair.getKey(), new ItemStack(pair.getValue()));
        }

        var recipeOpt = level.getRecipeManager().getRecipeFor(RecipeType.CRAFTING, crafting, level);
        if (recipeOpt.isEmpty()) {
            helper.fail("Can't find " + recipeName + " crafting recipe.");
            return;
        }

        var result = recipeOpt.get().assemble(crafting, level.registryAccess());
        if (!result.is(expected.getItem())) {
            helper.fail("Expected " + expected.getHoverName().getString() + " item but get " + result.getHoverName().getString());
            return;
        }

        if (result.getCount() != expected.getCount()) {
            helper.fail("Expected " + expected.getCount() + " items but get " + result.getCount());
            return;
        }

        LOGGER.info("Test for " + recipeName + " crafting recipe passed!");

        helper.succeed();
    }

}
