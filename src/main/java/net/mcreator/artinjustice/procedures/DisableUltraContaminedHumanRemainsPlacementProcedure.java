package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class DisableUltraContaminedHumanRemainsPlacementProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("disease") > 6 && itemstack.getItem() == Art5019injusticeModItems.CONTAMINED_HUMAN_REMAINS.get()) {
			return true;
		}
		return false;
	}
}
