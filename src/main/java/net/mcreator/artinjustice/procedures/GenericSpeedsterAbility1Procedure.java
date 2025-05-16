package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class GenericSpeedsterAbility1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown()) {
			if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 8) {
				if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed < (entity
						.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).maxSpeed) {
					{
						double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed + 1;
						entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.currentSpeed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					AbilitySpeedsterUpdateProcedure.execute(world, x, y, z, entity);
				}
			}
		} else {
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed > 0) {
				{
					double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed - 1;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.currentSpeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				AbilitySpeedsterUpdateProcedure.execute(world, x, y, z, entity);
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 8) {
			QuicksilverTryToLevelUpProcedure.execute(world, x, y, z, entity);
		}
	}
}
