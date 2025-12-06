package nightkosh.advanced_fishing.core;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.entity.item.FireproofItemEntity;
import nightkosh.advanced_fishing.entity.projectile.CustomFishHook;
import nightkosh.advanced_fishing.entity.projectile.LavaFishHook;

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

    public static final String CUSTOM_FISH_HOOK_NAME = ModInfo.ID + ":" + CUSTOM_FISH_HOOK_ID;
    public static final String LAVA_FISH_HOOK_NAME = ModInfo.ID + ":" + LAVA_FISH_HOOK_ID;
    public static final String FIREPROOF_ITEM_NAME = ModInfo.ID + ":" + FIREPROOF_ITEM_ID;

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES_REGISTER =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModInfo.ID);

    public static final RegistryObject<EntityType<CustomFishHook>> CUSTOM_FISH_HOOK =
            ENTITY_TYPES_REGISTER.register(CUSTOM_FISH_HOOK_ID,
                    () -> EntityType.Builder.<CustomFishHook>of(CustomFishHook::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .build(CUSTOM_FISH_HOOK_NAME));

    public static final RegistryObject<EntityType<LavaFishHook>> LAVA_FISH_HOOK =
            ENTITY_TYPES_REGISTER.register(LAVA_FISH_HOOK_ID,
                    () -> EntityType.Builder.<LavaFishHook>of(LavaFishHook::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .fireImmune()
                            .build(LAVA_FISH_HOOK_NAME));

    public static final RegistryObject<EntityType<FireproofItemEntity>> FIREPROOF_ITEM =
            ENTITY_TYPES_REGISTER.register(FIREPROOF_ITEM_ID,
                    () -> EntityType.Builder.<FireproofItemEntity>of(FireproofItemEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .fireImmune()
                            .build(FIREPROOF_ITEM_NAME));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES_REGISTER.register(eventBus);
    }

    public static EntityType<CustomFishHook> getCustomFishHook() {
        return CUSTOM_FISH_HOOK.get();
    }

    public static EntityType<LavaFishHook> getLavaFishHook() {
        return LAVA_FISH_HOOK.get();
    }

    public static EntityType<FireproofItemEntity> getFireproofItem() {
        return FIREPROOF_ITEM.get();
    }

}
