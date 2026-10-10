package com.art5019.art5019s_injustice.data.emissors;

public enum EmissorEffect {
    TORNADO(1);

    final int id;

    EmissorEffect(int id) {
        this.id = id;
    }

    public static EmissorEffect fromId(int id) {
        switch (id) {
            case 1:
                return TORNADO;
            default:
                return TORNADO;
        }
    }

    public int getId() {
        return id;
    }
}
