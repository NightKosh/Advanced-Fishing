package nightkosh.advanced_fishing.core;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.entity.item.EntityFireproofItem;
import nightkosh.advanced_fishing.entity.projectile.EntityCustomFishHook;
import nightkosh.advanced_fishing.entity.projectile.EntityLavaFishHook;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Entity {

    private static int mobId = 0;

    private Entity() {
    }

    public static final String CUSTOM_FISH_HOOK_NAME = "CustomFishHook";
    public static final String LAVA_FISH_HOOK_NAME = "LavaFishHook";
    public static final String FIREPROOF_ITEM_NAME = "FireproofItem";

    // EntityList
    public static final ResourceLocation CUSTOM_FISH_HOOK_ID = new ResourceLocation(ModInfo.ID + ":custom_fish_hook");
    public static final ResourceLocation LAVA_FISH_HOOK_ID = new ResourceLocation(ModInfo.ID + ":lava_fish_hook");
    public static final ResourceLocation FIREPROOF_ITEM_ID = new ResourceLocation(ModInfo.ID + ":fireproof_item");


    public static void registration() {
        registerModEntity(CUSTOM_FISH_HOOK_ID, EntityCustomFishHook.class, CUSTOM_FISH_HOOK_NAME);
        registerModEntity(LAVA_FISH_HOOK_ID, EntityLavaFishHook.class, LAVA_FISH_HOOK_NAME);
        registerModEntity(FIREPROOF_ITEM_ID, EntityFireproofItem.class, FIREPROOF_ITEM_NAME);
    }

    private static void registerModEntity(ResourceLocation resource, Class<? extends net.minecraft.entity.Entity> entityClass, String entityName) {
        EntityRegistry.registerModEntity(resource, entityClass, entityName, mobId, ModInfo.ID, 100, 1, true);
        mobId++;
    }
}
