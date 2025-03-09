
package net.mcreator.artinjustice.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.procedures.EntityCollideWithContaminedWaterProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModFluids;

public class ContaminedWaterBlock extends LiquidBlock {
	public ContaminedWaterBlock() {
		super(() -> Art5019injusticeModFluids.CONTAMINED_WATER.get(),
				BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		EntityCollideWithContaminedWaterProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
