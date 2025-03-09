package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class DashingOnEffectActiveTickProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(((-1) * Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * (1.6 + amplifier * 1.6)), ((-1) * Math.sin(Math.toRadians(entity.getXRot())) * (1.6 + amplifier * 1.6)),
				(Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * (1.6 + amplifier * 1.6))));
	}
}
