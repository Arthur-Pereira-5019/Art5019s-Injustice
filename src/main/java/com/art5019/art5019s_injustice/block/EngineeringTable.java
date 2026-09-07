package com.art5019.art5019s_injustice.block;

import com.art5019.art5019s_injustice.block.block_entities.EngineeringTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class EngineeringTable extends Block implements EntityBlock {
    private static final VoxelShape SHAPE = Shapes.or(Block.box(0,14,0,16,16,16), Shapes.rotateHorizontal(Block.box(0,0,0,1,14,1)).values().stream().reduce(Shapes.empty(), Shapes::or));

    public EngineeringTable(BlockBehaviour.Properties x) {
        super(x);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new EngineeringTableBlockEntity(blockPos, blockState);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;

    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

}
