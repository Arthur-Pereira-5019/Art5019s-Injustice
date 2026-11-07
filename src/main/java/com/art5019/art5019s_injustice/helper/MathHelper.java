package com.art5019.art5019s_injustice.helper;

import net.minecraft.world.phys.Vec2;

public class MathHelper {
    public static Vec2 normalizedVectorSum(Vec2 a, Vec2 b) {
        Vec2 c = a.add(b);
        return normalizeVector(c);
    }

    public static Vec2 normalizeVector(Vec2 a) {
        float l = vectorLength(a);
        return new Vec2(a.x / l, a.y / l);
    }

    public static float vectorLength(Vec2 a) {
        return (float) Math.pow(a.x*a.x + a.y*a.y,2);
    }
}
