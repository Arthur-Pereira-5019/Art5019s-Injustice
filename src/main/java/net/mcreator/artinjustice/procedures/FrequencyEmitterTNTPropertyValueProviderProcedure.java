package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class FrequencyEmitterTNTPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getBoolean("tnttracking")) {
			return 1;
		}
		return 0;
	}
}
