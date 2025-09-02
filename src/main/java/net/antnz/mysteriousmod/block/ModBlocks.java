package net.antnz.mysteriousmod.block;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.block.custom.LampBlock;
import net.antnz.mysteriousmod.block.custom.MysteriousBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks{

    public static final Block MYSTERIOUS_BLOCK = registerBlock("mysterious_block", new MysteriousBlock(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_SWORD_BLOCK = registerBlock("mysterious_sword_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_AXE_BLOCK = registerBlock("mysterious_axe_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_PICKAXE_BLOCK = registerBlock("mysterious_pickaxe_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_SHOVEL_BLOCK = registerBlock("mysterious_shovel_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_HOE_BLOCK = registerBlock("mysterious_hoe_block", new Block(AbstractBlock.Settings.create().requiresTool()));

    public static final Block MYSTERIOUS_LAMP_BLOCK = registerBlock("mysterious_lamp_block",
            new LampBlock(AbstractBlock.Settings.create().luminance(state-> state.get(LampBlock.CLICKED)?15:0)));

    public static final Block MYSTERIOUS_SLAB = registerBlock("mysterious_slab", new SlabBlock(AbstractBlock.Settings.create()));

    public static final Block MYSTERIOUS_STAIRS = registerBlock("mysterious_stairs", new StairsBlock(ModBlocks.MYSTERIOUS_BLOCK.getDefaultState(), AbstractBlock.Settings.create()));

    public static final Block PRESSURE_PLATE = registerBlock("mysterious_pressure_plate", new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()));

    public static final Block MYSTERIOUS_FENCE = registerBlock("mysterious_fence", new FenceBlock(AbstractBlock.Settings.create()));

    public static final Block MYSTERIOUS_FENCE_GATE = registerBlock("mysterious_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create()));

    public static final Block MYSTERIOUS_WALL = registerBlock("mysterious_wall", new WallBlock(AbstractBlock.Settings.create().requiresTool().nonOpaque()));

    public static final Block MYSTERIOUS_BUTTON = registerBlock("mysterious_button", new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.create()));



    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor", new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().nonOpaque()));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door", new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().nonOpaque()));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MysteriousMod.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(MysteriousMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks(){
        MysteriousMod.LOGGER.info("Registering Blocks for " + MysteriousMod.MOD_ID);
    }

}
