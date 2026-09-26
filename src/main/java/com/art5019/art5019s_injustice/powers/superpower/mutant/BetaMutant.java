package com.art5019.art5019s_injustice.powers.superpower.mutant;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.data.common.WeightedList;
import com.art5019.art5019s_injustice.powers.superpower.SuperpowerGroup;
import com.art5019.art5019s_injustice.powers.superpower.mutant.shadowcat.Shadowcat;
import com.art5019.art5019s_injustice.powers.superpower.mutant.wolverine.Wolverine;

import java.util.Map;

public class BetaMutant extends SuperpowerGroup {
    private static BetaMutant betaMutant;

    private BetaMutant() {
        super(TextDecoration.YELLOW, "beta_mutant",
                new WeightedList<>(Map.of(Shadowcat.getInstance(),1.0F, Wolverine.getInstance(),1.0F)), -4);
    }

    public static BetaMutant getInstance() {
        if(betaMutant == null) {
            betaMutant = new BetaMutant();
        }
        return betaMutant;
    }
}
