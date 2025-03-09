package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModGameRules;

public class CriminalityRateChangeProcedure {
	public static void execute(LevelAccessor world, double pc) {
		Art5019injusticeModVariables.MapVariables.get(world).criminality_rate = Art5019injusticeModVariables.MapVariables.get(world).criminality_rate
				+ ((world.getLevelData().getGameRules().getInt(Art5019injusticeModGameRules.CRIMINALITY_EVENT_CHANGE_PERCENTAGE)) / 100) * pc;
		Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
	}
}
