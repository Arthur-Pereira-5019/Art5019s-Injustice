package com.art5019.art5019s_injustice.effects;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MOB_EFFECTS;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
public class Effects {
    public static final DeferredHolder<MobEffect, Mist> MIST_EFFECT = MOB_EFFECTS.register("mist", () -> new Mist(
            MobEffectCategory.NEUTRAL,
            0xffffff
    ));
}
