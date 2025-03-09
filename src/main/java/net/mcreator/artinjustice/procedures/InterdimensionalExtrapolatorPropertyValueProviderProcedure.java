package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class InterdimensionalExtrapolatorPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("leadsto")).equals("Random Earth") || (itemstack.getOrCreateTag().getString("leadsto")).equals("")) {
			return 0;
		}
		return 1;
	}
}
