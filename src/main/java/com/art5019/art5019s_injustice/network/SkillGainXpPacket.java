package com.art5019.art5019s_injustice.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public record SkillGainXpPacket(int skillId, int skillXp) implements CustomPacketPayload {

    public static final Type<SkillGainXpPacket> TYPE = new Type<>(Identifier.fromNamespaceAndPath(MODID, "skill_gain_xp"));

    public static final StreamCodec<ByteBuf, SkillGainXpPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            SkillGainXpPacket::skillId,
            ByteBufCodecs.VAR_INT,
            SkillGainXpPacket::skillXp,
            SkillGainXpPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
