package net.antnz.mysteriousmod.item;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
                    .displayName(Text.translatable("itemgorup.mysteriousmod.mysterious_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.MYSTERIOUS_ITEM);
                        entries.add(ModItems.MYSTERIOUS_SWORD);
                        entries.add(ModItems.MYSTERIOUS_PICKAXE);
                        entries.add(ModItems.MYSTERIOUS_AXE);
                        entries.add(ModItems.MYSTERIOUS_SHOVEL);
                        entries.add(ModItems.MYSTERIOUS_HOE);
                        entries.add(ModItems.MYSTERIOUS_CHISEL);

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

                    })
                    .build());



    public static void registerModItemGroups(){
        MysteriousMod.LOGGER.info("Registering Item Groups for " + MysteriousMod.MOD_ID);
    }

}
