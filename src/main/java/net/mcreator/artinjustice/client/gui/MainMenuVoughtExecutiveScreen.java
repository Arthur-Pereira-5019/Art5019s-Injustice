package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.MainMenuVoughtExecutiveMenu;
import net.mcreator.artinjustice.network.MainMenuVoughtExecutiveButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MainMenuVoughtExecutiveScreen extends AbstractContainerScreen<MainMenuVoughtExecutiveMenu> {
	private final static HashMap<String, Object> guistate = MainMenuVoughtExecutiveMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_powers;
	Button button_suit;
	Button button_influence;
	Button button_merchandise;

	public MainMenuVoughtExecutiveScreen(MainMenuVoughtExecutiveMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 256;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/main_menu_vought_executive.png");

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

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/vought_icon.png"), this.leftPos + 7, this.topPos + 5, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.main_menu_vought_executive.label_my_name_is_stan_im_a_vought_ex"), 85, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.main_menu_vought_executive.label_executive_im_looking_forward_t"), 85, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.main_menu_vought_executive.label_to_make_great_negotations_with_y"), 84, 26, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.main_menu_vought_executive.label_you_what_would_you_like_to_buy"), 85, 35, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_powers = Button.builder(Component.translatable("gui.art5019injustice.main_menu_vought_executive.button_powers"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new MainMenuVoughtExecutiveButtonMessage(0, x, y, z));
				MainMenuVoughtExecutiveButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 73, 56, 20).build();
		guistate.put("button:button_powers", button_powers);
		this.addRenderableWidget(button_powers);
		button_suit = Button.builder(Component.translatable("gui.art5019injustice.main_menu_vought_executive.button_suit"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new MainMenuVoughtExecutiveButtonMessage(1, x, y, z));
				MainMenuVoughtExecutiveButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 94, 46, 20).build();
		guistate.put("button:button_suit", button_suit);
		this.addRenderableWidget(button_suit);
		button_influence = Button.builder(Component.translatable("gui.art5019injustice.main_menu_vought_executive.button_influence"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new MainMenuVoughtExecutiveButtonMessage(2, x, y, z));
				MainMenuVoughtExecutiveButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 115, 72, 20).build();
		guistate.put("button:button_influence", button_influence);
		this.addRenderableWidget(button_influence);
		button_merchandise = Button.builder(Component.translatable("gui.art5019injustice.main_menu_vought_executive.button_merchandise"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new MainMenuVoughtExecutiveButtonMessage(3, x, y, z));
				MainMenuVoughtExecutiveButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 136, 82, 20).build();
		guistate.put("button:button_merchandise", button_merchandise);
		this.addRenderableWidget(button_merchandise);
	}
}
