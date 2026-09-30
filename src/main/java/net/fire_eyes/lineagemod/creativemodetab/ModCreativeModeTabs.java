package net.fire_eyes.lineagemod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fire_eyes.lineagemod.LineageMod;
import net.fire_eyes.lineagemod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    public static CreativeModeTab LINEAGE_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(LineageMod.MOD_ID, "lineage_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LINEAGE_LINE))
                    .title(Component.translatable("creativetab.lineage.items"))
                    .displayItems((parameters, output) ->{
                        output.accept(ModItems.LINEAGE_LINE);
                        output.accept(ModItems.MISC_SECOND_ITEM);
                    }).build());

    public static void registerModCreativeModeTabs() {
        LineageMod.LOGGER.info("Registering Creative Mode Tabs for " + LineageMod.MOD_ID);
    }
}
