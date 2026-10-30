package com.art5019.art5019s_injustice.data.emissors;

import com.art5019.art5019s_injustice.network.packets.SkillGainXpPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;

import java.util.UUID;
import java.util.stream.Stream;

public class ColdZoneEmissor extends Emissor{
    public static final MapCodec<ColdZoneEmissor> COLD_ZONE = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.LONG.fieldOf("expiryTick").forGetter(ColdZoneEmissor::getExpiryTick),
                    Codec.DOUBLE.fieldOf("posX").forGetter(ColdZoneEmissor::getPosX),
                    Codec.DOUBLE.fieldOf("posY").forGetter(ColdZoneEmissor::getPosY),
                    Codec.DOUBLE.fieldOf("posZ").forGetter(ColdZoneEmissor::getPosZ),
                    Codec.STRING.fieldOf("uuid").forGetter(ColdZoneEmissor::getUuid)
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
            ColdZoneEmissor::new
    );

    public ColdZoneEmissor(long expiryTick, double posX, double posY, double posZ, String uuid) {
        super(expiryTick, posX, posY, posZ, uuid);
    }public ColdZoneEmissor(long expiryTick, double posX, double posY, double posZ) {
        super(expiryTick, posX, posY, posZ, UUID.randomUUID().toString());
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
    public void handle(ServerLevel serverLevel) {

    }
}
