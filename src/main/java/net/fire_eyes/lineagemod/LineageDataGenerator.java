package net.fire_eyes.lineagemod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fire_eyes.lineagemod.datagen.ModBlockTagsProvider;
import net.fire_eyes.lineagemod.datagen.ModItemTagsProvider;
import net.fire_eyes.lineagemod.datagen.ModModelProvider;

public class LineageDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider((ModItemTagsProvider::new));
		pack.addProvider((ModBlockTagsProvider::new));

	}
}
