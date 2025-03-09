package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class StormfrontCantFlyProcedure {
	public static boolean execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return false;
		if (world.isEmptyBlock(BlockPos.containing(x, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - 1, z))
				&& world.isEmptyBlock(BlockPos.containing(x, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(), z)) && entity.getDeltaMovement().y() >= 0) {
			return false;
		}
		return true;
	}
}
