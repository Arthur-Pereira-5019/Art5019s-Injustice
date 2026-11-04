package com.art5019.art5019s_injustice.powers.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.lang3.function.TriConsumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.Math.min;
import static net.minecraft.tags.BlockTags.REPLACEABLE;
import static net.minecraft.world.level.block.Blocks.*;
import static net.minecraft.world.level.block.SnowLayerBlock.LAYERS;

public class FreezingHelper {
    public static Map<Block, TriConsumer<BlockState, ServerLevel, BlockPos>> freezeMap;
    public static Map<TagKey<Block>, TriConsumer<BlockState, ServerLevel, BlockPos>> freezeTagMap;

    public static void freezeBlock(ServerLevel serverLevel, BlockPos blockPos) {
        BlockState blockState = serverLevel.getBlockState(blockPos);
        TriConsumer<BlockState, ServerLevel, BlockPos> triConsumer = freezeMap.get(blockState.getBlock());
        if(triConsumer == null) {
            Stream<TagKey<Block>> tags = blockState.tags();
            List<TagKey<Block>> tagKeyList = tags.toList();
            for (TagKey<Block> blockTagKey : tagKeyList) {
                if(freezeTagMap.containsKey(blockTagKey)) {
                    triConsumer = freezeTagMap.get(blockTagKey);
                    break;
                }
            }
        }
        if(triConsumer != null) {
            triConsumer.accept(blockState, serverLevel, blockPos);
        }
    }

    static {
        freezeMap = new HashMap<>();
        freezeMap.put(WATER, (x, y, z) -> y.setBlock(z, ICE.defaultBlockState(), Block.UPDATE_ALL));
        freezeMap.put(FIRE, (x, y, z) -> y.setBlock(z, AIR.defaultBlockState(), Block.UPDATE_ALL));
        freezeMap.put(LAVA, (x, y, z) -> y.setBlock(z, STONE.defaultBlockState(), Block.UPDATE_ALL));
        freezeMap.put(MAGMA_BLOCK, (x, y, z) -> y.setBlock(z, COBBLESTONE.defaultBlockState(), Block.UPDATE_ALL));
        freezeMap.put(SOUL_FIRE, (x, y, z) -> y.setBlock(z, AIR.defaultBlockState(), Block.UPDATE_ALL));
        freezeMap.put(SNOW, (x, y, z) -> x.setValue(LAYERS, min(x.getValue(LAYERS)+1,8)));

        freezeTagMap = new HashMap<>();
        freezeTagMap.put(REPLACEABLE, (x,y,z) -> y.setBlock(z, AIR.defaultBlockState(), Block.UPDATE_ALL));


    }
}
