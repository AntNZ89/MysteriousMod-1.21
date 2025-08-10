package net.antnz.mysteriousmod.component;

import net.antnz.mysteriousmod.MysteriousMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {





    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(MysteriousMod.MOD_ID, name),
                builderUnaryOperator.apply(ComponentType.builder()).build());
    }


    public static void registerDataComponentTypes(){
        MysteriousMod.LOGGER.info("Registering Data Component Types for " + MysteriousMod.MOD_ID);
    }





}
