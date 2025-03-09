package net.mcreator.artinjustice.procedures;

import org.checkerframework.checker.units.qual.cd;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class GenericCooldownManagerProcedure {
	public static void execute(Entity entity, double cd, double context) {
		if (entity == null)
			return;
		if (context == 1) {
			{
				double _setval = cd;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability1cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (context == 2) {
			{
				double _setval = cd;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability2cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (context == 3) {
			{
				double _setval = cd;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability3cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (context == 4) {
			{
				double _setval = cd;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability4cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (context == 5) {
			{
				double _setval = cd;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability5cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (context == 6) {
			{
				double _setval = cd;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability6cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (context == 7) {
			{
				double _setval = cd;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability7cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
