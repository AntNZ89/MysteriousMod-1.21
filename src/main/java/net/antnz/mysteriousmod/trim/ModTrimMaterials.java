package net.antnz.mysteriousmod.trim;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {

    public static final RegistryKey<ArmorTrimMaterial> MYSTERIOUS = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(MysteriousMod.MOD_ID, "mysterious"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable){
        register(registerable, MYSTERIOUS, Registries.ITEM.getEntry(ModItems.MYSTERIOUS_ITEM),
                Style.EMPTY.withColor(TextColor.parse("#FFFFFFF").getOrThrow()), 0.9f);
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> registryKey,
                                 RegistryEntry<Item> item, Style style, float index){

        ArmorTrimMaterial armorTrimMaterial = new ArmorTrimMaterial(registryKey.getValue().getPath(), item, index, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", registryKey.getValue())).fillStyle(style));

        registerable.register(registryKey, armorTrimMaterial);
    }

}
