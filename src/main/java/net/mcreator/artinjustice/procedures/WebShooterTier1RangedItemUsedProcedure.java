package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class WebShooterTier1RangedItemUsedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("webFluid", (itemstack.getOrCreateTag().getDouble("webFluid") - 1));
	}
}
