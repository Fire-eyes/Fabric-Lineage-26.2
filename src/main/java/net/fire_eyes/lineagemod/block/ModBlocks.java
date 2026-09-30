package net.fire_eyes.lineagemod.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class ModBlocks {

    //Helper Function used to get the Resource Keys used for Tags
    public static ResourceKey<Block> gerRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
}
