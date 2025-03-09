package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

public class PricklyPathOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -2;
		for (int index0 = 0; index0 < 4; index0++) {
			sy = -2;
			for (int index1 = 0; index1 < 4; index1++) {
				sz = -2;
				for (int index2 = 0; index2 < 4; index2++) {
					if (Art5019injusticeModBlocks.PRICKLY_PATH.get().defaultBlockState().canSurvive(world, BlockPos.containing(x + sx, y + sy, z + sz))) {
						if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))) {
							if (Math.random() < 0.7) {
								world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Art5019injusticeModBlocks.PRICKLY_PATH.get().defaultBlockState(), 3);
							}
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
