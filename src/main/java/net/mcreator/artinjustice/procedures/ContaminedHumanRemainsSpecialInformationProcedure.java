package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class ContaminedHumanRemainsSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		return "Infectivity Tier: " + itemstack.getOrCreateTag().getDouble("disease");
	}
}
