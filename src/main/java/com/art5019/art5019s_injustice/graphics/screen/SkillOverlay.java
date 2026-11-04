package com.art5019.art5019s_injustice.graphics.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class SkillOverlay extends Screen {
    protected SkillOverlay(Component title) {
        super(Minecraft.getInstance(), Minecraft.getInstance().font, title);
    }

    @Override
    protected void init() {
        super.init();
    }
}
