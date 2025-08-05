package net.antnz.mysteriousmod.datagen;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.MYSTERIOUS_PICKAXE_BLOCK, oreDrops(ModBlocks.MYSTERIOUS_PICKAXE_BLOCK, ModItems.MYSTERIOUS_PICKAXE));
        addDrop(ModBlocks.MYSTERIOUS_HOE_BLOCK, oreDrops(ModBlocks.MYSTERIOUS_HOE_BLOCK, ModItems.MYSTERIOUS_HOE));
        addDrop(ModBlocks.MYSTERIOUS_SHOVEL_BLOCK, oreDrops(ModBlocks.MYSTERIOUS_SHOVEL_BLOCK, ModItems.MYSTERIOUS_SHOVEL));
        addDrop(ModBlocks.MYSTERIOUS_SWORD_BLOCK, oreDrops(ModBlocks.MYSTERIOUS_SWORD_BLOCK, ModItems.MYSTERIOUS_SWORD));
        addDrop(ModBlocks.MYSTERIOUS_AXE_BLOCK, oreDrops(ModBlocks.MYSTERIOUS_AXE_BLOCK, ModItems.MYSTERIOUS_AXE));

    }
}
