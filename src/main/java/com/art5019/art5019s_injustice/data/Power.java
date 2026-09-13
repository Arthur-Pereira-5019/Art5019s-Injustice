package com.art5019.art5019s_injustice.data;

import com.art5019.art5019s_injustice.data.common.WeightedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * powerId = 0: No power.
 * powerId < 0: Power possibilites/set
 *
 */
public enum Power {
    NONE(0,"human"),

    CYCLOPS(1, "cyclops"),
    STORM(2,"storm"),
    WOLVERINE(3,"wolverine"),
    SHADOWCAT(4,"shadowcat"),

    MUTANT_OMEGA(-2, new WeightedList<>(Map.of(STORM,1.0F)),"omega_mutant"),
    MUTANT_ALPHA(-3, new WeightedList<>(Map.of(CYCLOPS,1.0F)),"alpha_mutant"),
    MUTANT_BETA(-4, new WeightedList<>(Map.of(SHADOWCAT,1.0F,WOLVERINE,1.0F)),"beta_mutant"),

    MUTANT(-1, new WeightedList<>(Map.of(MUTANT_OMEGA,1.0F,MUTANT_ALPHA,5.0F,MUTANT_BETA,15.0F)),"mutant");


    public final int powerId;
    public final WeightedList<Power> weightedList;
    public final String translatable;

    Power(int powerId, WeightedList<Power> weightedList, String translatable) {
        this.powerId = powerId;
        this.weightedList = weightedList;
        this.translatable = translatable;
    }

    Power(int powerId, String translatable) {
        this.powerId = powerId;
        this.weightedList = new WeightedList<>(this);
        this.translatable = translatable;
    }

    public static Power fromId(int powerId) {
        for (Power value : Power.values()) {
            if(value.powerId == powerId) {
                return value;
            }
        }
        return NONE;
    }

    public static List<Power> collapseReferences(Power power) {
        ArrayList<Power> references = new ArrayList<>();
        references.add(power);
        Power currentPower;
        int i = 0;
        do {
            currentPower = references.get(i);
            List<Power> newPowerList = currentPower.weightedList.getKeyList();
            for (Power power1 : newPowerList) {
                if (!references.contains(power1)) {
                    references.add(power1);
                }
            }
            i++;
        } while (i != references.size());
        return references;
    }

    public static List<Power> collapseFinalReferences(Power power) {
        ArrayList<Integer> ids = new ArrayList<>();
        return collapseReferences(power).stream().filter(x -> x.powerId > 0).toList();
    }

}
