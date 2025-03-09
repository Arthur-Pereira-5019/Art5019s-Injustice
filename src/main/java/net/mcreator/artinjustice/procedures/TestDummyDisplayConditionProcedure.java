package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class TestDummyDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("amogus") == 1) {
			return true;
		}
		return false;
	}
}
