package com.art5019.art5019s_injustice.powers.superpower.storm;

import com.art5019.art5019s_injustice.powers.Power;
import com.art5019.art5019s_injustice.powers.power_types.SummonTornado;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;

import java.util.ArrayList;
import java.util.List;

public class Storm extends Superpower {
    public Storm() {
        List<Power> powers = new ArrayList<>();
        Power summonTornado = new Power(null,
                null,
                new SummonTornado(2600, 3F),
                null,
                null,
                6000,
                null);
        powers.add(summonTornado);
        super(powers, 1);
    }
}
