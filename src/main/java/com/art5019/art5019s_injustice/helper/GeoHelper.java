package com.art5019.art5019s_injustice.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static net.minecraft.core.particles.ParticleTypes.CLOUD;

public class GeoHelper {
    public static List<Entity> getEntitiesAt(BlockPos at, double radius, ServerLevel serverLevel) {
        return serverLevel.getEntitiesOfClass(Entity.class, generateAABB(at, radius), x -> true);
    }

    public static AABB generateAABB(BlockPos blockPos, double r) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        return new AABB(x-r, y-r, z-r, x+r, y+r, z+r);
    }

    public static double distanceBetweenPos(BlockPos a, BlockPos b) {
        double ax = a.getX();
        double bx = b.getX();

        double ay = a.getY();
        double by = b.getY();

        double az = a.getZ();
        double bz = b.getZ();

        double podx = Math.pow(bx-ax,2);
        double pody = Math.pow(by-ay,2);
        double podz = Math.pow(bz-az,2);

        return Math.sqrt(podx+pody+podz);
    }

    public static double horizontalDistance(BlockPos a, BlockPos b) {
        double ax = a.getX();
        double bx = b.getX();
        double az = a.getZ();
        double bz = b.getZ();

        double podx = Math.pow(bx-ax,2);
        double podz = Math.pow(bz-az,2);

        return Math.sqrt(podx+podz);
    }

    public static double dx(BlockPos a, BlockPos b) {
        double ax = a.getX();
        double bx = b.getX();

        return ax-bx;
    }

    public static double dz(BlockPos a, BlockPos b) {
        double az = a.getZ();
        double bz = b.getZ();

        return az-bz;
    }

    public static Vec3 rayCastTillHit(int distance, float precision, Entity entity, ServerLevel serverLevel) {
        double scaling = 0;
        int iterations = (int) Math.ceil(distance/precision);
        for(int i = 0; i < iterations; i++) {
            BlockHitResult result = serverLevel.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity));
            BlockPos resultPos = result.getBlockPos();
            double x = resultPos.getX();
            double y = resultPos.getY();
            double z = resultPos.getZ();
            if(serverLevel.getBlockState(new BlockPos((int) x, (int) y, (int) z)).isSolidRender()) {
                return new Vec3(x, y, z);
            } else {
                scaling+=precision;
            }
        }
        return null;
    }
}
