package com.art5019.art5019s_injustice.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.attribute.EnvironmentAttribute;
import net.minecraft.world.attribute.EnvironmentAttributeReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.attribute.EnvironmentAttributes.WATER_EVAPORATES;


@Mixin(EnvironmentAttributeReader.class)
public interface EnvironmentDataMixin {
    @Inject(method = "getValue(Lnet/minecraft/world/attribute/EnvironmentAttribute;Lnet/minecraft/core/BlockPos;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
    default <Value> void getValue(EnvironmentAttribute<Value> attribute, BlockPos pos, CallbackInfoReturnable<Value> cir) {
        if(attribute == WATER_EVAPORATES) {
            cir.setReturnValue((Value) Boolean.FALSE);
        }
    }
}