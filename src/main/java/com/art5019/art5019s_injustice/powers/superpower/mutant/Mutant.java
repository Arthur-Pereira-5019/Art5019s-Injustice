package com.art5019.art5019s_injustice.powers.superpower.mutant;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.data.common.WeightedList;
import com.art5019.art5019s_injustice.powers.superpower.SuperpowerGroup;
import com.art5019.art5019s_injustice.powers.superpower.UndeterminedSuperpower;

import java.util.Map;

public class Mutant extends SuperpowerGroup {
    private static Mutant mutant;

    private Mutant() {
        super(TextDecoration.NONE,
                "mutant",
                new WeightedList<>(Map.of(OmegaMutant.getInstance(),1.0F,
                        AlphaMutant.getInstance(),5.0F,
                        BetaMutant.getInstance(),15.0F)),
                -1);
    }

    public static Mutant getInstance() {
        if(mutant == null) {
            mutant = new Mutant();
        }
        return mutant;
    }
}
