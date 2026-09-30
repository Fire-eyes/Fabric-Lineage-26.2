package net.fire_eyes.lineage;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fire_eyes.lineage.datagen.ModBlockTagsProvider;
import net.fire_eyes.lineage.datagen.ModItemTagsProvider;
import net.fire_eyes.lineage.datagen.ModModelProvider;

public class LineageDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider((ModItemTagsProvider::new));
		pack.addProvider((ModBlockTagsProvider::new));

	}
}
