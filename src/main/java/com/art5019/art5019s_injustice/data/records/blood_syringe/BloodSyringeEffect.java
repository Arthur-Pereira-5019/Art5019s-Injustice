package com.art5019.art5019s_injustice.data.records.blood_syringe;

import com.art5019.art5019s_injustice.data.common.IdMapper;
import com.art5019.art5019s_injustice.powers.SuperpowerService;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;

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
    MUTANT(2,"mutant", SuperpowerService::getUndeterminedSuperpower);

    public final int bloodEffectId;
    public final String translatable;
    public final IdMapper<?> relatedMap;

    BloodSyringeEffect(int bloodEffectId, String translatable, IdMapper<?> relatedMap) {
        this.bloodEffectId = bloodEffectId;
        this.translatable = translatable;
        this.relatedMap = relatedMap;
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
