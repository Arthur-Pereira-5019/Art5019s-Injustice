package com.art5019.art5019s_injustice.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class GeoHelper {
    public static List<LivingEntity> getEntitiesAt(BlockPos at, float radius, ServerLevel serverLevel) {
        return serverLevel.getEntitiesOfClass(LivingEntity.class, generateAABB(at, radius), x -> true);
    }

    public static AABB generateAABB(BlockPos blockPos, float r) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        return new AABB(x-r, y-r, z-r, x+r, y+r, z+r);
    }
}
