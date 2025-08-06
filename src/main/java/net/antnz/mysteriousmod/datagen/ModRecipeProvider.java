package net.antnz.mysteriousmod.datagen;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MYSTERIOUS_SWORD_BLOCK)
                .pattern("lcl")
                .pattern("lcl")
                .pattern("lsl")
                .input('c', ModItems.MYSTERIOUS_ITEM)
                .input('l', Items.LAPIS_LAZULI)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MYSTERIOUS_AXE_BLOCK)
                .pattern("lcc")
                .pattern("lsc")
                .pattern("lsl")
                .input('c', ModItems.MYSTERIOUS_ITEM)
                .input('l', Items.LAPIS_LAZULI)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MYSTERIOUS_PICKAXE_BLOCK)
                .pattern("ccc")
                .pattern("lsl")
                .pattern("lsl")
                .input('c', ModItems.MYSTERIOUS_ITEM)
                .input('l', Items.LAPIS_LAZULI)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MYSTERIOUS_SHOVEL_BLOCK)
                .pattern("lcl")
                .pattern("lsl")
                .pattern("lsl")
                .input('c', ModItems.MYSTERIOUS_ITEM)
                .input('l', Items.LAPIS_LAZULI)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MYSTERIOUS_HOE_BLOCK)
                .pattern("lcc")
                .pattern("lsl")
                .pattern("lsl")
                .input('c', ModItems.MYSTERIOUS_ITEM)
                .input('l', Items.LAPIS_LAZULI)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MYSTERIOUS_LAMP_BLOCK)
                .pattern("ccc")
                .pattern("clc")
                .pattern("ccc")
                .input('c', ModItems.MYSTERIOUS_ITEM)
                .input('l', Items.LANTERN)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);

        ;





    }

}
