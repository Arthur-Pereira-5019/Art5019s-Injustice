package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class WebShooterTier1m2ProjectileHitsBlockProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		entity.setDeltaMovement(new Vec3(1, 1, 1));
		immediatesourceentity.setDeltaMovement(new Vec3((-1), (-1), (-1)));
	}
}
