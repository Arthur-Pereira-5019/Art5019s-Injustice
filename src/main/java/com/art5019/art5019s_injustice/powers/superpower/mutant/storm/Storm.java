package com.art5019.art5019s_injustice.powers.superpower.mutant.storm;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.powers.Power;
import com.art5019.art5019s_injustice.powers.power_types.*;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Storm extends Superpower {
    private static Storm storm;
    private Storm() {
        List<Power> powers = new ArrayList<>();
        Power revokeTornado = new Power(null,
                null,
                new RevokeTornado(300, 8),
                null,
                null,
                1200,
                null,
                1);
        Power summonTornado = new Power(null,
                revokeTornado,
                new SummonTornado(500, 3F),
                null,
                null,
                6000,
                null,
                1);
        Power summonLightning = new Power(null,
                null,
                new SummonLightning(300, 2, new StormLightningBooster()),
                null,
                null,
                2400,
                null,
                2);
        Power revokeMist = new Power(null,
                null,
                new RevokeMist(300, 32),
                null,
                null,
                1200,
                null,
                3);
        Power summonMist = new Power(null,
                revokeMist,
                new SummonMist(4800, 96),
                null,
                null,
                6000,
                null,
                3);
        Power reduceWeather = new Power(null,
                null,
                new WeatherShifting(-1),
                null,
                null,
                3600,
                null,
                4);
        Power addWeather = new Power(null,
                reduceWeather,
                new WeatherShifting(1),
                null,
                null,
                3600,
                null,
                5);
        Power addColdZone = new Power(null,
                null,
                new SummonColdZone(900),
                null,
                null,
                3600,
                null,
                6);
        powers.add(summonTornado);
        powers.add(summonLightning);
        powers.add(summonMist);
        powers.add(addWeather);
        powers.add(addColdZone);
        super(powers, 1, TextDecoration.PURPLE, "storm", 2);
    }


    @Override
    public void onGain(ServerPlayer serverPlayer) {

    }

    public static Storm getInstance() {
        if(storm == null) {
            storm = new Storm();
        }
        return storm;
    }
}
