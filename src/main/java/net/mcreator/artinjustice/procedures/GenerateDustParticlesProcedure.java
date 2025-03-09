package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class GenerateDustParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, String count, String dx, String dy, String dz, String particles, String speed) {
		if (count == null || dx == null || dy == null || dz == null || particles == null || speed == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("particle dust " + particles + " ~ ~ ~ " + dx + " " + dy + " " + dz + " " + speed + " " + count));
	}
}
