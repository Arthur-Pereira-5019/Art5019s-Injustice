package com.art5019.art5019s_injustice.block;

import com.art5019.art5019s_injustice.block.block_entities.EngineeringTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class EngineeringTable extends Block implements EntityBlock {
    public EngineeringTable(BlockBehaviour.Properties x) {
        super(x);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new EngineeringTableBlockEntity(blockPos, blockState);
    }
}
