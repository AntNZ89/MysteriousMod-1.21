package net.antnz.mysteriousmod.util;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.component.ModDataComponentTypes;
import net.antnz.mysteriousmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;

public class ModModelPredicates {

    public static void registerModelPredicates(){
        ModelPredicateProviderRegistry.register(ModItems.MYSTERIOUS_CHISEL, Identifier.of(MysteriousMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null? 1f : 0f);
    }

}
