package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class PistolItemItemInHandTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("cadency") >= 1) {
			itemstack.getOrCreateTag().putDouble("cadency", (itemstack.getOrCreateTag().getDouble("cadency") - 1));
		}
	}
}
