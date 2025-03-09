package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class NewspaperSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		return "Edition: (#" + itemstack.getOrCreateTag().getString("news") + ")";
	}
}
