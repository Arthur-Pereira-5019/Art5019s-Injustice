
package net.mcreator.artinjustice.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.procedures.RedBlockBlockAddedProcedure;

public class RedBlockBlock extends Block {
	public RedBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.HONEY_BLOCK).strength(1f, 10f).friction(0.7f).speedFactor(0.7f).jumpFactor(0.8f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		RedBlockBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity, itemstack);
	}
}
