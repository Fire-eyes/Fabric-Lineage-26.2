package net.fire_eyes.lineagemod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fire_eyes.lineagemod.block.ModBlocks;
import net.fire_eyes.lineagemod.creativemodetab.ModCreativeModeTabs;
import net.fire_eyes.lineagemod.item.ModItems;
import net.fire_eyes.lineagemod.networking.ModPackets;
import net.fire_eyes.lineagemod.tags.ModTags;
import net.minecraft.core.component.DataComponents;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LineageMod implements ModInitializer {
	public static final String MOD_ID = "lineagemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		//Register Stuff
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModPackets.registerPackets();

		//Locate Lineage File Path


		UseItemCallback.EVENT.register((player, level, hand) -> {
			ItemStack stack = player.getItemInHand(hand);
			// Check whether the item has a food component
			boolean isFood = stack.get(DataComponents.FOOD) != null;

			// Allowed Food Items
			boolean isAllowedDiet = stack.is(ModTags.Items.DIET_CARNIVORE);

			if (isFood && !isAllowedDiet) {
				return InteractionResult.FAIL;
			}

			// Allow the special food and all non-food items to work normally
			return InteractionResult.PASS;
		});
	}

}
