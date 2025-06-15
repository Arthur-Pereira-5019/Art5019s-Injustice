package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

public class ReturnItemRadiationPointsProcedure {
	public static double execute(ItemStack itemstack) {
		double dose = 0;
		if (itemstack.getItem() == Art5019injusticeModItems.ENRICHED_URANIUM.get() || itemstack.getItem() == Art5019injusticeModItems.ENRICHED_SHOVEL.get()) {
			dose = 2.16;
		} else if (itemstack.getItem() == Items.NETHER_STAR) {
			dose = 0.01;
		} else if (itemstack.getItem() == Art5019injusticeModBlocks.URANIUM_BLOCK.get().asItem()) {
			dose = 0.24;
		} else if (itemstack.getItem() == Art5019injusticeModItems.ACTIVATED_DWARF_STAR.get()) {
			dose = 1;
		} else if (itemstack.getItem() == Art5019injusticeModItems.ENRICHED_SWORD.get() || itemstack.getItem() == Art5019injusticeModItems.ENRICHED_HOE.get()) {
			dose = 4.32;
		} else if (itemstack.getItem() == Art5019injusticeModItems.ENRICHED_AXE.get() || itemstack.getItem() == Art5019injusticeModItems.ENRICHED_PICKAXE.get()) {
			dose = 6.48;
		}
		return dose;
	}
}
