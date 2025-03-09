package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class CaptainCarterShieldThrownProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
	}
}
