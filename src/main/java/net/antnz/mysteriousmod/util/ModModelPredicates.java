package net.antnz.mysteriousmod.util;

import net.antnz.mysteriousmod.MysteriousMod;
import net.antnz.mysteriousmod.component.ModDataComponentTypes;
import net.antnz.mysteriousmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModModelPredicates {


    public static void registerModelPredicates(){
        ModelPredicateProviderRegistry.register(ModItems.MYSTERIOUS_CHISEL, Identifier.of(MysteriousMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null? 1f : 0f);

        registerCustomBow(ModItems.MYSTERIOUS_BOW);
    }


    private static void registerCustomBow(Item item){

        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);



    }


}
