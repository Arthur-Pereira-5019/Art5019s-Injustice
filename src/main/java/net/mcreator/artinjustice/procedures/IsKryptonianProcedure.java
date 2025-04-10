package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.entity.KryptoTheSuperdogEntity;

public class IsKryptonianProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23 || entity instanceof KryptoTheSuperdogEntity) {
			return true;
		}
		return false;
	}
}
