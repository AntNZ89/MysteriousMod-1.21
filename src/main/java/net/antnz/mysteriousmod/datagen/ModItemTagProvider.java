package net.antnz.mysteriousmod.datagen;

import net.antnz.mysteriousmod.item.ModItems;
import net.antnz.mysteriousmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE)
                .add(Items.GRASS_BLOCK);


        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.MYSTERIOUS_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.MYSTERIOUS_SWORD);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.MYSTERIOUS_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.MYSTERIOUS_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.MYSTERIOUS_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MYSTERIOUS_BOOTS)
                .add(ModItems.MYSTERIOUS_LEGGINGS)
                .add(ModItems.MYSTERIOUS_CHESTPLATE)
                .add(ModItems.MYSTERIOUS_HELMET);

    }
}
