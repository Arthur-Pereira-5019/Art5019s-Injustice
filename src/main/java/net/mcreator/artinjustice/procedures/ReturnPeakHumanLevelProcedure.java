package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class ReturnPeakHumanLevelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A7aLevel: " + new java.text.DecimalFormat("\u00A7a##").format((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl)
				+ "\u00A7a/10";
	}
}
