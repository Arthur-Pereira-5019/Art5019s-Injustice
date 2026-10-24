package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import com.art5019.art5019s_injustice.powers.booster.EmptyPowerBooster;
import com.art5019.art5019s_injustice.powers.booster.PowerTypeBooster;
import com.art5019.art5019s_injustice.weather.WeatherHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public class WeatherShifting extends PowerType{
    private final int shift;

    public WeatherShifting(String defaultTranslatable, Identifier defaultIconSource, String defaultDescription, int defaultCooldownTicks, int shift) {
        super(defaultTranslatable, defaultIconSource, defaultDescription, defaultCooldownTicks);
        this.shift = shift;
    }

    public WeatherShifting(int shift) {
        this.shift = shift;
        super("art5019sinjustice.powertype.weather_shifting.name",
                Identifier.fromNamespaceAndPath(MODID,""),
                "art5019sinjustice.powertype.weather_shifting.description",
                3600);
    }

    @Override
    public int use(ServerPlayer serverPlayer) {
        WeatherHelper.shiftWeather(serverPlayer.level(), shift);
        return this.getDefaultCooldownTicks();
    }

    @Override
    public PowerTypeBooster getBooster() {
        return new EmptyPowerBooster();
    }
}
