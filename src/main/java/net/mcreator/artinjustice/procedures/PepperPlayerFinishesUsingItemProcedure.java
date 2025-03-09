package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class PepperPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(2);
	}
}
