package com.art5019.art5019s_injustice.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public record SkillLevelUpPacket(String skillName, int skillLevel) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<SkillLevelUpPacket> TYPE = new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath(MODID, "skill_level_up"));

    public static final StreamCodec<ByteBuf, SkillLevelUpPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            SkillLevelUpPacket::skillName,
            ByteBufCodecs.VAR_INT,
            SkillLevelUpPacket::skillLevel,
            SkillLevelUpPacket::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
