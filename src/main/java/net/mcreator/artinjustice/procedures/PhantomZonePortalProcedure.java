package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;
import java.util.Comparator;

public class PhantomZonePortalProcedure {
	public static void execute(LevelAccessor world, double newX, double newY, double newZ, double openX, double openY, double openZ) {
		double offset = 0;
		PhantomZoneVisualPortalProcedure.execute(world, newX, newY, newZ);
		{
			final Vec3 _center = new Vec3(newX, newY, newZ);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				{
					Entity _ent = entityiterator;
					_ent.teleportTo((openX + 5), (openY + 5), openZ);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((openX + 5), (openY + 5), openZ, _ent.getYRot(), _ent.getXRot());
				}
				DimensionSwitcherProcedure.execute(entityiterator, "art5019injustice:phantom_zone");
			}
		}
	}
}
