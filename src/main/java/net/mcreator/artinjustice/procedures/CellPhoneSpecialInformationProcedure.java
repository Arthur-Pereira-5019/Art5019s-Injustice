package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class CellPhoneSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		String contact = "";
		if ((itemstack.getOrCreateTag().getString("contact")).equals("HelpCenter")) {
			contact = "+49 (0) 30-23125 000 (War Assisting Center)";
		} else if ((itemstack.getOrCreateTag().getString("contact")).equals("BigHelpCenter")) {
			contact = "+49 (0) 30-23125 001 (Main War Assisting Center)";
		}
		return "Set to call: " + contact;
	}
}
