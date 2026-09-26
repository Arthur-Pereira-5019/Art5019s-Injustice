package com.art5019.art5019s_injustice.powers.superpower.mutant;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.data.common.WeightedList;
import com.art5019.art5019s_injustice.powers.superpower.SuperpowerGroup;
import com.art5019.art5019s_injustice.powers.superpower.UndeterminedSuperpower;
import com.art5019.art5019s_injustice.powers.superpower.storm.Storm;

import java.util.Map;

public class OmegaMutant extends SuperpowerGroup {
    private static OmegaMutant omegaMutant;

    private OmegaMutant() {
        super(TextDecoration.PURPLE, "omega_mutant",
                new WeightedList<>(Map.of(Storm.getInstance(),
                        1.0F)),
                -2);
    }

    public static OmegaMutant getInstance() {
        if(omegaMutant == null) {
            omegaMutant = new OmegaMutant();
        }
        return omegaMutant;
    }
}
