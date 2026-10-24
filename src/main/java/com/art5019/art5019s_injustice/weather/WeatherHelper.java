package com.art5019.art5019s_injustice.weather;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;

public class WeatherHelper {
    public static void shiftWeather(ServerLevel serverLevel, int shift) {
        switch ((currentWeather(serverLevel) + shift) % 3) {
            case 0 -> serverLevel.getServer().setWeatherParameters(6000, 0, false, false);
            case 1 -> serverLevel.getServer().setWeatherParameters(0, 6000, true, false);
            case 2 -> serverLevel.getServer().setWeatherParameters(0, 6000, true, true);
        }
    }

    public static int currentWeather(ServerLevel serverLevel) {
        boolean rain = serverLevel.isRaining();
        boolean thunder = serverLevel.isThundering();
        if(rain && thunder) {
            return 2;
        }
        if(rain) {
            return 1;
        }
        return 0;
    }


}
