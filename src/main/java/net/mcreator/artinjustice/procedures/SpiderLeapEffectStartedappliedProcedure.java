package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class SpiderLeapEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		double probs = 0;
		entity.setDeltaMovement(new Vec3((0.6 * Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), (1 * Mth.nextDouble(RandomSource.create(), 0.5, 0.65)), (0.6 * Mth.nextDouble(RandomSource.create(), -0.7, 0.7))));
	}
}
