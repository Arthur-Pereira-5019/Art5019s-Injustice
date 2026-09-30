package com.art5019.art5019s_injustice.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public record PlayerUsesPowerPacket(int abilityNumber, boolean modified) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<PlayerUsesPowerPacket> TYPE =
            new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath(MODID, "player_uses_power"));

    public static final StreamCodec<ByteBuf, PlayerUsesPowerPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            PlayerUsesPowerPacket::abilityNumber,
            ByteBufCodecs.BOOL,
            PlayerUsesPowerPacket::modified,
            PlayerUsesPowerPacket::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
