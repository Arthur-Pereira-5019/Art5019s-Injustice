package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class VinesSuperFertilizerEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			sy = -1;
			for (int index1 = 0; index1 < 3; index1++) {
				sz = -1;
				for (int index2 = 0; index2 < 3; index2++) {
					if (3 > world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getDestroySpeed(world, BlockPos.containing(x + sx, y + sy, z + sz))) {
						{
							BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + sx, y + sy, z + sz), null);
							world.destroyBlock(_pos, false);
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		sx = -2;
		for (int index3 = 0; index3 < 4; index3++) {
			sy = -2;
			for (int index4 = 0; index4 < 4; index4++) {
				sz = -2;
				for (int index5 = 0; index5 < 4; index5++) {
					if (1.5 > world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getDestroySpeed(world, BlockPos.containing(x + sx, y + sy, z + sz))) {
						{
							BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + sx, y + sy, z + sz), null);
							world.destroyBlock(_pos, false);
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		sx = -3;
		for (int index6 = 0; index6 < 6; index6++) {
			sy = -3;
			for (int index7 = 0; index7 < 6; index7++) {
				sz = -3;
				for (int index8 = 0; index8 < 6; index8++) {
					if (0.5 > world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getDestroySpeed(world, BlockPos.containing(x + sx, y + sy, z + sz))) {
						{
							BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + sx, y + sy, z + sz), null);
							world.destroyBlock(_pos, false);
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		Art5019injusticeMod.queueServerWork(5, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~3 ~3 ~3 ~-3 ~-3 ~-3 vine[north=true] replace #forge:any_air");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~3 ~3 ~3 ~-3 ~-3 ~-3 vine[east=true] replace #forge:any_air");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~3 ~3 ~3 ~-3 ~-3 ~-3 vine[up=true] replace #forge:any_air");
		});
	}
}
