package net.antnz.mysteriousmod.datagen;

import com.ibm.icu.text.Normalizer2;
import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.block.custom.LampBlock;
import net.antnz.mysteriousmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        BlockStateModelGenerator.BlockTexturePool blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MYSTERIOUS_BLOCK);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTERIOUS_SWORD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTERIOUS_AXE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTERIOUS_PICKAXE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTERIOUS_SHOVEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTERIOUS_HOE_BLOCK);

        blockTexturePool.slab(ModBlocks.MYSTERIOUS_SLAB);
        blockTexturePool.button(ModBlocks.MYSTERIOUS_BUTTON);
        blockTexturePool.stairs(ModBlocks.MYSTERIOUS_STAIRS);
        blockTexturePool.fence(ModBlocks.MYSTERIOUS_FENCE);
        blockTexturePool.fenceGate(ModBlocks.MYSTERIOUS_FENCE_GATE);
        blockTexturePool.pressurePlate(ModBlocks.PRESSURE_PLATE);
        blockTexturePool.wall(ModBlocks.MYSTERIOUS_WALL);


//        blockStateModelGenerator.registerTrapdoor(ModBlocks.MYSTERIOUS_TRAPDOOR);
//        blockStateModelGenerator.registerDoor(ModBlocks.MYSTERIOUS_DOOR);





        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.MYSTERIOUS_LAMP_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.MYSTERIOUS_LAMP_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MYSTERIOUS_LAMP_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(LampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));






    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.MYSTERIOUS_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MYSTERIOUS_MUTTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.MYSTERIOUS_COAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.MYSTERIOUS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MYSTERIOUS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MYSTERIOUS_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MYSTERIOUS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MYSTERIOUS_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MYSTERIOUS_CHISEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MYSTERIOUS_REMOVER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MYSTERIOUS_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MYSTERIOUS_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MYSTERIOUS_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MYSTERIOUS_BOOTS));


    }
}
