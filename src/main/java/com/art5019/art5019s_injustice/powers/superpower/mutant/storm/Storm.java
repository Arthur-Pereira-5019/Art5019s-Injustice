package com.art5019.art5019s_injustice.powers.superpower.mutant.storm;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.powers.Power;
import com.art5019.art5019s_injustice.powers.power_types.SummonTornado;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Storm extends Superpower {
    private static Storm storm;
    private Storm() {
        List<Power> powers = new ArrayList<>();
        Power summonTornado = new Power(null,
                null,
                new SummonTornado(2600, 3F),
                null,
                null,
                6000,
                null,
                1);
        powers.add(summonTornado);
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
