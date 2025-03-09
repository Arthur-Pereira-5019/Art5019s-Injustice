package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class ReturnTodayProblemOpProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String op = "";
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).tp_idop == 4) {
			op = "/";
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).tp_idop == 3) {
			op = "*";
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).tp_idop == 2) {
			op = "-";
		} else {
			op = "+";
		}
		return op;
	}
}
