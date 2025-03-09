package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModGameRules;

public class TaskMasterEntityDiesProcedure {
	public static void execute(LevelAccessor world) {
		Art5019injusticeModVariables.MapVariables.get(world).criminality_rate = Art5019injusticeModVariables.MapVariables.get(world).criminality_rate
				+ ((world.getLevelData().getGameRules().getInt(Art5019injusticeModGameRules.CRIMINALITY_EVENT_CHANGE_PERCENTAGE)) / 100) * 0.00006;
		Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
	}
}
