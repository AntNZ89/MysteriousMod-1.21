package net.antnz.mysteriousmod.component;

import net.antnz.mysteriousmod.MysteriousMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {


    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", blockPosBuilder -> blockPosBuilder.codec(BlockPos.CODEC));


    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> unaryOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(MysteriousMod.MOD_ID, name),
                unaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerModDataComponentTypes(){
        MysteriousMod.LOGGER.info("Registering Mod Data Component Types for " + MysteriousMod.MOD_ID);
    }


}
