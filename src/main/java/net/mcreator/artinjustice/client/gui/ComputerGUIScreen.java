package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.ComputerGUIMenu;
import net.mcreator.artinjustice.network.ComputerGUIButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ComputerGUIScreen extends AbstractContainerScreen<ComputerGUIMenu> {
	private final static HashMap<String, Object> guistate = ComputerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_upgrade;
	ImageButton imagebutton_newspaper_icon;

	public ComputerGUIScreen(ComputerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/computer_gui.png");

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

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/programming_icon.png"), this.leftPos + 6, this.topPos + 8, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.computer_gui.label_ai"), 31, 13, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.computer_gui.label_advanced_chips"), 90, 12, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_upgrade = Button.builder(Component.translatable("gui.art5019injustice.computer_gui.button_upgrade"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new ComputerGUIButtonMessage(0, x, y, z));
				ComputerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 57, this.topPos + 50, 61, 20).build();
		guistate.put("button:button_upgrade", button_upgrade);
		this.addRenderableWidget(button_upgrade);
		imagebutton_newspaper_icon = new ImageButton(this.leftPos + 6, this.topPos + 25, 16, 16, 0, 0, 16, new ResourceLocation("art5019injustice:textures/screens/atlas/imagebutton_newspaper_icon.png"), 16, 32, e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new ComputerGUIButtonMessage(1, x, y, z));
				ComputerGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_newspaper_icon", imagebutton_newspaper_icon);
		this.addRenderableWidget(imagebutton_newspaper_icon);
	}
}
