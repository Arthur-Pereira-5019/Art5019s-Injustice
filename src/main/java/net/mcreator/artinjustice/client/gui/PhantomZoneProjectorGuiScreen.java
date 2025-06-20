package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.artinjustice.world.inventory.PhantomZoneProjectorGuiMenu;
import net.mcreator.artinjustice.network.PhantomZoneProjectorGuiButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PhantomZoneProjectorGuiScreen extends AbstractContainerScreen<PhantomZoneProjectorGuiMenu> {
	private final static HashMap<String, Object> guistate = PhantomZoneProjectorGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox zField;
	EditBox xField;
	EditBox yField;
	Button button_configurate;

	public PhantomZoneProjectorGuiScreen(PhantomZoneProjectorGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/phantom_zone_projector_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		zField.render(guiGraphics, mouseX, mouseY, partialTicks);
		xField.render(guiGraphics, mouseX, mouseY, partialTicks);
		yField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/lightning_icon.png"), this.leftPos + 152, this.topPos + 64, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (zField.isFocused())
			return zField.keyPressed(key, b, c);
		if (xField.isFocused())
			return xField.keyPressed(key, b, c);
		if (yField.isFocused())
			return yField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		zField.tick();
		xField.tick();
		yField.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String zFieldValue = zField.getValue();
		String xFieldValue = xField.getValue();
		String yFieldValue = yField.getValue();
		super.resize(minecraft, width, height);
		zField.setValue(zFieldValue);
		xField.setValue(xFieldValue);
		yField.setValue(yFieldValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.label_phantom_zone_projector"), 15, 16, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		zField = new EditBox(this.font, this.leftPos + 16, this.topPos + 81, 118, 18, Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.zField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.zField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.zField").getString());
				else
					setSuggestion(null);
			}
		};
		zField.setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.zField").getString());
		zField.setMaxLength(32767);
		guistate.put("text:zField", zField);
		this.addWidget(this.zField);
		xField = new EditBox(this.font, this.leftPos + 16, this.topPos + 31, 118, 18, Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.xField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.xField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.xField").getString());
				else
					setSuggestion(null);
			}
		};
		xField.setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.xField").getString());
		xField.setMaxLength(32767);
		guistate.put("text:xField", xField);
		this.addWidget(this.xField);
		yField = new EditBox(this.font, this.leftPos + 16, this.topPos + 56, 118, 18, Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.yField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.yField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.yField").getString());
				else
					setSuggestion(null);
			}
		};
		yField.setSuggestion(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.yField").getString());
		yField.setMaxLength(32767);
		guistate.put("text:yField", yField);
		this.addWidget(this.yField);
		button_configurate = Button.builder(Component.translatable("gui.art5019injustice.phantom_zone_projector_gui.button_configurate"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new PhantomZoneProjectorGuiButtonMessage(0, x, y, z));
				PhantomZoneProjectorGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 46, this.topPos + 107, 82, 20).build();
		guistate.put("button:button_configurate", button_configurate);
		this.addRenderableWidget(button_configurate);
	}
}
