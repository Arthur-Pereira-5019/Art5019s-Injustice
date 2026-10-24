package com.art5019.art5019s_injustice.data.emissors.mist;

import com.art5019.art5019s_injustice.effects.Effects;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.client.renderer.fog.environment.MobEffectFogEnvironment;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FogType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import org.joml.Vector4f;
import org.jspecify.annotations.Nullable;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.DataAttachments.GRAPHICS_STACK;
import static com.art5019.art5019s_injustice.data.DataAttachments.SUPERPOWER_ID;

public class MistFogEnvironment extends MobEffectFogEnvironment {
    @Override
    public void setupFog(FogData fogData, Camera camera, ClientLevel clientLevel, float v, DeltaTracker deltaTracker) {
        Entity var7 = camera.entity();
        if (var7 instanceof LivingEntity) {
            float distance = 16;
            fogData.environmentalStart = distance * 0.5F;
            fogData.environmentalEnd = distance;
            fogData.skyEnd = distance * 0.8F;
            fogData.cloudEnd = distance * 0.8F;
        }
    }

    @Override
    public Holder<MobEffect> getMobEffect() {
        return Effects.MIST_EFFECT;
    }
}
