package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class VineSuperFertilizerEffect2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -2;
		for (int index0 = 0; index0 < 4; index0++) {
			sy = 2;
			for (int index1 = 0; index1 < 4; index1++) {
				sz = -2;
				for (int index2 = 0; index2 < 4; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
						world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.VINE.defaultBlockState(), 3);
					}
					sz = sz + 1;
				}
				sy = sy - 1;
			}
			sx = sx + 1;
		}
	}
}
