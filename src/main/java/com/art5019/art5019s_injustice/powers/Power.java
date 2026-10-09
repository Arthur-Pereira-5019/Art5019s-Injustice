package com.art5019.art5019s_injustice.powers;

import com.art5019.art5019s_injustice.powers.conditions.Condition;
import com.art5019.art5019s_injustice.powers.conditions.ConditionAlways;
import com.art5019.art5019s_injustice.powers.power_types.PowerType;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Power {
    private final PowerType powerType;
    private final String translatable;
    private final String description;
    private final int defaultCooldown;
    private final Identifier iconSource;
    private final Power secondaryPower;
    private final List<Condition> conditions;
    private final int id;

    public Power(String translatable, Power secondaryPower, PowerType powerType, Identifier iconSource, String description, int defaultCooldown, List<Condition> conditions, int id) {
        if(translatable == null) {
            this.translatable = powerType.getDefaultTranslatable();
        } else {
            this.translatable = translatable;
        }
        if(iconSource == null) {
            this.iconSource = powerType.getDefaultIconSource();
        } else {
            this.iconSource = iconSource;
        }
        if(description == null) {
            this.description = powerType.getDefaultDescription();
        } else {
            this.description = description;
        }

        if(secondaryPower != null && secondaryPower.getSecondaryPower() != null) {
            throw new RuntimeException("Secondary power with secondary power.");
        }
        this.secondaryPower = secondaryPower;
        this.powerType = powerType;
        this.defaultCooldown = defaultCooldown;
        if(conditions == null) {
            ArrayList<Condition> defaultCondition = new ArrayList<>();
            defaultCondition.add(ConditionAlways::shouldUse);
            this.conditions = defaultCondition;
        } else {
            this.conditions = conditions;
        }
        this.id = id;
    }

    public boolean use(ServerPlayer serverPlayer, boolean secondary) {
        if(secondary && secondaryPower != null) {
            secondaryPower.use(serverPlayer, false);
        } else {
            powerType.use(serverPlayer);
        }
        return true;
    }

    public boolean canUse(ServerPlayer serverPlayer) {
        for(Condition c: conditions) {
            if(!c.shouldUse(serverPlayer)) {
                return false;
            }
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public String getTranslatable() {
        return translatable;
    }

    public Power getSecondaryPower() {
        return secondaryPower;
    }
}
