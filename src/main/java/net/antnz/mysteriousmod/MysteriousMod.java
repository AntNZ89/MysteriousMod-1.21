package net.antnz.mysteriousmod;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.component.ModDataComponentTypes;
import net.antnz.mysteriousmod.item.ModItemGroups;
import net.antnz.mysteriousmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysteriousMod implements ModInitializer {
	public static final String MOD_ID = "mysteriousmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModDataComponentTypes.registerModDataComponentTypes();
		ModItems.registerFuel();


		UseEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
			if (entity instanceof MobEntity mob && world instanceof ServerWorld){
				if (playerEntity.getMainHandStack().getItem() == ModItems.MYSTERIOUS_CHISEL){
					mob.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20));
					mob.setHealth(0f);

					if (isVow(mob.getName().getString().charAt(0))){
						playerEntity.sendMessage(Text.literal("-You made an " + mob.getName().getString() + " disappear!-"));
					}
					else {
						playerEntity.sendMessage(Text.literal("-You made a " + mob.getName().getString() + " disappear!-"));
					}

				}
				return ActionResult.PASS;
			}
			return ActionResult.SUCCESS;
		});

	}


	private static boolean isVow(char c){
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}


}