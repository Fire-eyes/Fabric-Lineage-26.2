package net.fire_eyes.lineagemod.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fire_eyes.lineagemod.LineageMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    //Creating new Item; Can edit properties by changing 'Item::new' into a lamba expression
    public static Item LINEAGE_LINE = registerItem("lineage_line",  Item::new);
    public static Item MISC_SECOND_ITEM = registerItem("misc_second_item",  Item::new);

    //Helper Function
    public static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(LineageMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(LineageMod.MOD_ID, name)))));
    }

    //Helper Function used to get the Resource Keys used for Tags
    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    public static void registerModItems() {
        LineageMod.LOGGER.info("Registering Mod Items for: " + LineageMod.MOD_ID);

        // Registers ModItems into Creative Mode tab
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
                output.accept(LINEAGE_LINE);
                output.accept(MISC_SECOND_ITEM);
        });
    }
}
