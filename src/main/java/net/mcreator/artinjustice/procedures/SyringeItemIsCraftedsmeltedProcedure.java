package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class SyringeItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("fluidid", "Empty");
	}
}
