package net.fire_eyes.lineagemod.keymapping;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fire_eyes.lineagemod.LineageMod;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {
    public static final KeyMapping PRIMARY_ACTIVE_ABILITY = KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.lineage.primary",
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_Z, KeyMapping.Category.MISC)
    );
    public static final KeyMapping SECONDARY_ACTIVE_ABILITY = KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.lineage.secondary",
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_G, KeyMapping.Category.MISC)
    );

    public static void register() {
        LineageMod.LOGGER.info("Registering ModKeyMappings for " + LineageMod.MOD_ID);
    }
}
