package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class Ability4OnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23 && entity instanceof LivingEntity _livEnt0
				&& _livEnt0.hasEffect(Art5019injusticeModMobEffects.RAGE.get()))) {
			{
				boolean _setval = false;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability4holding = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
