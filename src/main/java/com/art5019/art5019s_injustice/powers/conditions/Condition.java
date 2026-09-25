package com.art5019.art5019s_injustice.powers.conditions;

import net.minecraft.server.level.ServerPlayer;

@FunctionalInterface
public interface Condition {
    public abstract boolean shouldUse(ServerPlayer serverPlayer);
}
