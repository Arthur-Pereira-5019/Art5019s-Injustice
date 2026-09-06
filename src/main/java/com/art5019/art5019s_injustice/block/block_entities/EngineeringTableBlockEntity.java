package com.art5019.art5019s_injustice.block.block_entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import static com.art5019.art5019s_injustice.block.block_entities.BlockEntities.ENGINEERING_TABLE_BLOCK_ENTITY;

public class EngineeringTableBlockEntity extends BlockEntity {

    public EngineeringTableBlockEntity(BlockPos pos, BlockState state) {
        super(ENGINEERING_TABLE_BLOCK_ENTITY.get(), pos, state);
    }
}
