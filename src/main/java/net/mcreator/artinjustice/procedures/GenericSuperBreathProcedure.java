package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class GenericSuperBreathProcedure {
	public static void execute(LevelAccessor world, Entity entity, double power) {
		if (entity == null)
			return;
		double Scaling = 0;
		double lx = 0;
		double ly = 0;
		double lz = 0;
		double times = 0;
		for (int index0 = 0; index0 < (int) (power * 12); index0++) {
			lx = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
			ly = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			lz = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
			if (!world.getBlockState(BlockPos.containing(lx, ly, lz)).canOcclude()) {
				Scaling = Scaling + 1;
			} else {
				break;
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CLOUD, lx, ly, lz, (int) (1 * Scaling), (0.4 * Scaling), (0.4 * Scaling), (0.4 * Scaling), 0.5);
			{
				final Vec3 _center = new Vec3(lx, ly, lz);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((0.4 * Scaling) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						entityiterator.setDeltaMovement(new Vec3(((-1) * Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * (3 / Scaling)), ((-1) * Math.sin(Math.toRadians(entity.getXRot())) * (3 / Scaling)),
								(Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * (3 / Scaling))));
					}
				}
			}
		}
	}
}
