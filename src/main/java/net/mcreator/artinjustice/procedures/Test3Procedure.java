package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class Test3Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double speed = 0;
		double Yaw = 0;
		speed = 0.2;
		Yaw = entity.getYRot();
		speed = speed * Math.cos((Yaw + 90) * (Math.PI / 180));
		speed = speed * Math.sin((Yaw + 90) * (Math.PI / 180));
		entity.setDeltaMovement(new Vec3(speed, speed, speed));
		speed = entity.getYRot() + speed;
	}
}
