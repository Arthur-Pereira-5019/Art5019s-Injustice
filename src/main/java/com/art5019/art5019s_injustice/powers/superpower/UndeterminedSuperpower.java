package com.art5019.art5019s_injustice.powers.superpower;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public abstract class UndeterminedSuperpower {
    private final TextDecoration textDecoration;
    private final String translatable;
    private final int powerId;

    public UndeterminedSuperpower(TextDecoration textDecoration, String translatable, int powerId) {
        this.textDecoration = textDecoration;
        this.translatable = translatable;
        this.powerId = powerId;
    }

    public abstract void onGain(ServerPlayer serverPlayer);

    public MutableComponent getCompScientific() {
        return Component.translatable(MODID+".power.scientific."+translatable);
    }

    public MutableComponent getComp() {
        return Component.translatable(MODID+".power."+translatable);
    }

    public MutableComponent getCompScientificDecorated() {
        if(textDecoration != null) {
            return getCompScientific().withColor(textDecoration.color);
        }
        return getCompScientific();
    }

    public MutableComponent getCompScientificDecoratedItalic() {
        return getCompScientificDecorated().withStyle(ChatFormatting.ITALIC);
    }

    public int getPowerId() {
        return powerId;
    }
}
