package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.MicroscopeGUIMenu;
import net.mcreator.artinjustice.procedures.IfSlot3IsEmptyProcedure;
import net.mcreator.artinjustice.network.MicroscopeGUIButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MicroscopeGUIScreen extends AbstractContainerScreen<MicroscopeGUIMenu> {
	private final static HashMap<String, Object> guistate = MicroscopeGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_analyze;

	public MicroscopeGUIScreen(MicroscopeGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/microscope_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (IfSlot3IsEmptyProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 8 && mouseX < leftPos + 32 && mouseY > topPos + 7 && mouseY < topPos + 31)
				guiGraphics.renderTooltip(font, Component.translatable("gui.art5019injustice.microscope_gui.tooltip_lenses"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/icon_arrow_2x.png"), this.leftPos + 51, this.topPos + 36, 0, 0, 64, 16, 64, 16);

		if (IfSlot3IsEmptyProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/lense_gui.png"), this.leftPos + 12, this.topPos + 11, 0, 0, 16, 16, 16, 16);
		}
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
	}

	@Override
	public void init() {
		super.init();
		button_analyze = Button.builder(Component.translatable("gui.art5019injustice.microscope_gui.button_analyze"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new MicroscopeGUIButtonMessage(0, x, y, z));
				MicroscopeGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 57, this.topPos + 9, 61, 20).build();
		guistate.put("button:button_analyze", button_analyze);
		this.addRenderableWidget(button_analyze);
	}
}
