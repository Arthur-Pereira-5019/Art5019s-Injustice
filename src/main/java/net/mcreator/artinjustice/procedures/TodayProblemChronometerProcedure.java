package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class TodayProblemChronometerProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + ("00:" + new java.text.DecimalFormat("##").format(((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4cooldown - 17600) / 20));
	}
}
