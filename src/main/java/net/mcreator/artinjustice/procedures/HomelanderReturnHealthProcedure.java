package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class HomelanderReturnHealthProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		Entity target = null;
		double Scaling = 0;
		double boost = 0;
		for (int index0 = 0; index0 < 30; index0++) {
			target = (Entity) world
					.getEntitiesOfClass(LivingEntity.class,
							AABB.ofSize(new Vec3((entity.getX() + entity.getLookAngle().x * Scaling), (entity.getY() + 1.65 + entity.getLookAngle().y * Scaling), (entity.getZ() + entity.getLookAngle().z * Scaling)), 2, 2, 2), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX() + entity.getLookAngle().x * Scaling), (entity.getY() + 1.65 + entity.getLookAngle().y * Scaling), (entity.getZ() + entity.getLookAngle().z * Scaling))).findFirst().orElse(null);
			if (target == null || target == entity) {
				Scaling = Scaling + 1;
			} else {
				return "Health: " + (target instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
			}
		}
		return "";
	}
}
