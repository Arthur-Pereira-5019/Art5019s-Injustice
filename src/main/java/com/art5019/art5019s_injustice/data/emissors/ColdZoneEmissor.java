package com.art5019.art5019s_injustice.data.emissors;

import com.art5019.art5019s_injustice.data.RangedEmissor;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import com.art5019.art5019s_injustice.powers.helper.FreezingHelper;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;
import java.util.UUID;

public class ColdZoneEmissor extends Emissor implements RangedEmissor {
    private int radius;
    public static final MapCodec<ColdZoneEmissor> COLD_ZONE = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.LONG.fieldOf("expiryTick").forGetter(ColdZoneEmissor::getExpiryTick),
                    Codec.DOUBLE.fieldOf("posX").forGetter(ColdZoneEmissor::getPosX),
                    Codec.DOUBLE.fieldOf("posY").forGetter(ColdZoneEmissor::getPosY),
                    Codec.DOUBLE.fieldOf("posZ").forGetter(ColdZoneEmissor::getPosZ),
                    Codec.STRING.fieldOf("uuid").forGetter(ColdZoneEmissor::getUuid),
                    Codec.INT.fieldOf("radius").forGetter(ColdZoneEmissor::getRadius)
            ).apply(instance, ColdZoneEmissor::new)
    );

    public static final StreamCodec<FriendlyByteBuf, ColdZoneEmissor> COLD_ZONE_STREAM = StreamCodec.composite(
            ByteBufCodecs.LONG,
            ColdZoneEmissor::getExpiryTick,
            ByteBufCodecs.DOUBLE,
            ColdZoneEmissor::getPosX,
            ByteBufCodecs.DOUBLE,
            ColdZoneEmissor::getPosY,
            ByteBufCodecs.DOUBLE,
            ColdZoneEmissor::getPosZ,
            ByteBufCodecs.STRING_UTF8,
            ColdZoneEmissor::getUuid,
            ByteBufCodecs.INT,
            ColdZoneEmissor::getRadius,
            ColdZoneEmissor::new
    );

    public ColdZoneEmissor(long expiryTick, double posX, double posY, double posZ, String uuid, int radius) {
        super(expiryTick, posX, posY, posZ, uuid);
        this.radius = radius;
    }
    public ColdZoneEmissor(long expiryTick, double posX, double posY, double posZ, int radius) {
        super(expiryTick, posX, posY, posZ, UUID.randomUUID().toString());
        this.radius = radius;

    }

    @Override
    public MapCodec<? extends Emissor> type() {
        return COLD_ZONE;
    }

    @Override
    public StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor> streamCodec() {
        return COLD_ZONE_STREAM;
    }

    @Override
    public void evolve(int factor, ServerLevel serverLevel) {
        radius += (radius/4)*factor;
        this.setExpiryTick(getExpiryTick() + 300L *factor);

    }

    @Override
    public void devolve(int factor, ServerLevel serverLevel) {
        radius -= (radius/4)*factor;
    }

    @Override
    public void handle(ServerLevel serverLevel) {
        float r = serverLevel.getRandom().nextFloat();
        if(r < 0.1) {
            BlockPos toFreeze = GeoHelper.randomCoordinates(radius, radius ,this.getBlockPos());
            FreezingHelper.freezeBlock(serverLevel, toFreeze);
            List<Entity> entities = GeoHelper.getEntitiesAt(this.getBlockPos(), radius, serverLevel);
            for (Entity entity : entities) {
                if(entity instanceof LivingEntity livingEntity) {
                    if(livingEntity.isInWater()) {
                        livingEntity.setTicksFrozen(livingEntity.getTicksFrozen() + 20);
                    }
                    livingEntity.extinguishFire();
                }

            }
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
