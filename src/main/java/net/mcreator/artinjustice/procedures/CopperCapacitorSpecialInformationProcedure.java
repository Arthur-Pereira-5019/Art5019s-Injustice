package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class CopperCapacitorSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("rf") + "/6000 RF";
	}
}
