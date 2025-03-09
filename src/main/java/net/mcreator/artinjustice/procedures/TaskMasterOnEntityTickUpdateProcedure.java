package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.TaskMasterEntity;

import java.util.List;
import java.util.Comparator;

public class TaskMasterOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.01) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Creeper || (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof TaskMasterEntity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Monster) {
							if (!(entityiterator instanceof Creeper)) {
								if (!(entityiterator instanceof TaskMasterEntity)) {
									if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
								}
							}
						}
					}
				}
			}
		}
	}
}
