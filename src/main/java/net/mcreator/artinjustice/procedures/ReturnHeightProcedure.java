package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnHeightProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Height: " + new java.text.DecimalFormat("##.#").format(entity.getY() - 62) + "m";
	}
}
