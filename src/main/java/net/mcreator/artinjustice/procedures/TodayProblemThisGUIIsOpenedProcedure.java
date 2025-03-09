package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class TodayProblemThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean safe = false;
		{
			double _setval = Mth.nextInt(RandomSource.create(), -100, 100);
			entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.tp_n2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Mth.nextInt(RandomSource.create(), 1, 4);
			entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.tp_idop = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Mth.nextInt(RandomSource.create(), -999, 999);
			entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.tp_res = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).tp_idop == 3) {
			while (!safe) {
				{
					double _setval = Mth.nextInt(RandomSource.create(), -999, 999);
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.tp_res = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).tp_res
						% (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).tp_n2 == 0) {
					safe = true;
				}
			}
		}
	}
}
