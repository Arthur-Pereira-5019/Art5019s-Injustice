package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class ReturnCapacitorCapacityProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getItem() == Art5019injusticeModItems.COPPER_CAPACITOR.get()) {
			return 6000;
		} else if (itemstack.getItem() == Art5019injusticeModItems.LITHIUM_COBALT_CAPACITOR.get()) {
			return 30000;
		} else if (itemstack.getItem() == Art5019injusticeModItems.GOLDEN_CAPACITOR.get()) {
			return 150000;
		} else if (itemstack.getItem() == Art5019injusticeModItems.ALIEN_CAPACITOR.get()) {
			return 750000;
		} else if (itemstack.getItem() == Art5019injusticeModItems.KRYPTONIAN_CAPACITOR.get()) {
			return 3750000;
		}
		return 0;
	}
}
