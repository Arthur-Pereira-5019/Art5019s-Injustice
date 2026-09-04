package com.art5019.art5019s_injustice.graphics.toast;

import com.art5019.art5019s_injustice.network.SkillLevelUpPacket;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.toasts.RecipeToast;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

public class SkillToast implements Toast {
    private static final Identifier BACKGROUND_SPRITE = Identifier.withDefaultNamespace("toast/recipe");
    private static final long DISPLAY_TIME = 5000L;
    private static final Component TITLE_TEXT = Component.translatable("art5019sinjustice.skill.toast.title");
    private final List<SkillToast.Entry> recipeItems = new ArrayList();
    private long lastChanged;
    private String newLevelDescription;
    private boolean changed;
    private Toast.Visibility wantedVisibility;
    private int displayedRecipeIndex;

    private SkillToast(SkillLevelUpPacket skillLevelUpPacket) {
        newLevelDescription = skillLevelUpPacket.skillName();
        this.wantedVisibility = Visibility.HIDE;
    }

    public Toast.Visibility getWantedVisibility() {
        return this.wantedVisibility;
    }

    public void update(ToastManager manager, long fullyVisibleForMs) {
        if (this.changed) {
            this.lastChanged = fullyVisibleForMs;
            this.changed = false;
        }

        if (this.recipeItems.isEmpty()) {
            this.wantedVisibility = Visibility.HIDE;
        } else {
            this.wantedVisibility = (double)(fullyVisibleForMs - this.lastChanged) >= (double)5000.0F * manager.getNotificationDisplayTimeMultiplier() ? Visibility.HIDE : Visibility.SHOW;
        }

        this.displayedRecipeIndex = (int)((double)fullyVisibleForMs / Math.max((double)1.0F, (double)5000.0F * manager.getNotificationDisplayTimeMultiplier() / (double)this.recipeItems.size()) % (double)this.recipeItems.size());
    }



    public void extractRenderState(GuiGraphicsExtractor graphics, Font font, long fullyVisibleForMs) {
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, BACKGROUND_SPRITE, 0, 0, this.width(), this.height());
        graphics.text(font, TITLE_TEXT, 30, 7, -11534256, false);
        graphics.text(font, newLevelDescription, 30, 18, -16777216, false);
        SkillToast.Entry items = (SkillToast.Entry)this.recipeItems.get(this.displayedRecipeIndex);
        graphics.pose().pushMatrix();
        graphics.pose().scale(0.6F, 0.6F);
        graphics.fakeItem(items.categoryItem(), 3, 3);
        graphics.pose().popMatrix();
        graphics.fakeItem(items.unlockedItem(), 8, 8);
    }

    private static record Entry(ItemStack categoryItem, ItemStack unlockedItem) {
    }

    public static void addOrUpdate(ToastManager toastManager, SkillLevelUpPacket skillLevelUpPacket) {
        SkillToast toast = (SkillToast)toastManager.getToast(SkillToast.class, NO_TOKEN);
        if (toast == null) {
            toast = new SkillToast(skillLevelUpPacket);
            toastManager.addToast(toast);
        }

        ContextMap context = SlotDisplayContext.fromLevel(toastManager.getMinecraft().level);
    }

}
