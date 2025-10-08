package net.antnz.mysteriousmod.effect;

import net.antnz.mysteriousmod.MysteriousMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {


    public static final RegistryEntry<StatusEffect> CATAPULT = registerSoundEffect("high_gravity",
            new HighGravityEffect(StatusEffectCategory.NEUTRAL, 0x35abeb)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(MysteriousMod.MOD_ID, "high_gravity"), 0.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerSoundEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MysteriousMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        MysteriousMod.LOGGER.info("Registering Effects for " + MysteriousMod.MOD_ID);
    }

}
