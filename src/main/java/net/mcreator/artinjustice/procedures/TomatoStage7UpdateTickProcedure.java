package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

import java.util.Map;

public class TomatoStage7UpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= 6) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
					&& !(world.getBlockState(BlockPos.containing(x, y - 4, z))).is(BlockTags.create(new ResourceLocation("art5019injustice:tomatoes")))) {
				{
					BlockPos _bp = BlockPos.containing(x, y + 1, z);
					BlockState _bs = Art5019injusticeModBlocks.TOMATO_STAGE_1.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.TOMATO_STAGE_FINAL.get().defaultBlockState(), 3);
		}
	}
}
