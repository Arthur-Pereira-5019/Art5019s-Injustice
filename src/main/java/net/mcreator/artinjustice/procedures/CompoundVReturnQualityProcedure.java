package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class CompoundVReturnQualityProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("quality") == 0) {
			return "Compound V: \\n" + "Quality: Good";
		} else if (itemstack.getOrCreateTag().getDouble("quality") == 1) {
			return "Compound V: \\n" + "Quality: Average";
		} else if (itemstack.getOrCreateTag().getDouble("quality") == 2) {
			return "Compound V: \\n" + "Quality: Bad";
		}
		return "Compound V: \\n" + "Quality: Good";
	}
}
