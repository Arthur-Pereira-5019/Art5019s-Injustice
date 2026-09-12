package com.art5019.art5019s_injustice.data;

import com.art5019.art5019s_injustice.data.common.WeightedList;

import java.util.Map;

/**
 * powerId = 0: No power
 * powerId < 0: Power possibilities
 *
 */
public enum Power {
    NONE(0),

    MUTANT(-1, new WeightedList<>(Map.of(-2,1.0F,-3,5.0F,-4,15.0F))),
    OMEGA(-2, new WeightedList<>(Map.of(2,1.0F))),
    ALPHA(-3, new WeightedList<>(Map.of(1,1.0F))),
    BETA(-4, new WeightedList<>(Map.of(3,1.0F,4,1.0F))),

    CYCLOPS(1, new WeightedList<>(1)),
    STORM(2),
    WOLVERINE(3),
    SHADOWCAT(4);

    public final int powerId;
    public final WeightedList<Integer> weightedList;

    Power(int powerId, WeightedList<Integer> weightedList) {
        this.powerId = powerId;
        this.weightedList = weightedList;
    }

    Power(int powerId) {
        this.powerId = powerId;
        this.weightedList = new WeightedList<>(powerId);
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
