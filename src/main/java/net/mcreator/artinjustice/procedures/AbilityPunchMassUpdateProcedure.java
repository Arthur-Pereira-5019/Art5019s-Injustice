package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class AbilityPunchMassUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed;
			entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.masspunch = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
