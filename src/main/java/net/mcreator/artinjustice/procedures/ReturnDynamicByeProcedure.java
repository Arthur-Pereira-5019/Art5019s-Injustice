package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

public class ReturnDynamicByeProcedure {
	public static String execute(LevelAccessor world) {
		if (world.dayTime() % 24000 >= 0 && world.dayTime() % 24000 < 8000) {
			return "Have a good day.";
		} else if (world.dayTime() % 24000 >= 8000 && world.dayTime() % 24000 < 16000) {
			return "Have a good afternoon.";
		} else if (world.dayTime() % 24000 >= 16000 && world.dayTime() % 24000 <= 24000) {
			return "Have a good night.";
		}
		return "Have a good day.";
	}
}
