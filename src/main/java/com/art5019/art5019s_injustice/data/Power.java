package com.art5019.art5019s_injustice.data;

import com.art5019.art5019s_injustice.data.common.WeightedList;

import java.util.Map;

/**
 * powerId = 0: No power.
 * powerId < 0: Power possibilites/set
 *
 */
public enum Power {
    NONE(0),

    CYCLOPS(1),
    STORM(2),
    WOLVERINE(3),
    SHADOWCAT(4),

    MUTANT_OMEGA(-2, new WeightedList<>(Map.of(STORM,1.0F))),
    MUTANT_ALPHA(-3, new WeightedList<>(Map.of(CYCLOPS,1.0F))),
    MUTANT_BETA(-4, new WeightedList<>(Map.of(SHADOWCAT,1.0F,WOLVERINE,1.0F))),

    MUTANT(-1, new WeightedList<>(Map.of(MUTANT_OMEGA,1.0F,MUTANT_ALPHA,5.0F,MUTANT_BETA,15.0F)));


    public final int powerId;
    public final WeightedList<Power> weightedList;

    Power(int powerId, WeightedList<Power> weightedList) {
        this.powerId = powerId;
        this.weightedList = weightedList;
    }

    Power(int powerId) {
        this.powerId = powerId;
        this.weightedList = new WeightedList<>(Power.fromId(powerId));
    }

    public static Power fromId(int powerId) {
        for (Power value : Power.values()) {
            if(value.powerId == powerId) {
                return value;
            }
        }
        return NONE;
    }

}
