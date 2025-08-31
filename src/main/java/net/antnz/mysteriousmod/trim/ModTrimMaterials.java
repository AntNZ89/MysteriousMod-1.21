package net.antnz.mysteriousmod.trim;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {


    public static final RegistryKey<ArmorTrimMaterial> MYSTERIOUS = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(MysteriousMod.MOD_ID, "mysterious"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable){
        register(registerable, MYSTERIOUS, Registries.ITEM.getEntry(ModItems.MYSTERIOUS_ITEM),
                Style.EMPTY.withColor(TextColor.parse("#b03fe0").getOrThrow()), 0.9f);
    }


    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimMaterialRegistryKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex){

        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimMaterialRegistryKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimMaterialRegistryKey.getValue())).fillStyle(style));

        registerable.register(armorTrimMaterialRegistryKey, trimMaterial);


    }

}
