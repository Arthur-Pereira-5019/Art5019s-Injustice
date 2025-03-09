package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class PistolItemPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("upgrade2")).equals("goldskin")) {
			return 1;
		}
		return 0;
	}
}
