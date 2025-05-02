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

import net.mcreator.artinjustice.world.inventory.QuicksilverQuickTravelGUIMenu;
import net.mcreator.artinjustice.procedures.ReturnQuicksilverMaxDistanceTravelProcedure;
import net.mcreator.artinjustice.network.QuicksilverQuickTravelGUIButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class QuicksilverQuickTravelGUIScreen extends AbstractContainerScreen<QuicksilverQuickTravelGUIMenu> {
	private final static HashMap<String, Object> guistate = QuicksilverQuickTravelGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox travelX;
	EditBox TravelZ;
	Button button_travel;

	public QuicksilverQuickTravelGUIScreen(QuicksilverQuickTravelGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/quicksilver_quick_travel_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		travelX.render(guiGraphics, mouseX, mouseY, partialTicks);
		TravelZ.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/map.png"), this.leftPos + -18, this.topPos + -38, 0, 0, 243, 241, 243, 241);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (travelX.isFocused())
			return travelX.keyPressed(key, b, c);
		if (TravelZ.isFocused())
			return TravelZ.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		travelX.tick();
		TravelZ.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String travelXValue = travelX.getValue();
		String TravelZValue = TravelZ.getValue();
		super.resize(minecraft, width, height);
		travelX.setValue(travelXValue);
		TravelZ.setValue(TravelZValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnQuicksilverMaxDistanceTravelProcedure.execute(entity), 18, 11, -16777216, false);
	}

	@Override
	public void init() {
		super.init();
		travelX = new EditBox(this.font, this.leftPos + 18, this.topPos + 35, 118, 18, Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.travelX")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.travelX").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.travelX").getString());
				else
					setSuggestion(null);
			}
		};
		travelX.setSuggestion(Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.travelX").getString());
		travelX.setMaxLength(32767);
		guistate.put("text:travelX", travelX);
		this.addWidget(this.travelX);
		TravelZ = new EditBox(this.font, this.leftPos + 18, this.topPos + 65, 118, 18, Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.TravelZ")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.TravelZ").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.TravelZ").getString());
				else
					setSuggestion(null);
			}
		};
		TravelZ.setSuggestion(Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.TravelZ").getString());
		TravelZ.setMaxLength(32767);
		guistate.put("text:TravelZ", TravelZ);
		this.addWidget(this.TravelZ);
		button_travel = Button.builder(Component.translatable("gui.art5019injustice.quicksilver_quick_travel_gui.button_travel"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new QuicksilverQuickTravelGUIButtonMessage(0, x, y, z));
				QuicksilverQuickTravelGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 137, this.topPos + 96, 56, 20).build();
		guistate.put("button:button_travel", button_travel);
		this.addRenderableWidget(button_travel);
	}
}
