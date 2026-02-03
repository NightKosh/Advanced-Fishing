package nightkosh.advanced_fishing.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.entity.Chum;
import nightkosh.advanced_fishing.entity.item.FireproofItemEntity;
import nightkosh.advanced_fishing.entity.projectile.AdvancedFishHook;
import nightkosh.advanced_fishing.entity.projectile.LavaFishHook;
import nightkosh.advanced_fishing.entity.projectile.ChumBucket;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFEntities {

    public static final String CUSTOM_FISH_HOOK_ID = "custom_fish_hook";
    public static final String LAVA_FISH_HOOK_ID = "lava_fish_hook";
    public static final String FIREPROOF_ITEM_ID = "fireproof_item";
    public static final String CHUM_ID = "chum";
    public static final String CHUM_BUCKET_ID = "chum_bucket";

    public static final Identifier CUSTOM_FISH_HOOK_NAME = fromNamespaceAndPath(ModInfo.ID, CUSTOM_FISH_HOOK_ID);
    public static final Identifier LAVA_FISH_HOOK_NAME = fromNamespaceAndPath(ModInfo.ID, LAVA_FISH_HOOK_ID);
    public static final Identifier FIREPROOF_ITEM_NAME = fromNamespaceAndPath(ModInfo.ID, FIREPROOF_ITEM_ID);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES_REGISTER =
            DeferredRegister.create(Registries.ENTITY_TYPE, ModInfo.ID);

    public static final DeferredHolder<EntityType<?>, EntityType<AdvancedFishHook>> CUSTOM_FISH_HOOK =
            ENTITY_TYPES_REGISTER.register(CUSTOM_FISH_HOOK_ID,
                    () -> EntityType.Builder.<AdvancedFishHook>of(AdvancedFishHook::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(5)
                            .noLootTable()
                            .noSummon()
                            .noSave()
                            .build(ResourceKey.create(Registries.ENTITY_TYPE, CUSTOM_FISH_HOOK_NAME)));

    public static final DeferredHolder<EntityType<?>, EntityType<LavaFishHook>> LAVA_FISH_HOOK =
            ENTITY_TYPES_REGISTER.register(LAVA_FISH_HOOK_ID,
                    () -> EntityType.Builder.<LavaFishHook>of(LavaFishHook::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(5)
                            .noLootTable()
                            .fireImmune()
                            .noSummon()
                            .noSave()
                            .build(ResourceKey.create(Registries.ENTITY_TYPE, LAVA_FISH_HOOK_NAME)));

    public static final DeferredHolder<EntityType<?>, EntityType<FireproofItemEntity>> FIREPROOF_ITEM =
            ENTITY_TYPES_REGISTER.register(FIREPROOF_ITEM_ID,
                    () -> EntityType.Builder.<FireproofItemEntity>of(FireproofItemEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .fireImmune()
                            .build(ResourceKey.create(Registries.ENTITY_TYPE, FIREPROOF_ITEM_NAME)));

    public static final DeferredHolder<EntityType<?>, EntityType<Chum>> CHUM =
            ENTITY_TYPES_REGISTER.register(CHUM_ID,
                    () -> EntityType.Builder.of(Chum::new, MobCategory.MISC)
                            .sized(5, 0.05F)
                            .clientTrackingRange(4)
                            .updateInterval(5)
                            .noLootTable()
                            .build(ResourceKey.create(
                                    Registries.ENTITY_TYPE,
                                    fromNamespaceAndPath(ModInfo.ID, CHUM_ID))));

    // projectiles
    public static final DeferredHolder<EntityType<?>, EntityType<ChumBucket>> CHUM_BUCKET =
            ENTITY_TYPES_REGISTER.register(CHUM_BUCKET_ID,
                    () -> EntityType.Builder.of(
                                    (EntityType<ChumBucket> entityType, Level level) -> new ChumBucket(entityType, level),
                                    MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .noLootTable()
                            .build(ResourceKey.create(
                                    Registries.ENTITY_TYPE,
                                    fromNamespaceAndPath(ModInfo.ID, CHUM_BUCKET_ID))));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES_REGISTER.register(eventBus);
    }

    public static EntityType<AdvancedFishHook> getCustomFishHook() {
        return CUSTOM_FISH_HOOK.get();
    }

    public static EntityType<LavaFishHook> getLavaFishHook() {
        return LAVA_FISH_HOOK.get();
    }

    public static EntityType<FireproofItemEntity> getFireproofItem() {
        return FIREPROOF_ITEM.get();
    }

}
