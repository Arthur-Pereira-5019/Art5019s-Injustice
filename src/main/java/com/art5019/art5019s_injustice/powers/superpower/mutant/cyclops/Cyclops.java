package com.art5019.art5019s_injustice.powers.superpower.mutant.cyclops;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.powers.Power;
import com.art5019.art5019s_injustice.powers.power_types.SummonTornado;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Cyclops extends Superpower {
    private static Cyclops cyclops;
    private Cyclops() {
        List<Power> powers = new ArrayList<>();
        super(powers, 1, TextDecoration.AQUA, "cyclops", 1);
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