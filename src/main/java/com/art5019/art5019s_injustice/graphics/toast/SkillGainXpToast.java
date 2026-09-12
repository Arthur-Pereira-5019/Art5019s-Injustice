package com.art5019.art5019s_injustice.graphics.toast;

import com.art5019.art5019s_injustice.data.records.skill.PlayerSkill;
import com.art5019.art5019s_injustice.data.records.skill.Skills;
import com.art5019.art5019s_injustice.network.SkillGainXpPacket;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class SkillGainXpToast implements Toast {
    private static final Identifier BACKGROUND_SPRITE = Identifier.withDefaultNamespace("toast/advancement");
    private static final Component TITLE_TEXT = Component.translatable("art5019sinjustice.skill.gain_xp.toast.title");
    private final Component newLevelDescription;
    private Visibility wantedVisibility;
    private PlayerSkill associatedSkill;

    public SkillGainXpToast(SkillGainXpPacket skillGainXpPacket) {
        associatedSkill = new PlayerSkill(skillGainXpPacket.skillId(),skillGainXpPacket.skillXp());
        newLevelDescription = PlayerSkill.gainXpComponent(skillGainXpPacket.skillId(), skillGainXpPacket.skillXp());
        this.wantedVisibility = Visibility.HIDE;
    }

    public Visibility getWantedVisibility() {
        return this.wantedVisibility;
    }

    public void update(ToastManager manager, long fullyVisibleForMs) {
        this.wantedVisibility = fullyVisibleForMs >= 5000.0 * manager.getNotificationDisplayTimeMultiplier()
                ? Visibility.HIDE
                : Visibility.SHOW;

    }

    public void extractRenderState(GuiGraphicsExtractor graphics, Font font, long fullyVisibleForMs) {
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, BACKGROUND_SPRITE, 0, 0, this.width(), this.height());
        graphics.text(font, TITLE_TEXT, 25, 7, 0xFFCCFF00, false);
        graphics.text(font, newLevelDescription, 25, 18, -16777216, false);
        graphics.pose().pushMatrix();
        graphics.pose().scale(0.6F, 0.6F);
        graphics.pose().popMatrix();
        graphics.fakeItem(Skills.fromId(associatedSkill.skillId()).itemStack,5,8);
    }


}
