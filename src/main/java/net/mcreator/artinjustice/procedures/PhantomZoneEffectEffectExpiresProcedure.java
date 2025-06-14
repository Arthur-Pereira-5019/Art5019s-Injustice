package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class PhantomZoneEffectEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		NoGravityManagerProcedure.execute(entity);
	}
}
