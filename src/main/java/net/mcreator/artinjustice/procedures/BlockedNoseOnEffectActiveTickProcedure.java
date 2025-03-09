package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class BlockedNoseOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isSprinting() || entity.isSwimming()) {
			if (entity.getAirSupply() >= -40) {
				entity.setAirSupply((int) (entity.getAirSupply() - 9));
			}
		}
	}
}
