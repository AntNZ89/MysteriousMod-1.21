package net.antnz.mysteriousmod.datagen;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MYSTERIOUS_CHISEL)
                .pattern("isi")
                .pattern("aph")
                .pattern("iSi")
                .input('s', ModItems.MYSTERIOUS_SWORD)
                .input('p', ModItems.MYSTERIOUS_PICKAXE)
                .input('h', ModItems.MYSTERIOUS_HOE)
                .input('a', ModItems.MYSTERIOUS_AXE)
                .input('S', ModItems.MYSTERIOUS_SHOVEL)
                .input('i' , ModItems.MYSTERIOUS_ITEM)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MYSTERIOUS_MUTTON)
                .input(ModItems.MYSTERIOUS_ITEM)
                .input(Items.MUTTON)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTERIOUS_BLOCK)
                .input(ModItems.MYSTERIOUS_ITEM, 9)
                .criterion(hasItem(ModItems.MYSTERIOUS_ITEM), conditionsFromItem(ModItems.MYSTERIOUS_ITEM))
                .offerTo(recipeExporter);

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTERIOUS_SLAB, ModItems.MYSTERIOUS_ITEM);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.PRESSURE_PLATE, ModItems.MYSTERIOUS_ITEM);
        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTERIOUS_WALL, ModItems.MYSTERIOUS_ITEM);

        offerButtonRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTERIOUS_BUTTON, ModItems.MYSTERIOUS_ITEM);
        offerFenceRecipe(recipeExporter, ModBlocks.MYSTERIOUS_FENCE, ModBlocks.MYSTERIOUS_BLOCK);
        offerFenceGateRecipe(recipeExporter, ModBlocks.MYSTERIOUS_FENCE_GATE, ModBlocks.MYSTERIOUS_BLOCK);
        offerStairsRecipe(recipeExporter, ModBlocks.MYSTERIOUS_STAIRS, ModItems.MYSTERIOUS_ITEM);
        offerDoorRecipe(recipeExporter, ModBlocks.PINK_GARNET_DOOR, ModItems.MYSTERIOUS_ITEM);
        offerTrapdoorRecipe(recipeExporter, ModBlocks.PINK_GARNET_TRAPDOOR, ModItems.MYSTERIOUS_ITEM);


    }


    private static void offerTrapdoorRecipe(RecipeExporter exporter, ItemConvertible output,ItemConvertible input){
        createTrapdoorRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    private static void offerDoorRecipe(RecipeExporter exporter, ItemConvertible output ,ItemConvertible input){
        createDoorRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    private static void offerStairsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input){
        createStairsRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    private static void offerFenceRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input){
        createFenceRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    private static void offerFenceGateRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input){
        createFenceGateRecipe(output, Ingredient.ofItems(new ItemConvertible[]{input})).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }


    private static void offerButtonRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input){
        ShapelessRecipeJsonBuilder.create(category, output).input(input).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }


}
