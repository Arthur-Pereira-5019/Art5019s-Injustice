package com.art5019.art5019s_injustice.mixin;

import com.art5019.art5019s_injustice.data.emissors.ColdZoneEmissor;
import com.art5019.art5019s_injustice.helper.EmissorHelper;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.WeatherEffectRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WeatherEffectRenderer.class)
public class WeatherEffectRendererMixin {

    @ModifyExpressionValue(
            method = "extractRenderState",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/multiplayer/ClientLevel;getPrecipitationAt(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/biome/Biome$Precipitation;"
            )
    )
    private Biome.Precipitation modifyPrecipitation(Biome.Precipitation original, @Local(argsOnly = true, name = "level") ClientLevel level, @Local(name = "x") int x, @Local(name = "z") int z, @Local(name = "cameraBlockY") int cameraBlockY) {
        if(EmissorHelper.containsEmissorAt(level, new BlockPos(x, cameraBlockY, z), 16, ColdZoneEmissor.class)) {
            return Biome.Precipitation.SNOW;
        }
        return original;
    }
}
