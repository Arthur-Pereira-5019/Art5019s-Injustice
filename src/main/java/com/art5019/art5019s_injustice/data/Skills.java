package com.art5019.art5019s_injustice.data;

public enum Skills {
    ENGINEERING(0,5),
    CHEMISTRY(1,5),
    GENETICS(2,5),
    INTELLIGENCE(3,12);

    public final int skillId;
    public final int levelCap;

    Skills(int skillId, int levelCap) {
        this.skillId = skillId;
        this.levelCap = levelCap;
    }

    public static Skills fromId(int skillId) {
        for (Skills value : Skills.values()) {
            if(value.skillId == skillId) {
                return value;
            }
        }
    }


}
