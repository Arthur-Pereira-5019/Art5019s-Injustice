package com.art5019.art5019s_injustice.powers.superpower;


import com.art5019.art5019s_injustice.powers.Power;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public abstract class Superpower {
    private final List<Power> powers;
    private final int maxLevel;

    protected Superpower(List<Power> powers, int maxLevel) {
        this.powers = powers;
        this.maxLevel = maxLevel;
    }

    public List<Power> getAvailablePowers(ServerPlayer serverPlayer) {
        return powers.stream().filter(x -> x.canUse(serverPlayer)).toList();
    }

    public List<Power> getPowers() {
        return powers;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}
