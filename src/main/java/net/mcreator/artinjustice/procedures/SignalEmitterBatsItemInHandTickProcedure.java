package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.Comparator;

public class SignalEmitterBatsItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(18 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Bat) {
					if (entityiterator instanceof Mob _entity)
						_entity.getNavigation().moveTo(x, y, z, 1.4);
				}
			}
		}
	}
}
