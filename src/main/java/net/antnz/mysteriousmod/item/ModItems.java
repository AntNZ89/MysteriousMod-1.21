package net.antnz.mysteriousmod.item;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.item.custom.*;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200),1).nutrition(5).saturationModifier(4f).build();

    public static final Item MYSTERIOUS_MUTTON = registerItem("mysterious_mutton", new Item(new Item.Settings().food(FOOD_COMPONENT).rarity(Rarity.RARE)));

    public static final Item MYSTERIOUS_COAL = registerItem("mysterious_coal", new Item(new Item.Settings().rarity(Rarity.RARE)));

    public static final Item MYSTERIOUS_ITEM = registerItem("mysterious_item", new Item(new Item.Settings()));

    public static final Item MYSTERIOUS_SWORD = registerItem("mysterious_sword",
            new SwordItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 6, -2))
                    .rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_PICKAXE = registerItem("mysterious_pickaxe",
            new MysteriousPickaxeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -2))
                    .rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_AXE = registerItem("mysterious_axe",
            new MysteriousAxeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 7, -3f))
                    .rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_SHOVEL = registerItem("mysterious_shovel",
            new MysteriousShovelItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -2))
                    .rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_HOE = registerItem("mysterious_hoe",
            new HoeItem(ModToolMaterials.MYSTERIOUS, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MYSTERIOUS, 2, -1))
                    .rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_REMOVER = registerItem("mysterious_remover",
            new RemoverItem(new Item.Settings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_CHISEL = registerItem("mysterious_chisel",
            new ChiselItem(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)));

    public static final Item MYSTERIOUS_BOOTS = registerItem("mysterious_boots",
            new MysteriousArmorItem(ModArmorMaterials.MYSTERIOUS_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))
                    .rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_LEGGINGS = registerItem("mysterious_leggings",
            new MysteriousArmorItem(ModArmorMaterials.MYSTERIOUS_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxCount(ArmorItem.Type.LEGGINGS.getMaxDamage(15))
                    .rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_CHESTPLATE = registerItem("mysterious_chestplate",
            new MysteriousArmorItem(ModArmorMaterials.MYSTERIOUS_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))
                    .rarity(Rarity.EPIC)));

    public static final Item MYSTERIOUS_HELMET = registerItem("mysterious_helmet",
            new ArmorItem(ModArmorMaterials.MYSTERIOUS_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))
                    .rarity(Rarity.EPIC)));




    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MysteriousMod.MOD_ID, name), item);
    }


    public static void registerFuel(){
        FuelRegistry.INSTANCE.add(ModItems.MYSTERIOUS_COAL, 400);
    }


    public static void registerModItems(){
        MysteriousMod.LOGGER.info("Registering Items for " + MysteriousMod.MOD_ID);
    }


}
