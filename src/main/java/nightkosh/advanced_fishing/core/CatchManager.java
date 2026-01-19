package nightkosh.advanced_fishing.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import nightkosh.advanced_fishing.api.fishing_catch.ICatch;
import nightkosh.advanced_fishing.api.fishing_catch.ICatchManager;
import nightkosh.advanced_fishing.api.fishing_catch.ILiquidCatch;
import nightkosh.advanced_fishing.api.fishing_catch.IWaterCondition;

import javax.annotation.Nullable;
import java.util.*;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CatchManager implements ICatchManager {

    public static final CatchManager INSTANCE = new CatchManager();

    private static final Map<Block, ICatch> CATCH = new HashMap<>();
    private static final Map<IWaterCondition, ILiquidCatch> CATCH_WATER = new HashMap<>();
    private static final Map<IWaterCondition, ILiquidCatch> CATCH_LAVA = new HashMap<>();

    static {
        CATCH.put(Blocks.WATER, CatchManager::getWaterCatch);
        CATCH.put(Blocks.LAVA, CatchManager::getLavaCatch);

        CATCH_WATER.put(h -> h.is(BiomeTags.IS_OCEAN), CatchManager::getOceanCatch);
        CATCH_WATER.put(h -> h.is(BiomeTags.IS_BEACH), CatchManager::getBeachCatch);
        CATCH_WATER.put(h -> h.is(BiomeTags.IS_END), CatchManager::getEndCatch);
        CATCH_WATER.put(h -> {
            return h.is(Biomes.DESERT)
                    || h.is(Biomes.BADLANDS)
                    || h.is(Biomes.ERODED_BADLANDS)
                    || h.is(Biomes.WOODED_BADLANDS)
                    || h.is(Biomes.SAVANNA)
                    || h.is(Biomes.SAVANNA_PLATEAU)
                    || h.is(Biomes.WINDSWEPT_SAVANNA);//TODO tags?
        }, CatchManager::getSandyCatch);
        CATCH_WATER.put(h -> {
            return h.is(Biomes.SNOWY_PLAINS)
                    || h.is(Biomes.ICE_SPIKES)
                    || h.is(Biomes.SNOWY_TAIGA)
                    || h.is(Biomes.GROVE)
                    || h.is(Biomes.SNOWY_SLOPES)
                    || h.is(Biomes.FROZEN_RIVER)
                    || h.is(Biomes.SNOWY_BEACH)
                    || h.is(Biomes.FROZEN_OCEAN)
                    || h.is(Biomes.DEEP_FROZEN_OCEAN);//TODO tags?
        }, CatchManager::getSnowyCatch);
        CATCH_WATER.put(h -> {
            return h.is(Biomes.SWAMP) || h.is(Biomes.MANGROVE_SWAMP);//TODO tags?
        }, CatchManager::getSwampCatch);
        CATCH_WATER.put(h -> h.is(BiomeTags.IS_JUNGLE), CatchManager::getJungleCatch);
        CATCH_WATER.put(h -> {
            return h.is(Biomes.MUSHROOM_FIELDS);//TODO tags?
        }, CatchManager::getMushroomCatch);
        CATCH_WATER.put(h -> h.is(BiomeTags.IS_BADLANDS), CatchManager::getDeadCatch);

        CATCH_LAVA.put(h -> h.is(Biomes.BASALT_DELTAS), CatchManager::getBasaltDeltas);
        CATCH_LAVA.put(h -> h.is(Biomes.CRIMSON_FOREST) || h.is(Biomes.WARPED_FOREST), CatchManager::getNetherForests);
        CATCH_LAVA.put(h -> h.is(Biomes.NETHER_WASTES), CatchManager::getNetherWastes);
        CATCH_LAVA.put(h -> h.is(Biomes.SOUL_SAND_VALLEY), CatchManager::getNetherSoulSandValley);
    }

    @Override
    public void addCatch(Block block, ICatch fishingCatch) {
        CATCH.put(block, fishingCatch);
    }

    @Override
    public void addWaterCatch(IWaterCondition condition, ILiquidCatch waterCatch) {
        CATCH_WATER.put(condition, waterCatch);
    }

    @Override
    public ICatch getICatch(Level level, BlockPos pos, Block block) {
        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("--------------------------------");
            LOGGER.info("Fishing in : " + block.toString());
        }
        if (!CATCH.containsKey(block)) {
            block = findLiquid(level, pos).orElse(block);
            LOGGER.info("New fishing block : " + block.toString());
        }
        return CATCH.getOrDefault(block, CatchManager::getWaterCatch);
    }

    private Optional<Block> findLiquid(Level level, BlockPos pos) {
        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("Got wrong hook position. Going to find correct one");
        }
        if (level.getBlockState(pos.north()).is(Blocks.AIR)) {
            var block = findLiquid(level, pos.below());
            if (CATCH.containsKey(block.orElse(Blocks.BEDROCK))) {
                return block;
            }
        }
        var block = level.getBlockState(pos.north()).getBlock();
        if (CATCH.containsKey(block)) {
            return Optional.of(block);
        } else {
            block = level.getBlockState(pos.south()).getBlock();
            if (CATCH.containsKey(block)) {
                return Optional.of(block);
            } else {
                block = level.getBlockState(pos.east()).getBlock();
                if (CATCH.containsKey(block)) {
                    return Optional.of(block);
                } else {
                    block = level.getBlockState(pos.west()).getBlock();
                    if (CATCH.containsKey(block)) {
                        return Optional.of(block);
                    }
                }
            }
        }
        return Optional.of(block);
    }

    public static List<ItemStack> getWaterCatch(LootParams.Builder lootBuilder, Level level, BlockPos pos, float luck) {
        int chance = getChance(level.random, luck);

        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("Get fishing catch from water");
        }

        if (chance < 10) {
            if (AFConfig.DEBUG_MODE.get()) {
                LOGGER.info("Going to catch junk");
            }
            return getCatch(lootBuilder, level, LootTables.FISHING_JUNK);
        } else if (chance < 95) {
            List<ItemStack> list = new ArrayList<>();
            if (!level.canSeeSky(pos) && getChance(level.random, luck) >= 30) {
                if (AFConfig.DEBUG_MODE.get()) {
                    LOGGER.info("Fishing in cave at depth {}", pos.getY());
                }
                if (pos.getY() < -30) {
                    list.addAll(getCatch(lootBuilder, level, LootTables.FISHING_CAVE__30));
                } else if (pos.getY() < -10) {
                    list.addAll(getCatch(lootBuilder, level, LootTables.FISHING_CAVE__10));
                } else if (pos.getY() < 15) {
                    list.addAll(getCatch(lootBuilder, level, LootTables.FISHING_CAVE_15));
                } else if (pos.getY() < 30) {
                    list.addAll(getCatch(lootBuilder, level, LootTables.FISHING_CAVE_30));
                } else if (pos.getY() < 50) {
                    list.addAll(getCatch(lootBuilder, level, LootTables.FISHING_CAVE_50));
                } else {
                    list.addAll(getCatch(lootBuilder, level, LootTables.FISHING_CAVE));
                }
            } else {
                var biomeHolder = level.getBiome(pos);

                if (AFConfig.DEBUG_MODE.get()) {
                    LOGGER.info("Fishing in " + getBiomeRes(biomeHolder));
                }

                for (var condition : CATCH_WATER.keySet()) {
                    if (condition.shouldGetCatch(biomeHolder)) {
                        list.addAll(CATCH_WATER.get(condition).getCatch(lootBuilder, level, biomeHolder, luck));
                    }
                }
            }

            // in case of unsupported biomes or other problems get default catch
            if (list.isEmpty()) {
                if (AFConfig.DEBUG_MODE.get()) {
                    LOGGER.info("No specific catch! Trying to get default catch.");
                }
                list = getCatch(lootBuilder, level, LootTables.FISHING);

                if (list.isEmpty()) {
                    if (AFConfig.DEBUG_MODE.get()) {
                        LOGGER.info("No catch again! Trying to get vanilla catch.");
                    }
                    list = getCatch(lootBuilder, level, LootTables.FISHING_VANILLA);
                }
            }

            return list;
        } else {
            if (AFConfig.DEBUG_MODE.get()) {
                LOGGER.info("Going to catch treasure");
            }
            return getCatch(lootBuilder, level, LootTables.FISHING_TREASURE);
        }
    }


    public static List<ItemStack> getOceanCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        if (biomeHolder.is(BiomeTags.IS_DEEP_OCEAN)) {
            return getCatch(lootBuilder, level, LootTables.FISHING_OCEAN_DEEP);
        } else {
            return getCatch(lootBuilder, level, LootTables.FISHING_OCEAN);
        }
    }

    public static List<ItemStack> getBeachCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_OCEAN);
    }

    public static List<ItemStack> getEndCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_END);
    }

    public static List<ItemStack> getSandyCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_SANDY);
    }

    public static List<ItemStack> getSnowyCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_SNOWY);
    }

    public static List<ItemStack> getSwampCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_SWAMP);
    }

    public static List<ItemStack> getJungleCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_JUNGLE);
    }

    public static List<ItemStack> getMushroomCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_MUSHROOM);
    }

    public static List<ItemStack> getDeadCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_DEAD);
    }

    public static List<ItemStack> getLavaCatch(LootParams.Builder lootBuilder, Level level, BlockPos pos, float luck) {
        var biomeHolder = level.getBiome(pos);

        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("Get fishing catch from lava, fishing in " + getBiomeRes(biomeHolder));
        }

        if (biomeHolder.is(BiomeTags.IS_NETHER)) {
            int chance = getChance(level.random, luck);
            if (chance < 95) {
                List<ItemStack> list = new ArrayList<>();
                if (AFConfig.DEBUG_MODE.get()) {
                    LOGGER.info("Fishing in " + getBiomeRes(biomeHolder));
                }

                for (var condition : CATCH_LAVA.keySet()) {
                    if (condition.shouldGetCatch(biomeHolder)) {
                        list.addAll(CATCH_LAVA.get(condition).getCatch(lootBuilder, level, biomeHolder, luck));
                    }
                }

                if (list.isEmpty()) {
                    if (AFConfig.DEBUG_MODE.get()) {
                        LOGGER.info("No specific catch! Trying to get default catch.");
                    }
                    list = getCatch(lootBuilder, level, LootTables.FISHING_NETHER);
                }
                return list;
            } else {
                return getCatch(lootBuilder, level, LootTables.FISHING_NETHER_TREASURE);
            }
        } else {
            return getCatch(lootBuilder, level, LootTables.FISHING_LAVA);
        }
    }

    public static List<ItemStack> getBasaltDeltas(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_NETHER_BASALT_DELTAS);
    }

    public static List<ItemStack> getNetherForests(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_NETHER_FORESTS);
    }

    public static List<ItemStack> getNetherWastes(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_NETHER_WASTES);
    }

    public static List<ItemStack> getNetherSoulSandValley(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck) {
        return getCatch(lootBuilder, level, LootTables.FISHING_NETHER_SOUL_SAND_VALLEY);
    }

    public static List<ItemStack> getCatch(LootParams.Builder lootBuilder, Level level, Identifier lootTableRes) {
        var fishingCatch = level.getServer()
                .reloadableRegistries()
                .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, lootTableRes))
                .getRandomItems(lootBuilder.create(LootContextParamSets.FISHING));
        level.getServer()
                .reloadableRegistries().getLootTable(BuiltInLootTables.FISHING);

        if (AFConfig.DEBUG_MODE.get() && !fishingCatch.isEmpty()) {
            LOGGER.info("You catch next items : ");
            for (var c : fishingCatch) {
                LOGGER.info("- {} x{}", c.getHoverName().getString(), c.getCount());
            }
        }

        return fishingCatch;
    }

    @Nullable
    private static Identifier getBiomeRes(Holder<Biome> biomeHolder) {
        return biomeHolder.unwrapKey()
                .map(ResourceKey::identifier)
                .orElse(null);
    }

    private static int getChance(RandomSource random, float luck) {
        return random.nextInt(100) + Math.round(luck);
    }

}
