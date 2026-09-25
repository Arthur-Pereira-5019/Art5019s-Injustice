package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.powers.conditions.Condition;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;
import java.util.Optional;

public abstract class PowerType {
    private final String defaultTranslatable;
    private final String defaultDescription;
    private final int defaultCooldownTicks;
    private final Identifier defaultIconSource;

    public PowerType(String defaultTranslatable, Identifier defaultIconSource, String defaultDescription, int defaultCooldownTicks) {
        this.defaultTranslatable = defaultTranslatable;
        this.defaultIconSource = defaultIconSource;
        this.defaultDescription = defaultDescription;
        this.defaultCooldownTicks = defaultCooldownTicks;
    }

    public int getDefaultCooldownTicks() {
        return defaultCooldownTicks;
    }


    public String getDefaultDescription() {
        return defaultDescription;
    }

    public Identifier getDefaultIconSource() {
        return defaultIconSource;
    }

    public String getDefaultTranslatable() {
        return defaultTranslatable;
    }

    public abstract boolean use(ServerPlayer serverPlayer);
}
