package net.antnz.mysteriousmod.tags;

import net.antnz.mysteriousmod.MysteriousMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {



    public static class Blocks{







        private static TagKey<Block> register(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MysteriousMod.MOD_ID, name));
        }



    }





    public static class Items{







        private static TagKey<Item> register(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MysteriousMod.MOD_ID, name));
        }



    }






}
