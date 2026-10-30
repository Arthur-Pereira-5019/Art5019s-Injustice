package com.art5019.art5019s_injustice.mixin;

import com.art5019.art5019s_injustice.data.emissors.ColdZoneEmissor;
import com.art5019.art5019s_injustice.helper.EmissorHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public class BiomeMixin {
    @Inject(method = "shouldSnow", at = @At("HEAD"), cancellable = true)
    private static void shouldSnow(LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if(level instanceof ServerLevel serverLevel) {
            if(EmissorHelper.containsEmissorAt(serverLevel, pos, 16, ColdZoneEmissor.class)) {
                if (level.isInsideBuildHeight(pos.getY()) && level.getBrightness(LightLayer.BLOCK, pos) < 10) {
                    BlockState state = level.getBlockState(pos);
                    if ((state.isAir() || state.is(Blocks.SNOW)) && Blocks.SNOW.defaultBlockState().canSurvive(level, pos)) {
                        cir.setReturnValue(true);
                    }
                }
            }
        }
    }

}
