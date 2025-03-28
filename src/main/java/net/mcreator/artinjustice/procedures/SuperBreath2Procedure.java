package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.Comparator;

public class SuperBreath2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double power) {
		if (entity == null)
			return;
		double times = 0;
		times = power;
		for (int index0 = 0; index0 < (int) times; index0++) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						entityiterator.setDeltaMovement(new Vec3(((-1) * Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * 1.6), ((-1) * Math.sin(Math.toRadians(entity.getXRot())) * 1.6),
								(Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * 1.6)));
					}
				}
			}
		}
	}
}
