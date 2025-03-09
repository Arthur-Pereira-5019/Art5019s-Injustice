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

import net.mcreator.artinjustice.world.inventory.BountyPaperGUIMenu;
import net.mcreator.artinjustice.network.BountyPaperGUIButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BountyPaperGUIScreen extends AbstractContainerScreen<BountyPaperGUIMenu> {
	private final static HashMap<String, Object> guistate = BountyPaperGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox KillTarget;
	Button button_empty;

	public BountyPaperGUIScreen(BountyPaperGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/bounty_paper_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		KillTarget.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (KillTarget.isFocused())
			return KillTarget.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		KillTarget.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String KillTargetValue = KillTarget.getValue();
		super.resize(minecraft, width, height);
		KillTarget.setValue(KillTargetValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.bounty_paper_gui.label_bounty_paper"), 16, 8, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		KillTarget = new EditBox(this.font, this.leftPos + 7, this.topPos + 33, 118, 18, Component.translatable("gui.art5019injustice.bounty_paper_gui.KillTarget"));
		KillTarget.setMaxLength(32767);
		guistate.put("text:KillTarget", KillTarget);
		this.addWidget(this.KillTarget);
		button_empty = Button.builder(Component.translatable("gui.art5019injustice.bounty_paper_gui.button_empty"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new BountyPaperGUIButtonMessage(0, x, y, z));
				BountyPaperGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 139, this.topPos + 32, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
