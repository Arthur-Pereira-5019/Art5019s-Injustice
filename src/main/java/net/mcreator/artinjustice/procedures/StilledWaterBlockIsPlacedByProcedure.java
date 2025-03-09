package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class StilledWaterBlockIsPlacedByProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Art5019injusticeMod.queueServerWork(10, () -> {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.WATER.defaultBlockState(), 3);
		});
	}
}
