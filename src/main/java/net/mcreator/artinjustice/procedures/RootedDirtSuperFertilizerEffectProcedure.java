package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class RootedDirtSuperFertilizerEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double d = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				RootedDirtSuperFertilizerEffectRootsProcedure.execute(world, x, y, z, entity);
				Art5019injusticeMod.queueServerWork(4, () -> {
					if (((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).targetid).equals(entityiterator.getStringUUID())) {
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y() + 1.3), (entityiterator.getDeltaMovement().z())));
						if (!world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 4, entityiterator.getZ())).canOcclude()
								&& !world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 3, entityiterator.getZ())).canOcclude()) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 3), (entityiterator.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 3), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
							}
						}
					}
				});
			}
		}
	}
}
