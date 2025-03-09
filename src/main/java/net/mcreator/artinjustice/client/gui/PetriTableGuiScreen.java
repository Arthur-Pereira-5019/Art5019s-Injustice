package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.PetriTableGuiMenu;
import net.mcreator.artinjustice.procedures.IfSlot2IsEmptyProcedure;
import net.mcreator.artinjustice.procedures.IfSlot1IsEmptyProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PetriTableGuiScreen extends AbstractContainerScreen<PetriTableGuiMenu> {
	private final static HashMap<String, Object> guistate = PetriTableGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PetriTableGuiScreen(PetriTableGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/petri_table_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (IfSlot2IsEmptyProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 5 && mouseX < leftPos + 29 && mouseY > topPos + 31 && mouseY < topPos + 55)
				guiGraphics.renderTooltip(font, Component.translatable("gui.art5019injustice.petri_table_gui.tooltip_food"), mouseX, mouseY);
		if (IfSlot1IsEmptyProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 31 && mouseY < topPos + 55)
				guiGraphics.renderTooltip(font, Component.translatable("gui.art5019injustice.petri_table_gui.tooltip_cologne"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	}
}
