package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class GenericBlockFreezingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double scale) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("fill ~" + scale + " ~" + scale + " ~" + scale + " ~-" + scale + " ~-" + scale + " ~-" + scale + " air replace #minecraft:fire"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("fill ~" + scale + " ~" + scale + " ~" + scale + " ~-" + scale + " ~-" + scale + " ~-" + scale + " frosted_ice replace water[level=0]"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("fill ~" + scale + " ~" + scale + " ~" + scale + " ~-" + scale + " ~-" + scale + " ~-" + scale + " art5019injustice:thin_ice replace water"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("fill ~" + scale + " ~" + scale + " ~" + scale + " ~-" + scale + " ~-" + scale + " ~-" + scale + " obsidian replace lava[level=0]"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("fill ~" + scale + " ~" + scale + " ~" + scale + " ~-" + scale + " ~-" + scale + " ~-" + scale + " stone replace lava"));
	}
}
