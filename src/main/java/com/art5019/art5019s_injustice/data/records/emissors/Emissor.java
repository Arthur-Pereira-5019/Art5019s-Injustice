package com.art5019.art5019s_injustice.data.records.emissors;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

public class Emissor {
    int emissorEffectId;
    long expiryTick;
    double posX;
    double posY;
    double posZ;
    List<Float> parameters;

    public static final Codec<Emissor> INDIVIDUAL_EMISSOR_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("emissorEffectId").forGetter(e -> e.emissorEffectId),
            Codec.LONG.fieldOf("expiryTick").forGetter(e -> e.expiryTick),
            Codec.FLOAT.listOf().fieldOf("parameters").forGetter(e -> e.parameters),
            Codec.DOUBLE.fieldOf("x").forGetter(e -> e.posX),
            Codec.DOUBLE.fieldOf("y").forGetter(e -> e.posY),
            Codec.DOUBLE.fieldOf("z").forGetter(e -> e.posX)
    ).apply(instance, Emissor::new));

    public Emissor(int emissorEffectId, long expiryTick, List<Float> parameters, double posX, double posY, double posZ) {
        this.emissorEffectId = emissorEffectId;
        this.expiryTick = expiryTick;
        this.parameters = parameters;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    public int getEmissorEffectId() {
        return emissorEffectId;
    }

    public long getExpiryTick() {
        return expiryTick;
    }

    public List<Float> getParameters() {
        return parameters;
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
}
