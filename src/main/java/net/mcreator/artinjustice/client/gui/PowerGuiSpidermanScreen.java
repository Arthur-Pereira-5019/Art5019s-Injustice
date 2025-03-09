package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.PowerGuiSpidermanMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PowerGuiSpidermanScreen extends AbstractContainerScreen<PowerGuiSpidermanMenu> {
	private final static HashMap<String, Object> guistate = PowerGuiSpidermanMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PowerGuiSpidermanScreen(PowerGuiSpidermanMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/power_gui_spiderman.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/icon_spider.png"), this.leftPos + 3, this.topPos + 4, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/regeneration.png"), this.leftPos + 10, this.topPos + 39, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/strength.png"), this.leftPos + 10, this.topPos + 57, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/jump_boost.png"), this.leftPos + 10, this.topPos + 75, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/spidersenseicon.png"), this.leftPos + 10, this.topPos + 93, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/wallcrawl.png"), this.leftPos + 10, this.topPos + 111, 0, 0, 18, 18, 18, 18);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/fallimmunityframe.png"), this.leftPos + 10, this.topPos + 129, 0, 0, 18, 18, 18, 18);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.power_gui_spiderman.label_spiderman"), 35, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.power_gui_spiderman.label_level"), 35, 17, -11993344, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.power_gui_spiderman.label_ability_1"), 30, 115, -16716033, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.power_gui_spiderman.label_regeneration_ii"), 31, 44, -16711934, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.power_gui_spiderman.label_strength_ii"), 30, 61, -16711934, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.power_gui_spiderman.label_jump_boost_ii"), 30, 79, -16711934, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.power_gui_spiderman.label_spider_sense_30"), 30, 97, -22528, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.power_gui_spiderman.label_fall_immunity"), 30, 133, -393472, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
