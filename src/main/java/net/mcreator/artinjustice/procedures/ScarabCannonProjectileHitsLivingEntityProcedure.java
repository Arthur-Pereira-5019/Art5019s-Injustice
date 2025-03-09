package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class ScarabCannonProjectileHitsLivingEntityProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
