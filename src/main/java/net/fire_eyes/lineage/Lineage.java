package net.fire_eyes.lineage;

import net.fabricmc.api.ModInitializer;

import net.fire_eyes.lineage.creativemodetab.ModCreativeModeTabs;
import net.fire_eyes.lineage.item.ModItems;
import net.fire_eyes.lineage.networking.ModPackets;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lineage implements ModInitializer {
	public static final String MOD_ID = "lineage";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();

		ModPackets.registerPackets();
	}

}
