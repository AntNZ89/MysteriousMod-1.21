package net.antnz.mysteriousmod.item;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.item.custom.Chiseltem;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    public static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200),1).build();

    public static final Item MYSTERIOUS_FOOD = registerItem("mysterious_food", new Item(new Item.Settings().food(FOOD_COMPONENT)));

    public static final Item MYSTERIOUS_FUEL = registerItem("mysterious_fool", new Item(new Item.Settings()));

    public static final Item MYSTERIOUS_ITEM = registerItem("mysterious_item", new Item(new Item.Settings()));

    public static final Item MYSTERIOUS_SWORD = registerItem("mysterious_sword",
            new SwordItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 10, -2))));

    public static final Item MYSTERIOUS_PICKAXE = registerItem("mysterious_pickaxe",
            new PickaxeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -2))));

    public static final Item MYSTERIOUS_AXE = registerItem("mysterious_axe",
            new AxeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 11, -2))));

    public static final Item MYSTERIOUS_SHOVEL = registerItem("mysterious_shovel",
            new ShovelItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -2))));

    public static final Item MYSTERIOUS_HOE = registerItem("mysterious_hoe",
            new HoeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -2))));

    public static final Item MYSTERIOUS_CHISEL = registerItem("mysterious_chisel", new Chiseltem(new Item.Settings().maxCount(1)));



    public static void registerFuel(){
        FuelRegistry.INSTANCE.add(ModItems.MYSTERIOUS_FUEL, 400);
    }



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MysteriousMod.MOD_ID, name), item);
    }



    public static void registerModItems(){
        MysteriousMod.LOGGER.info("Registering Items for " + MysteriousMod.MOD_ID);
    }


}
