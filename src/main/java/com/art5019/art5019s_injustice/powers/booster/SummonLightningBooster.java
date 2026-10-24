package com.art5019.art5019s_injustice.powers.booster;

import net.minecraft.server.level.ServerPlayer;

public interface SummonLightningBooster extends PowerTypeBooster {
    public int radiusModifier(ServerPlayer serverPlayer);
    public int lightningPowerModifier(ServerPlayer serverPlayer);
}
