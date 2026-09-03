package com.art5019.art5019s_injustice.data;

import com.art5019.art5019s_injustice.helper.TextHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public record Skill(int skillId, int level) {
    public MutableComponent getTranslatable() {
        return Component.translatable(MODID+".skill."+Skills.fromId(skillId).translatableSuffix);
    }

    public MutableComponent getComponent() {
        MutableComponent component = getTranslatable();
        component.append(Component.literal(" "));
        component.append(TextHelper.toRomanNumeral(level+1));
        component.withColor(levelColor());
        return component;
    }

    public TextColor levelColor() {
        return switch (level) {
            case 0 -> TextColor.parseColor("#4d3719").getOrThrow();
            case 1 -> TextColor.GRAY;
            case 2 -> TextColor.parseColor("#b46519").getOrThrow();
            case 3 -> TextColor.DARK_GRAY;
            case 4 -> TextColor.GOLD;
            case 5 -> TextColor.GREEN;
            case 6 -> TextColor.AQUA;
            case 7 -> TextColor.BLACK;
            default -> TextColor.GRAY;
        };
    }
}
