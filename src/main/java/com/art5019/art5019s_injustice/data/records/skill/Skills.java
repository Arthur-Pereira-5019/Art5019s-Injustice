package com.art5019.art5019s_injustice.data.records.skill;

import net.minecraft.world.item.ItemStack;

import static net.minecraft.world.item.Items.*;

public enum Skills {
    CHEMISTRY(0, 5,"chemistry",new ItemStack(BREWING_STAND)),
    ENGINEERING(1, 7,"engineering",new ItemStack(REDSTONE)),
    GENETICS(2, 5,"genetics", new ItemStack(ROTTEN_FLESH)),
    INTELLIGENCE(3, 12,"intelligence", new ItemStack(KNOWLEDGE_BOOK));

    public final int skillId;
    public final int levelCap;
    public final String translatableSuffix;
    public final ItemStack itemStack;

    Skills(int skillId, int levelCap, String translatableSuffix, ItemStack itemStack) {
        this.skillId = skillId;
        this.levelCap = levelCap;
        this.translatableSuffix = translatableSuffix;
        this.itemStack = itemStack;
    }

    public static Skills fromId(int skillId) {
        for (Skills value : Skills.values()) {
            if (value.skillId == skillId) {
                return value;
            }
        }
        throw new RuntimeException("Mismatched skill id");
    }


}
