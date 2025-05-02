package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class ReturnQuicksilverMaxDistanceTravelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Max distance: " + (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).maxSpeed * 750 + "m";
	}
}
