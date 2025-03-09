package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class IfVenomIsOnFireProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getRemainingFireTicks() >= 1) {
			return true;
		}
		return false;
	}
}
