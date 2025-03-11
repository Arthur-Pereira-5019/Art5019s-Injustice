package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class AttributeAdderProcedure {
	public static void execute(Entity entity, double context, String amount, String name, String operation, String uuid) {
		if (entity == null || amount == null || name == null || operation == null || uuid == null)
			return;
		if (context == 1) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("attribute @s minecraft:generic.max_health modifier add " + uuid + " " + name + " " + amount + " " + operation));
				}
			}
		}
	}
}
