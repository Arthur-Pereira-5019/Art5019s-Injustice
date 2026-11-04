package com.art5019.art5019s_injustice.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public record PlayerScrollsPacket(int deltaY) implements CustomPacketPayload {

    public static final Type<PlayerScrollsPacket> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(MODID, "player_scrolls"));

    public static final StreamCodec<ByteBuf, PlayerScrollsPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            PlayerScrollsPacket::deltaY,
            PlayerScrollsPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
