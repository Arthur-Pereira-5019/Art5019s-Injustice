package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class TempLightBlockBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Art5019injusticeMod.queueServerWork(5, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.TEMP_LIGHT_BLOCK.get()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		});
	}
}
