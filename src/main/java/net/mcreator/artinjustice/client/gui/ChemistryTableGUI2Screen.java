package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.ChemistryTableGUI2Menu;
import net.mcreator.artinjustice.procedures.ShowIfSlot10IsEmptyProcedure;
import net.mcreator.artinjustice.network.ChemistryTableGUI2ButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ChemistryTableGUI2Screen extends AbstractContainerScreen<ChemistryTableGUI2Menu> {
	private final static HashMap<String, Object> guistate = ChemistryTableGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_produce;

	public ChemistryTableGUI2Screen(ChemistryTableGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 196;
		this.imageHeight = 186;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/chemistry_table_gui_2.png");

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
		if (ShowIfSlot10IsEmptyProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/chemistryscheme.png"), this.leftPos + 45, this.topPos + 52, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.chemistry_table_gui_2.label_chemistry_table"), 7, 8, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_produce = Button.builder(Component.translatable("gui.art5019injustice.chemistry_table_gui_2.button_produce"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new ChemistryTableGUI2ButtonMessage(0, x, y, z));
				ChemistryTableGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 23, this.topPos + 26, 61, 20).build();
		guistate.put("button:button_produce", button_produce);
		this.addRenderableWidget(button_produce);
	}
}
