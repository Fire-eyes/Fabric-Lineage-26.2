package net.fire_eyes.lineagemod.block;

import net.fabricmc.fabric.mixin.content.registry.BlockBehaviourAccessor;
import net.fire_eyes.lineagemod.LineageMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Final;

import java.util.function.Function;

public class ModBlocks {
    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        /*Register Block Behavior Properties and Identifiers */
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(LineageMod.MOD_ID, name))));
        /*Register Associated block Item*/
        registerBlockItem(name, toRegister);
        /*Register Block*/
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(LineageMod.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(LineageMod.MOD_ID, name),
            new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(LineageMod.MOD_ID, name)))));
    }


    public static void registerModBlocks() {
        LineageMod.LOGGER.info("Registering Mod Blocks for: " + LineageMod.MOD_ID);
    }

    //Helper Function used to get the Resource Keys used for Tags
    public static ResourceKey<Block> gerRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
}
