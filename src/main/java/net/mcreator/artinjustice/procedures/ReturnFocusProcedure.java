package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class ReturnFocusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Focus Cooldown: " + new java.text.DecimalFormat("##").format((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).suitability1cooldown / 20)
				+ "s";
	}
}
