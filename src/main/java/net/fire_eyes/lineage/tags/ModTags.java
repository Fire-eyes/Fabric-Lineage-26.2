package net.fire_eyes.lineage.tags;

import net.fire_eyes.lineage.Lineage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public  static class Blocks {
        public static TagKey<Block> COOL_BLOCKS = createTag("cool_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Lineage.MOD_ID, name));
        }
    }

    public  static class Items {
        public static TagKey<Item> DIET_CARNIVORE = createTag("diet_carnivore");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Lineage.MOD_ID, name));
        }
    }
}
