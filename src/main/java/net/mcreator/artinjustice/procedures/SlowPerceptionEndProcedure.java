package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class SlowPerceptionEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("originalspeedx")), (entity.getPersistentData().getDouble("originalspeedy")), (entity.getPersistentData().getDouble("originalspeedz"))));
	}
}
