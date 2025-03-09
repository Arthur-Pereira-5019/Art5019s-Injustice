package net.mcreator.artinjustice.procedures;

import org.checkerframework.checker.units.qual.cd;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class AbilityTeleportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double cd, double ctxt, double distance) {
		if (entity == null)
			return;
		boolean canskip = false;
		double dy = 0;
		double newx = 0;
		double newy = 0;
		double newz = 0;
		newx = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
		newy = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
		newz = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
		while (!canskip) {
			if (dy >= -20) {
				if (world.getBlockState(BlockPos.containing(newx, newy + dy, newz)).canOcclude()) {
					{
						Entity _ent = entity;
						_ent.teleportTo(newx, (newy + dy + 1), newz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(newx, (newy + dy + 1), newz, _ent.getYRot(), _ent.getXRot());
					}
					canskip = true;
					if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 4) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 200, 1, 1, 1, 1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, newx, newy, newz, 200, 1, 1, 1, 1);
					} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 8) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FLASH, x, y, z, 200, 1, 1, 1, 1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FLASH, newx, newy, newz, 200, 1, 1, 1, 1);
					}
					GenericCooldownManagerProcedure.execute(entity, cd, ctxt);
				}
			} else {
				canskip = true;
			}
			dy = dy - 1;
		}
	}
}
