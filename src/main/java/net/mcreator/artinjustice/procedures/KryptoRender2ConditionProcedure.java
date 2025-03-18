package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class KryptoRender2ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!KryptoSittingProcedure.execute(entity) && IfKryptoHasCollarProcedure.execute(entity)) {
			return true;
		}
		return false;
	}
}
