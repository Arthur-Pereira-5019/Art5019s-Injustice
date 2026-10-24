package com.art5019.art5019s_injustice.powers.superpower.mutant.storm;

import com.art5019.art5019s_injustice.powers.booster.SummonLightningBooster;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.loot.predicates.WeatherCheck;

public class StormLightningBooster implements SummonLightningBooster {
    @Override
    public int radiusModifier(ServerPlayer serverPlayer) {
        return 0;
    }

    @Override
    public int lightningPowerModifier(ServerPlayer serverPlayer) {
        boolean isRaining = serverPlayer.level().getServer().getWeatherData().isRaining();
        boolean isThundering = serverPlayer.level().getServer().getWeatherData().isThundering();
        if(isRaining && isThundering) {
            return 2;
        }
        if(isRaining) {
            return 1;
        }
        return 0;
    }

    @Override
    public int cooldownReducer(ServerPlayer serverPlayer) {
        boolean isRaining = serverPlayer.level().getServer().getWeatherData().isRaining();
        boolean isThundering = serverPlayer.level().getServer().getWeatherData().isThundering();
        if(isThundering) {
            return 800;
        }
        if(isRaining) {
            return 200;
        }
        return 0;
    }
}
