package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.List;
import java.util.Comparator;

public class GenericColdBreathProcedure {
	public static void execute(LevelAccessor world, Entity entity, double power) {
		if (entity == null)
			return;
		double Scaling = 0;
		double lx = 0;
		double ly = 0;
		double lz = 0;
		double times = 0;
		double powerscale = 0;
		for (int index0 = 0; index0 < (int) (power * 6); index0++) {
			lx = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(powerscale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
			ly = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(powerscale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			lz = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(powerscale)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
			if (!world.getBlockState(BlockPos.containing(lx, ly, lz)).canOcclude()) {
				powerscale = powerscale + 1;
			} else {
				break;
			}
			Scaling = powerscale / 3;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SNOWFLAKE, lx, ly, lz, (int) (1 * Scaling), (0.4 * Scaling), (0.4 * Scaling), (0.4 * Scaling), 0.3);
			GenericBlockFreezingProcedure.execute(world, lx, ly, lz, Scaling);
			{
				final Vec3 _center = new Vec3(lx, ly, lz);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(Scaling / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						entityiterator.setTicksFrozen((int) (5 + entityiterator.getTicksFrozen()));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
											.withSuppressedOutput(),
									("fill ~" + entityiterator.getBbWidth() + " ~" + entityiterator.getBbHeight() + " ~" + entityiterator.getBbWidth() + " ~-" + entityiterator.getBbWidth() + " ~ " + "~-" + entityiterator.getBbWidth()
											+ " art5019injustice:thin_ice replace #forge:any_air"));
					}
				}
			}
		}
	}
}
