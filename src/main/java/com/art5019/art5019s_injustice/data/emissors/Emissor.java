package com.art5019.art5019s_injustice.data.emissors;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class Emissor {
    private long expiryTick;
    private double posX;
    private double posY;
    private double posZ;

    public static final Codec<Emissor> INDIVIDUAL_EMISSOR_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.LONG.fieldOf("expiryTick").forGetter(e -> e.expiryTick),
            Codec.FLOAT.listOf().fieldOf("parameters").forGetter(Emissor::getParameters),
            Codec.DOUBLE.fieldOf("x").forGetter(e -> e.posX),
            Codec.DOUBLE.fieldOf("y").forGetter(e -> e.posY),
            Codec.DOUBLE.fieldOf("z").forGetter(e -> e.posX)
    ).apply(instance, Emissor::new));

    public Emissor(long expiryTick, List<Float> parameters, double posX, double posY, double posZ) {
        this.unpackParameters(parameters);
        this.expiryTick = expiryTick;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    public long getExpiryTick() {
        return expiryTick;
    }

    public List<Float> getParameters() {
        return new ArrayList<>();
    }

    public void unpackParameters(List<Float> parameters) {

    }

    public static List<Float> packParameters(float... parameters) {
        ArrayList<Float> result = new ArrayList<>();
        for (float parameter : parameters) {
            result.add(parameter);
        }
        return result;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public BlockPos getBlockPos() {
        return new BlockPos((int) posX, (int) posY, (int) posZ);
    }

    public Vec3 getVec3() {
        return new Vec3(posX, posY, posZ);
    }

    public void handle(ServerLevel serverLevel) {

    }
}
