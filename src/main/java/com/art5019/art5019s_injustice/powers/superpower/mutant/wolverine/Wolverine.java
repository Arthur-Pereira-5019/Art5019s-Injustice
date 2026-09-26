package com.art5019.art5019s_injustice.powers.superpower.mutant.wolverine;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.powers.Power;
import com.art5019.art5019s_injustice.powers.power_types.SummonTornado;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Wolverine extends Superpower {
    private static Wolverine wolverine;
    private Wolverine() {
        List<Power> powers = new ArrayList<>();
        Power summonTornado = new Power(null,
                null,
                new SummonTornado(2600, 3F),
                null,
                null,
                6000,
                null);
        powers.add(summonTornado);
        super(powers, 1, TextDecoration.YELLOW, "wolverine", 4);
    }


    @Override
    public void onGain(ServerPlayer serverPlayer) {

    }

    public static Wolverine getInstance() {
        if(wolverine == null) {
            wolverine = new Wolverine();
        }
        return wolverine;
    }
}