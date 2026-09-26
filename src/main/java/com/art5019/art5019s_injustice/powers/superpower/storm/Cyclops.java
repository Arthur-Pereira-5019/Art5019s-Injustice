package com.art5019.art5019s_injustice.powers.superpower.storm;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.powers.Power;
import com.art5019.art5019s_injustice.powers.power_types.SummonTornado;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import com.art5019.art5019s_injustice.powers.superpower.UndeterminedSuperpower;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Cyclops extends Superpower {
    private static Cyclops cyclops;
    private Cyclops() {
        List<Power> powers = new ArrayList<>();
        Power summonTornado = new Power(null,
                null,
                new SummonTornado(2600, 3F),
                null,
                null,
                6000,
                null);
        powers.add(summonTornado);
        super(powers, 1, TextDecoration.PURPLE, "cyclops", 3);
    }


    @Override
    public void onGain(ServerPlayer serverPlayer) {

    }

    public static Cyclops getInstance() {
        if(cyclops == null) {
            cyclops = new Cyclops();
        }
        return cyclops;
    }
}