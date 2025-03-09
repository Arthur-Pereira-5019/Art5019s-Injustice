package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class CondimentGunPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("sauce");
	}
}
