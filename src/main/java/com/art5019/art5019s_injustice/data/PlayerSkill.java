package com.art5019.art5019s_injustice.data;

import com.art5019.art5019s_injustice.helper.SkillHelper;
import com.art5019.art5019s_injustice.helper.TextHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public record PlayerSkill(int skillId, int xp) {
    public MutableComponent getTranslatable() {
        return Component.translatable(geTranslatationSource());
    }

    public String geTranslatationSource() {
        return MODID+".skill."+Skills.fromId(skillId).translatableSuffix;
    }

    public int getLevel() {
        return SkillHelper.getLevelForXp(xp);
    }

    public MutableComponent getComponent() {
        MutableComponent component = getTranslatable();
        component.append(Component.literal(" "));
        component.append(TextHelper.toRomanNumeral(getLevel()));
        component.withColor(levelColor());
        return component;
    }

    public TextColor levelColor() {
        return switch (getLevel()) {
            case 1 -> TextColor.parseColor("#4d3719").getOrThrow();
            case 2 -> TextColor.DARK_GRAY;
            case 3 -> TextColor.parseColor("#b46519").getOrThrow();
            case 4 -> TextColor.parseColor("#d9a785").getOrThrow();
            case 5 -> TextColor.GOLD;
            case 6 -> TextColor.GREEN;
            case 7 -> TextColor.AQUA;
            case 8 -> TextColor.BLACK;
            default -> TextColor.WHITE;
        };
    }

    public static Component levelUpComponent(int skillId, int level) {
        return new PlayerSkill(skillId, level).levelUpComponent();
    }

    public static Component gainXpComponent(int skillId, int level) {
        return new PlayerSkill(skillId, level).levelUpComponent();
    }

    public Component levelUpComponent() {
        return getTranslatable().
                append(Component.translatable(MODID+".skill.levelup")).
                append(String.valueOf(getLevel())).append("!").withColor(levelColor());
    }

    public Component gainXpComponent() {
        return getTranslatable().
                append(Component.translatable(MODID+".skill.gainxp")).
                append(String.valueOf(getLevel())).append("%").withColor(levelColor());
    }
}
