package net.antnz.mysteriousmod.item;

import net.antnz.mysteriousmod.MysteriousMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {


    public static final RegistryEntry<ArmorMaterial> MYSTERIOUS_ARMOR_MATERIALS = registryEntry("mysterious",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 2);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 4);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 6);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 2);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY, 8);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, ()-> Ingredient.ofItems(ModItems.MYSTERIOUS_ITEM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MysteriousMod.MOD_ID, "mysterious"))),0,0));


    private static RegistryEntry<ArmorMaterial> registryEntry(String name, Supplier<ArmorMaterial> materialSupplier){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(MysteriousMod.MOD_ID, name), materialSupplier.get());
    }


}
