package com.art5019.art5019s_injustice.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.attachment.AttachmentType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.ATTACHMENT_TYPES;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
public class DataAttachments {
    public static final Codec<PlayerSkill> SKILL_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("skillId").forGetter(PlayerSkill::skillId),
                    Codec.INT.fieldOf("xp").forGetter(PlayerSkill::xp)
            ).apply(instance, PlayerSkill::new)
    );

    public static final Codec<List<PlayerSkill>> SKILLS = SKILL_CODEC.listOf();

    public static final Supplier<AttachmentType<List<PlayerSkill>>> SKILL = ATTACHMENT_TYPES.register(
            "skills", () -> AttachmentType.builder((Supplier<List<PlayerSkill>>) ArrayList::new).
                    serialize(SKILLS.fieldOf("skills")).copyOnDeath().build()
    );

    public static final Supplier<AttachmentType<Integer>> ALIGNMENT = ATTACHMENT_TYPES.register(
            "alignment", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("alignment")).build()
    );

    public static final Supplier<AttachmentType<Integer>> POWER_ID = ATTACHMENT_TYPES.register(
            "power_id", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("power_id")).build()
    );

    public static final Supplier<AttachmentType<Integer>> STRESS = ATTACHMENT_TYPES.register(
            "stress", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT.fieldOf("stress")).build()
    );

    public static final Supplier<AttachmentType<Long>> LAST_QUERY = ATTACHMENT_TYPES.register(
            "last_query", () -> AttachmentType.builder(() -> 0L).serialize(Codec.LONG.fieldOf("last_query")).build()
    );

}