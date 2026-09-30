package net.fire_eyes.lineage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fire_eyes.lineage.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ModTags.Items.DIET_CARNIVORE)
                .addTag(ItemTags.MEAT)
                .add(ItemIds.COD)
                .add(ItemIds.COOKED_COD)
                .add(ItemIds.COOKED_SALMON)
                .add(ItemIds.PUFFERFISH)
                .add(ItemIds.RABBIT_STEW)
                .add(ItemIds.SALMON)
                .add(ItemIds.SPIDER_EYE)
                .add(ItemIds.TROPICAL_FISH);
    }

}
