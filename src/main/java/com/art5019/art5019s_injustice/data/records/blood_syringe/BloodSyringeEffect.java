package com.art5019.art5019s_injustice.data.records.blood_syringe;

public enum BloodSyringeEffect {
    POISON(0),
    HEALTHY(1),
    MUTANT(2);

    public final int id;

    BloodSyringeEffect(int id) {
        this.id = id;
    }
}
