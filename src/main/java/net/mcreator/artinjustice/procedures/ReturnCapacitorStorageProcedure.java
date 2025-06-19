package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class ReturnCapacitorStorageProcedure {
	public static String execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("rf") + "/" + ReturnCapacitorCapacityProcedure.execute(itemstack) + " RF";
	}
}
