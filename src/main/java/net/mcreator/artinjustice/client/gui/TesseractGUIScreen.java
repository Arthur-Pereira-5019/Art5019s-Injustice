package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.artinjustice.world.inventory.TesseractGUIMenu;
import net.mcreator.artinjustice.network.TesseractGUIButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TesseractGUIScreen extends AbstractContainerScreen<TesseractGUIMenu> {
	private final static HashMap<String, Object> guistate = TesseractGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox X;
	EditBox Y;
	EditBox Z;
	ImageButton imagebutton_tesseractgohome;
	ImageButton imagebutton_icon_portal;

	public TesseractGUIScreen(TesseractGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/tesseract_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		X.render(guiGraphics, mouseX, mouseY, partialTicks);
		Y.render(guiGraphics, mouseX, mouseY, partialTicks);
		Z.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
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
		if (X.isFocused())
			return X.keyPressed(key, b, c);
		if (Y.isFocused())
			return Y.keyPressed(key, b, c);
		if (Z.isFocused())
			return Z.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		X.tick();
		Y.tick();
		Z.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String XValue = X.getValue();
		String YValue = Y.getValue();
		String ZValue = Z.getValue();
		super.resize(minecraft, width, height);
		X.setValue(XValue);
		Y.setValue(YValue);
		Z.setValue(ZValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		X = new EditBox(this.font, this.leftPos + 28, this.topPos + 12, 118, 18, Component.translatable("gui.art5019injustice.tesseract_gui.X")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.X").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.X").getString());
				else
					setSuggestion(null);
			}
		};
		X.setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.X").getString());
		X.setMaxLength(32767);
		guistate.put("text:X", X);
		this.addWidget(this.X);
		Y = new EditBox(this.font, this.leftPos + 28, this.topPos + 36, 118, 18, Component.translatable("gui.art5019injustice.tesseract_gui.Y")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.Y").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.Y").getString());
				else
					setSuggestion(null);
			}
		};
		Y.setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.Y").getString());
		Y.setMaxLength(32767);
		guistate.put("text:Y", Y);
		this.addWidget(this.Y);
		Z = new EditBox(this.font, this.leftPos + 28, this.topPos + 60, 118, 18, Component.translatable("gui.art5019injustice.tesseract_gui.Z")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.Z").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.Z").getString());
				else
					setSuggestion(null);
			}
		};
		Z.setSuggestion(Component.translatable("gui.art5019injustice.tesseract_gui.Z").getString());
		Z.setMaxLength(32767);
		guistate.put("text:Z", Z);
		this.addWidget(this.Z);
		imagebutton_tesseractgohome = new ImageButton(this.leftPos + 154, this.topPos + 13, 16, 16, 0, 0, 16, new ResourceLocation("art5019injustice:textures/screens/atlas/imagebutton_tesseractgohome.png"), 16, 32, e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new TesseractGUIButtonMessage(0, x, y, z));
				TesseractGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tesseractgohome", imagebutton_tesseractgohome);
		this.addRenderableWidget(imagebutton_tesseractgohome);
		imagebutton_icon_portal = new ImageButton(this.leftPos + 56, this.topPos + 88, 64, 64, 0, 0, 64, new ResourceLocation("art5019injustice:textures/screens/atlas/imagebutton_icon_portal.png"), 64, 128, e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new TesseractGUIButtonMessage(1, x, y, z));
				TesseractGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_icon_portal", imagebutton_icon_portal);
		this.addRenderableWidget(imagebutton_icon_portal);
	}
}
