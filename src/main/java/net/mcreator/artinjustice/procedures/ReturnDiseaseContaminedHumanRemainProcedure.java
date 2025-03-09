package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class ReturnDiseaseContaminedHumanRemainProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("disease") == 1) {
			return "\u00A73Influenza Virus";
		} else if (itemstack.getOrCreateTag().getDouble("disease") == 2) {
			return "\u00A73Human Immunodeficiency Virus";
		}
		return " ";
	}
}
