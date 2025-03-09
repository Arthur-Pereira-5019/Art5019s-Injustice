package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class InterdimensionalExtrapolatorSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		return "Leads to: " + itemstack.getOrCreateTag().getString("leadsto");
	}
}
