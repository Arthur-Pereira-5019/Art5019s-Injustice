package com.art5019.art5019s_injustice.data;

public enum Skills {
    CHEMISTRY(0, 5,"chemistry"),
    ENGINEERING(1, 7,"engineering"),
    GENETICS(2, 5,"genetics"),
    INTELLIGENCE(3, 12,"intelligence");

    public final int skillId;
    public final int levelCap;
    public final String translatableSuffix;

    Skills(int skillId, int levelCap, String translatableSuffix) {
        this.skillId = skillId;
        this.levelCap = levelCap;
        this.translatableSuffix = translatableSuffix;
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
