package net.antnz.mysteriousmod;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.component.ModDataComponentTypes;
import net.antnz.mysteriousmod.item.ModItemGroups;
import net.antnz.mysteriousmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

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
		ModDataComponentTypes.registerDataComponentTypes();
		ModItems.registerFuel();






	}
}