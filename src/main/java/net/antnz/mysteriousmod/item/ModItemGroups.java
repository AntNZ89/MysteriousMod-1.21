package net.antnz.mysteriousmod.item;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {


    public static final ItemGroup MYSTERIOUS_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MysteriousMod.MOD_ID, "mysterious_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.MYSTERIOUS_ITEM))
                    .displayName(Text.literal("Mysterious Items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MYSTERIOUS_ITEM);
                        entries.add(ModItems.MYSTERIOUS_MUTTON);
                        entries.add(ModItems.MYSTERIOUS_COAL);
                    })
                    .build());



    public static final ItemGroup MYSTERIOUS_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MysteriousMod.MOD_ID, "mysterious_blocks"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModBlocks.MYSTERIOUS_PICKAXE_BLOCK))
                    .displayName(Text.translatable("itemgroup.mysteriousmod.mysterious_blocks"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.MYSTERIOUS_PICKAXE_BLOCK);
                        entries.add(ModBlocks.MYSTERIOUS_AXE_BLOCK);
                        entries.add(ModBlocks.MYSTERIOUS_SHOVEL_BLOCK);
                        entries.add(ModBlocks.MYSTERIOUS_HOE_BLOCK);
                        entries.add(ModBlocks.MYSTERIOUS_SWORD_BLOCK);
                        entries.add(ModBlocks.MYSTERIOUS_LAMP_BLOCK);

                        entries.add(ModBlocks.MYSTERIOUS_SLAB);
                        entries.add(ModBlocks.MYSTERIOUS_BUTTON);
                        entries.add(ModBlocks.MYSTERIOUS_FENCE);
                        entries.add(ModBlocks.MYSTERIOUS_FENCE_GATE);
                        entries.add(ModBlocks.PRESSURE_PLATE);
                        entries.add(ModBlocks.MYSTERIOUS_STAIRS);
                        entries.add(ModBlocks.MYSTERIOUS_WALL);
                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);
                        entries.add(ModBlocks.MYSTERIOUS_BLOCK);

                    })
                    .build());


    public static final ItemGroup MYSTERIOUS_TOOLS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MysteriousMod.MOD_ID, "mysterious_tools"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.MYSTERIOUS_SWORD))
                    .displayName(Text.literal("Mysterious Tools"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.MYSTERIOUS_SWORD);
                        entries.add(ModItems.MYSTERIOUS_PICKAXE);
                        entries.add(ModItems.MYSTERIOUS_AXE);
                        entries.add(ModItems.MYSTERIOUS_SHOVEL);
                        entries.add(ModItems.MYSTERIOUS_HOE);
                        entries.add(ModItems.MYSTERIOUS_CHISEL);
                        entries.add(ModItems.MYSTERIOUS_REMOVER);


                    })
                    .build());


    public static final ItemGroup MYSTERIOUS_ARMOR = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MysteriousMod.MOD_ID, "mysterious_armor"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MYSTERIOUS_HELMET))
                    .displayName(Text.literal("Mysterious Armor"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.MYSTERIOUS_HELMET);
                        entries.add(ModItems.MYSTERIOUS_CHESTPLATE);
                        entries.add(ModItems.MYSTERIOUS_BOOTS);
                        entries.add(ModItems.MYSTERIOUS_LEGGINGS);

                    })
                    .build());


    public static void registerModItemGroups(){
        MysteriousMod.LOGGER.info("Registering Item Groups for " + MysteriousMod.MOD_ID);
    }

}
