package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.SawmillGuiMenu;
import net.mcreator.artinjustice.procedures.ReturnSawPowerProcedure;
import net.mcreator.artinjustice.procedures.IfSlot4IsEmptyProcedure;
import net.mcreator.artinjustice.procedures.IfSlot3IsEmptyProcedure;
import net.mcreator.artinjustice.procedures.IfSlot2IsEmptyProcedure;
import net.mcreator.artinjustice.procedures.IfSlot1IsEmptyProcedure;
import net.mcreator.artinjustice.network.SawmillGuiButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SawmillGuiScreen extends AbstractContainerScreen<SawmillGuiMenu> {
	private final static HashMap<String, Object> guistate = SawmillGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_saw;

	public SawmillGuiScreen(SawmillGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/sawmill_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 104 && mouseX < leftPos + 128 && mouseY > topPos + 30 && mouseY < topPos + 54)
			guiGraphics.renderTooltip(font, Component.translatable("gui.art5019injustice.sawmill_gui.tooltip_turn_into_dust"), mouseX, mouseY);
		if (IfSlot4IsEmptyProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 72 && mouseX < leftPos + 96 && mouseY > topPos + 30 && mouseY < topPos + 54)
				guiGraphics.renderTooltip(font, Component.translatable("gui.art5019injustice.sawmill_gui.tooltip_case"), mouseX, mouseY);
		if (IfSlot2IsEmptyProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 46 && mouseX < leftPos + 70 && mouseY > topPos + 30 && mouseY < topPos + 54)
				guiGraphics.renderTooltip(font, Component.translatable("gui.art5019injustice.sawmill_gui.tooltip_input"), mouseX, mouseY);
		if (IfSlot3IsEmptyProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 130 && mouseX < leftPos + 154 && mouseY > topPos + 30 && mouseY < topPos + 54)
				guiGraphics.renderTooltip(font, Component.translatable("gui.art5019injustice.sawmill_gui.tooltip_output"), mouseX, mouseY);
		if (IfSlot1IsEmptyProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 4 && mouseX < leftPos + 28 && mouseY > topPos + 4 && mouseY < topPos + 28)
				guiGraphics.renderTooltip(font, Component.translatable("gui.art5019injustice.sawmill_gui.tooltip_saw"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/saw_icon.png"), this.leftPos + 7, this.topPos + 7, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/empty_ingot.png"), this.leftPos + 50, this.topPos + 34, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font,

				ReturnSawPowerProcedure.execute(world, x, y, z), 46, 14, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_saw = new ImageButton(this.leftPos + 108, this.topPos + 33, 16, 16, 0, 0, 16, new ResourceLocation("art5019injustice:textures/screens/atlas/imagebutton_saw.png"), 16, 32, e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new SawmillGuiButtonMessage(0, x, y, z));
				SawmillGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_saw", imagebutton_saw);
		this.addRenderableWidget(imagebutton_saw);
	}
}
