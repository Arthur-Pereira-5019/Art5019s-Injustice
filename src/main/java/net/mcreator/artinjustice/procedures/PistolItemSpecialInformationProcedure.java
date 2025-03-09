package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

public class PistolItemSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		String upgrade = "";
		if ((itemstack.getOrCreateTag().getString("upgrade")).equals("silencer")) {
			upgrade = "Silencer";
		} else {
			upgrade = "None";
		}
		return "Requires a Pistol Magazine 0.75s Cadency Upgrade:" + upgrade;
	}
}
