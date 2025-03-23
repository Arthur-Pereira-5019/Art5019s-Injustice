package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class PlaysoundManagerProcedure {
	public static void execute(Entity entity, String pitch, String sound, String type, String volume) {
		if (entity == null || pitch == null || sound == null || type == null || volume == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound " + sound + " " + type + " @s ~ ~ ~ " + volume + " " + pitch));
			}
		}
	}
}
