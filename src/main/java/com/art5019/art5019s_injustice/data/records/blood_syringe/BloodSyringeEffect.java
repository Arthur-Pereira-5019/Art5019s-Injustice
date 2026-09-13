package com.art5019.art5019s_injustice.data.records.blood_syringe;

import com.art5019.art5019s_injustice.data.Power;

/**
 * Strange isn't actually a blood type, it should only be used as a countermeasure to undefined Ids.
 * Powers here will appear grouped, as a way to generate contextualized loot more easily, calling
 * the provided power condition tests and so on. So, it must be avoided to add a single POWER entry, or
 * individual power entries without a proper reason to do so.
 */
public enum BloodSyringeEffect {
    STRANGE(-1,"strange",null),
    POISON(0,"toxic",null),
    HEALTHY(1,"healthy",null),
    MUTANT(2,"mutant", Power.class);

    public final int bloodEffectId;
    public final String translatable;
    public final Class<? extends Enum<?>> relatedEnum;

    BloodSyringeEffect(int bloodEffectId, String translatable, Class<? extends Enum<?>> relatedEnum) {
        this.bloodEffectId = bloodEffectId;
        this.translatable = translatable;
        this.relatedEnum = relatedEnum;
    }

    public static BloodSyringeEffect fromId(int bloodEffectId) {
        for (BloodSyringeEffect value : values()) {
            if(value.bloodEffectId == bloodEffectId) {
                return value;
            }
        }
        return HEALTHY;
    }
}
