package net.antnz.mysteriousmod.util;

import net.antnz.mysteriousmod.MysteriousMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {



    public static class Blocks{



        public static final TagKey<Block> INCORRECT_FOR_MYSTERIOUS_TOOL = register("incorrect_for_mysterious_tool");
        public static final TagKey<Block> NEEDS_MYSTERIOUS_TOOL = register("needs_mysterious_tool");


        private static TagKey<Block> register(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MysteriousMod.MOD_ID, name));
        }



    }





    public static class Items{



        public static final TagKey<Item> TRANSFORMABLE = register("transformable");



        private static TagKey<Item> register(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MysteriousMod.MOD_ID, name));
        }



    }






}
