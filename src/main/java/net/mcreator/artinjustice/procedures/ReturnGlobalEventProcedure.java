package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class ReturnGlobalEventProcedure {
	public static String execute(LevelAccessor world) {
		String eventname = "";
		if (Art5019injusticeModVariables.MapVariables.get(world).event_id == 0) {
			eventname = "None";
		} else if (Art5019injusticeModVariables.MapVariables.get(world).event_id == 1) {
			eventname = "Earth X Invasion";
		} else if (Art5019injusticeModVariables.MapVariables.get(world).event_id == 2) {
			eventname = "Rise of the Inner Demons";
		}
		return "Current Event: " + eventname + ", Percentage: " + Art5019injusticeModVariables.MapVariables.get(world).event_meter * 100 + "%";
	}
}
