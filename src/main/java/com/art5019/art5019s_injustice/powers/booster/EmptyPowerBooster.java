package com.art5019.art5019s_injustice.powers.booster;

import net.minecraft.server.level.ServerPlayer;

public class EmptyPowerBooster implements PowerTypeBooster{

    @Override
    public int cooldownReducer(ServerPlayer serverPlayer) {
        return 0;
    }
}
