package net.antnz.mysteriousmod.datagen;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MYSTERIOUS_SWORD_BLOCK)
                .add(ModBlocks.MYSTERIOUS_AXE_BLOCK)
                .add(ModBlocks.MYSTERIOUS_PICKAXE_BLOCK)
                .add(ModBlocks.MYSTERIOUS_SHOVEL_BLOCK)
                .add(ModBlocks.MYSTERIOUS_HOE_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MYSTERIOUS_SWORD_BLOCK)
                .add(ModBlocks.MYSTERIOUS_AXE_BLOCK)
                .add(ModBlocks.MYSTERIOUS_PICKAXE_BLOCK)
                .add(ModBlocks.MYSTERIOUS_SHOVEL_BLOCK)
                .add(ModBlocks.MYSTERIOUS_HOE_BLOCK)
                .add(ModBlocks.MYSTERIOUS_BLOCK);



        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_MYSTERIOUS_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);



        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.MYSTERIOUS_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.MYSTERIOUS_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.MYSTERIOUS_WALL);









    }
}
