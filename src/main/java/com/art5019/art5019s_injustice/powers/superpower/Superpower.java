package com.art5019.art5019s_injustice.powers.superpower;


import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.powers.Power;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public abstract class Superpower extends UndeterminedSuperpower{
    private final List<Power> powers;
    private final int maxLevel;

    protected Superpower(List<Power> powers, int maxLevel, TextDecoration textDecoration, String translatable, int powerId) {
        super(textDecoration, translatable, powerId);
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
