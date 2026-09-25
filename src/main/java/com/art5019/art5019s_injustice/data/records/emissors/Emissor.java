package com.art5019.art5019s_injustice.data.records.emissors;

import net.minecraft.core.BlockPos;

import java.util.List;

public record Emissor(int emissorEffectId, long expiryTick, double posX, double posY, double posZ, List<Float> parameters) {
}
