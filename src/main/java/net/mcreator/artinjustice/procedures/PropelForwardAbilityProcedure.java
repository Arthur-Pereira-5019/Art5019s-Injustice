package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class PropelForwardAbilityProcedure {
	public static void execute(Entity entity, double speed) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(((-1) * Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * speed), ((-1) * Math.sin(Math.toRadians(entity.getXRot())) * speed),
				(Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * speed)));
	}
}
