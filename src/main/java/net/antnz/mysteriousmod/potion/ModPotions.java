package net.antnz.mysteriousmod.potion;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final RegistryEntry<Potion> HIGH_GRAVITY_POTION = registerPotion("high_gravity_potion",
            new Potion(new StatusEffectInstance(ModEffects.HIGH_GRAVITY, 1200, 1)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion){
        return Registry.registerReference(Registries.POTION, Identifier.of(MysteriousMod.MOD_ID, name), potion);
    }


    public static void registerPotions(){
        MysteriousMod.LOGGER.info("Registering Potions for " + MysteriousMod.MOD_ID);
    }

}
