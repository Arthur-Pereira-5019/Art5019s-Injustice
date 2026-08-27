package com.art5019.art5019s_injustice.data.item;

import com.art5019.art5019s_injustice.data.Skill;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.DATA_COMPONENTS;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
public class ItemDataComponents {
    public static final Codec<Skill> SKILL_COMPONENT_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("skillId").forGetter(Skill::skillId),
                    Codec.INT.fieldOf("level").forGetter(Skill::level)
            ).apply(instance, Skill::new)
    );


    public static final Supplier<DataComponentType<Skill>> SKILL_COMPONENT = DATA_COMPONENTS.registerComponentType(
            "skill_component",
            builder -> builder
                    .persistent(SKILL_COMPONENT_CODEC)
    );
}
