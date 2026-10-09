package com.art5019.art5019s_injustice.powers.superpower.mutant.storm;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.powers.Power;
import com.art5019.art5019s_injustice.powers.power_types.RevokeTornado;
import com.art5019.art5019s_injustice.powers.power_types.SummonLightning;
import com.art5019.art5019s_injustice.powers.power_types.SummonTornado;
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
                new SummonLightning(300, 3),
                null,
                null,
                2400,
                null,
                2);
        powers.add(summonTornado);
        powers.add(summonLightning);
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
