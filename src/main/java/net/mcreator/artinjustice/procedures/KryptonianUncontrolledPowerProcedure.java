package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class KryptonianUncontrolledPowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl == 1) {
			UncontrolledSenseSoundServiceProcedure.execute(world, x, y, z, entity);
			{
				double _setval = 800;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.uncontrolledpowercooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl == 3) {
			HeatVisionLaserProcedure.execute(world, x, y, z, entity, 1);
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).uncontrolledpoweractivated - 1;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.uncontrolledpoweractivated = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).uncontrolledpoweractivated <= 0) {
				{
					double _setval = 9600;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.uncontrolledpowercooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 400;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.uncontrolledpoweractivated = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
