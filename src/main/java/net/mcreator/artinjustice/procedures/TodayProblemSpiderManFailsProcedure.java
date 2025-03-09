package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class TodayProblemSpiderManFailsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double probs = 0;
		String base = "";
		base = "<" + entity.getDisplayName().getString();
		if (Math.random() < 0.5) {
			if (Math.random() < 0.5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((base + "> Wait, what?")), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((base + "> But, but... I never miss!")), false);
			}
		} else {
			if (Math.random() < 0.5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((base + "> How I messed such a trivial question?")), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((base + "> Maybe It's time to read my old math books again...")), false);
			}
		}
	}
}
