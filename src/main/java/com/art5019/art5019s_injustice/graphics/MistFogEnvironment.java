package com.art5019.art5019s_injustice.graphics;

import com.art5019.art5019s_injustice.effects.Effects;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.MobEffectFogEnvironment;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

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
