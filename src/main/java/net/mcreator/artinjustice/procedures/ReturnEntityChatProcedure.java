package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnEntityChatProcedure {
	public static String execute(Entity entity, String message) {
		if (entity == null || message == null)
			return "";
		return "<" + entity.getDisplayName().getString() + "> " + message;
	}
}
