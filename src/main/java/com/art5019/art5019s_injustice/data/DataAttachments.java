package com.art5019.art5019s_injustice.data;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import com.art5019.art5019s_injustice.data.emissors.EmissorSyncHandler;
import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.art5019.art5019s_injustice.data.records.skill.PlayerSkill;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.attachment.AttachmentType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.ATTACHMENT_TYPES;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.registries.Registries.*;

@Mod(MODID)
public class DataAttachments {

    public static final Codec<PlayerSkill> SKILL_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("skillId").forGetter(PlayerSkill::skillId),
                    Codec.INT.fieldOf("xp").forGetter(PlayerSkill::xp)
            ).apply(instance, PlayerSkill::new)
    );


    public static final Codec<ClientPower> CLIENT_POWER_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("superpowerId").forGetter(ClientPower::superpowerId),
                    Codec.INT.fieldOf("powerId").forGetter(ClientPower::powerId),
                    Codec.INT.fieldOf("cooldown").forGetter(ClientPower::cooldown),
                    Codec.INT.fieldOf("secondaryCooldown").forGetter(ClientPower::secondaryCooldown)
            ).apply(instance, ClientPower::new)
    );

    public static final Codec<Emissor> EMISSOR_CODEC =
            EMISSOR_REGISTRY.byNameCodec()
                    .dispatch(
                            Emissor::type,
                            Function.identity()
                    );

    public static final StreamCodec<RegistryFriendlyByteBuf, Emissor> EMISSOR_STREAM_CODEC =
            ByteBufCodecs.registry(EMISSOR_STREAM_REGISTRY_KEY).dispatch(
                    Emissor::streamCodec,
                    Function.identity()
            );

    public static final StreamCodec<RegistryFriendlyByteBuf, List<Emissor>> EMISSOR_STREAM_CODEC_LIST = EMISSOR_STREAM_CODEC.apply(ByteBufCodecs.list());





    public static final Codec<List<PlayerSkill>> SKILLS = SKILL_CODEC.listOf();
    public static final Codec<List<ClientPower>> CLIENT_POWERS = CLIENT_POWER_CODEC.listOf();
    public static final Codec<List<Emissor>> EMISSORS = EMISSOR_CODEC.listOf();

    public static final Supplier<AttachmentType<List<ClientPower>>> CLIENT_POWER = ATTACHMENT_TYPES.register(
            "client_power", () -> AttachmentType.builder((Supplier<List<ClientPower>>) ArrayList::new).
                    serialize(CLIENT_POWERS.fieldOf("client_power")).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<List<PlayerSkill>>> SKILL = ATTACHMENT_TYPES.register(
            "skills", () -> AttachmentType.builder((Supplier<List<PlayerSkill>>) ArrayList::new).
                    serialize(SKILLS.fieldOf("skills")).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<List<Emissor>>> EMISSORS_ATTACHMENT = ATTACHMENT_TYPES.register(
            "emissors", () -> AttachmentType.builder((Supplier<List<Emissor>>) ArrayList::new)
                    .sync(EMISSOR_STREAM_CODEC_LIST)
                    .serialize(EMISSORS.fieldOf("emissors")).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<Integer>> ALIGNMENT = ATTACHMENT_TYPES.register(
            "alignment", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("alignment"))
                    .copyOnDeath()
                    .build()
    );

    public static final Supplier<AttachmentType<Integer>> SUPERPOWER_ID = ATTACHMENT_TYPES.register(
            "power_id", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("superpower_id"))
                    .copyOnDeath()
                    .build()
    );

    public static final Supplier<AttachmentType<Integer>> STRESS = ATTACHMENT_TYPES.register(
            "stress", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("stress"))
                    .copyOnDeath()
                    .build()
    );

    public static final Supplier<AttachmentType<Long>> LAST_QUERY = ATTACHMENT_TYPES.register(
            "last_query", () -> AttachmentType.builder(() -> 0L).serialize(Codec.LONG.fieldOf("last_query"))
                    .copyOnDeath()
                    .build()
    );

    public static final Supplier<AttachmentType<Integer>> GRAPHICS_STACK = ATTACHMENT_TYPES.register(
            "graphics_stack", () -> AttachmentType.builder(() -> 1).serialize(Codec.INT.fieldOf("graphics_stack"))
                    .copyOnDeath()
                    .build()
    );

    public static final Supplier<AttachmentType<Integer>> POWER_LIST_POS = ATTACHMENT_TYPES.register(
            "power_list_pos", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("power_list_pos"))
                    .copyOnDeath()
                    .build()
    );

}