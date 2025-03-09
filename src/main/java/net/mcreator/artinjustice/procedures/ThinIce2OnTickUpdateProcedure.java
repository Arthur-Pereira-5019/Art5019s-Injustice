package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

public class ThinIce2OnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= 10) {
			world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.THIN_ICE_3.get().defaultBlockState(), 3);
		}
	}
}
