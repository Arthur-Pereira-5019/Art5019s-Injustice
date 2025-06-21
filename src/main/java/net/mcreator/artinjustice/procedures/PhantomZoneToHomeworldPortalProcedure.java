package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;
import java.util.Comparator;

public class PhantomZoneToHomeworldPortalProcedure {
	public static void execute(LevelAccessor world, double newX, double newY, double newZ, double openX, double openY, double openZ) {
		double offset = 0;
		PhantomZoneVisualPortalProcedure.execute(world, openX, openY, openZ);
		{
			final Vec3 _center = new Vec3(openX, openY, openZ);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				{
					Entity _ent = entityiterator;
					_ent.teleportTo((newX + 5), (newY + 5), newZ);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((newX + 5), (newY + 5), newZ, _ent.getYRot(), _ent.getXRot());
				}
				DimensionSwitcherProcedure.execute(entityiterator, "minecraft:overworld");
			}
		}
	}
}
