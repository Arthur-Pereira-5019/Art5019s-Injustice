package com.art5019.art5019s_injustice.powers.superpower.mutant;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.data.common.WeightedList;
import com.art5019.art5019s_injustice.powers.superpower.SuperpowerGroup;
import com.art5019.art5019s_injustice.powers.superpower.UndeterminedSuperpower;
import com.art5019.art5019s_injustice.powers.superpower.storm.Cyclops;

import java.util.Map;

public class AlphaMutant extends SuperpowerGroup {
    private static AlphaMutant alphaMutant;

    public AlphaMutant() {
        super(TextDecoration.AQUA, "alpha_mutant", new WeightedList<>(Map.of(Cyclops.getInstance(),1.0F)), -3);
    }

    public static AlphaMutant getInstance() {
        if(alphaMutant == null) {
            alphaMutant = new AlphaMutant();
        }
        return alphaMutant;
    }
}
