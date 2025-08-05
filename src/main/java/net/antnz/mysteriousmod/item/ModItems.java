package net.antnz.mysteriousmod.item;

import net.antnz.mysteriousmod.MysteriousMod;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item MYSTERIOUS_ITEM = registerItem("mysterious_item", new Item(new Item.Settings()));

    public static final Item MYSTERIOUS_SWORD = registerItem("mysterious_sword",
            new SwordItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 10, -2))));

    public static final Item MYSTERIOUS_PICKAXE = registerItem("mysterious_pickaxe",
            new PickaxeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -2))));

    public static final Item MYSTERIOUS_AXE = registerItem("mysterious_axe",
            new AxeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 11, -4))));

    public static final Item MYSTERIOUS_SHOVEL = registerItem("mysterious_shovel",
            new ShovelItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -2))));

    public static final Item MYSTERIOUS_HOE = registerItem("mysterious_hoe",
            new HoeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -2))));










    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MysteriousMod.MOD_ID, name), item);
    }



    public static void registerModItems(){
        MysteriousMod.LOGGER.info("Registering Items for " + MysteriousMod.MOD_ID);
    }


}
