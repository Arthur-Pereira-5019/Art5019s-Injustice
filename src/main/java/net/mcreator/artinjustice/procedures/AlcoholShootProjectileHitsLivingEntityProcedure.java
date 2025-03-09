package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class AlcoholShootProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getRemainingFireTicks() > 0) {
			entity.setSecondsOnFire((int) (240 + entity.getRemainingFireTicks()));
		}
		AlcoholShootProjectileHitBlockProcedure.execute(world, x, y, z);
	}
}
