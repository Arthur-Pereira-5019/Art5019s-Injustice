package com.art5019.art5019s_injustice.powers.superpower.mutant.shadowcat;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.powers.Power;
import com.art5019.art5019s_injustice.powers.power_types.SummonTornado;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Shadowcat extends Superpower {
    private static Shadowcat shadowcat;
    private Shadowcat() {
        List<Power> powers = new ArrayList<>();
        super(powers, 1, TextDecoration.YELLOW, "shadowcat", 3);
    }


    @Override
    public void onGain(ServerPlayer serverPlayer) {

    }

    public static Shadowcat getInstance() {
        if(shadowcat == null) {
            shadowcat = new Shadowcat();
        }
        return shadowcat;
    }
}