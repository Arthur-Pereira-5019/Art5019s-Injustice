package com.art5019.art5019s_injustice.data.common;

import net.minecraft.network.chat.TextColor;

public enum TextDecoration {
    RED(TextColor.RED),
    NONE(TextColor.WHITE),
    YELLOW(TextColor.YELLOW),
    AQUA(TextColor.AQUA),
    PURPLE(TextColor.DARK_PURPLE);

    public final TextColor color;

    TextDecoration(TextColor color) {
        this.color = color;
    }
}
