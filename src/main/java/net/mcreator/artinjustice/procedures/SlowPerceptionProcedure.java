package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class SlowPerceptionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("originalspeedx", (entity.getDeltaMovement().x()));
		entity.getPersistentData().putDouble("originalspeedy", (entity.getDeltaMovement().y()));
		entity.getPersistentData().putDouble("originalspeedz", (entity.getDeltaMovement().z()));
		entity.setDeltaMovement(new Vec3(0, 0, 0));
	}
}
