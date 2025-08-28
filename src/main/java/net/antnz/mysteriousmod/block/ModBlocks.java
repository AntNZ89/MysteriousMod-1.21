package net.antnz.mysteriousmod.block;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.block.custom.LampBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks{

    public static final Block MYSTERIOUS_BLOCK = registerBlock("mysterious_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_SWORD_BLOCK = registerBlock("mysterious_sword_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_AXE_BLOCK = registerBlock("mysterious_axe_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_PICKAXE_BLOCK = registerBlock("mysterious_pickaxe_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_SHOVEL_BLOCK = registerBlock("mysterious_shovel_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_HOE_BLOCK = registerBlock("mysterious_hoe_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_LAMP_BLOCK = registerBlock("mysterious_lamp_block",
            new LampBlock(AbstractBlock.Settings.create().luminance(state-> state.get(LampBlock.CLICKED)?15:0)));

    public static final Block MYSTERIOUS_SLAB = registerBlock("mysterious_slab", new SlabBlock(AbstractBlock.Settings.create().requiresTool()));




    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MysteriousMod.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(MysteriousMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        MysteriousMod.LOGGER.info("Registering Blocks for " + MysteriousMod.MOD_ID);
    }

}
