package com.art5019.art5019s_injustice.mixin;

import com.art5019.art5019s_injustice.graphics.MistFogEnvironment;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(FogRenderer.class)
public class FogRendererMixin {
    @Final
    @Shadow
    @Mutable
    public static List<FogEnvironment> FOG_ENVIRONMENTS;

    @Inject(method = "<init>()V", at = @At("HEAD"))
    private static void FogRenderer(CallbackInfo ci) {
        FOG_ENVIRONMENTS.add(0,new MistFogEnvironment());
    }
}
