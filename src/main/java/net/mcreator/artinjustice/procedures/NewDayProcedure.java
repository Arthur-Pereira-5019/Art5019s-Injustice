package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

import java.util.ArrayList;

public class NewDayProcedure {
	public static void execute(LevelAccessor world) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			entityiterator.getPersistentData().putDouble("ranToday", 1);
		}
		if (Art5019injusticeModVariables.MapVariables.get(world).today_news == 38) {
			Art5019injusticeModVariables.MapVariables.get(world).today_news = 39;
			Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
		} else if (Art5019injusticeModVariables.MapVariables.get(world).today_news == 30) {
			Art5019injusticeModVariables.MapVariables.get(world).today_news = 31;
			Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
		} else if (Art5019injusticeModVariables.MapVariables.get(world).today_news == 32) {
			Art5019injusticeModVariables.MapVariables.get(world).today_news = 33;
			Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
