package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class PuzzleBlockOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (ReturnDectetivePowerProcedure.execute(entityiterator) > 0) {
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "type") == 0) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Art5019injusticeModParticleTypes.PUZZLE_BREAK_PARTICLE.get()), x, y, z, 20, 0.5, 0.5, 0.5, 0.1);
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "type") == 1) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Art5019injusticeModParticleTypes.PUZZLE_TURN_LEFT_PARTICLE.get()), x, y, z, 20, 0.5, 0.5, 0.5, 0.1);
					} else if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "type") == 2) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Art5019injusticeModParticleTypes.PUZZLE_TURN_LEFT_PARTICLE.get()), x, y, z, 20, 0.5, 0.5, 0.5, 0.1);
					}
				}
			}
		}
	}
}
