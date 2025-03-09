package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class WebbedActiveEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!(world.getBlockState(BlockPos.containing(0.4 + x, y, z))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
				|| !(world.getBlockState(BlockPos.containing(x - 0.4, y, z))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
				|| !(world.getBlockState(BlockPos.containing(x, y - 0.4, z))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
				|| !(world.getBlockState(BlockPos.containing(x, y, z + 0.4))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
				|| !(world.getBlockState(BlockPos.containing(x, y, z - 0.4))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
				|| !(world.getBlockState(BlockPos.containing(x, y + 0.4, z))).is(BlockTags.create(new ResourceLocation("forge:any_air")))) {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle minecraft:block cobweb ~ ~ ~ 0.5 0.5 0.5 1 2");
		}
	}
}
