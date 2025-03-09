package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.SummoningBookGUIMenu;
import net.mcreator.artinjustice.procedures.ReturnTargetedEntitySummoningBookProcedure;
import net.mcreator.artinjustice.procedures.ReturnExpSummoningBookProcedure;
import net.mcreator.artinjustice.network.SummoningBookGUIButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SummoningBookGUIScreen extends AbstractContainerScreen<SummoningBookGUIMenu> {
	private final static HashMap<String, Object> guistate = SummoningBookGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_summon;

	public SummoningBookGUIScreen(SummoningBookGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/summoning_book_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ReturnTargetedEntitySummoningBookProcedure.execute(world, entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 142, this.topPos + 59, 30, 0f + (float) Math.atan((this.leftPos + 142 - mouseX) / 40.0), (float) Math.atan((this.topPos + 10 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/xp.png"), this.leftPos + 8, this.topPos + 63, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.summoning_book_gui.label_target"), 29, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.summoning_book_gui.label_bait"), 29, 31, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnExpSummoningBookProcedure.execute(entity), 29, 67, -10761472, false);
	}

	@Override
	public void init() {
		super.init();
		button_summon = Button.builder(Component.translatable("gui.art5019injustice.summoning_book_gui.button_summon"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new SummoningBookGUIButtonMessage(0, x, y, z));
				SummoningBookGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 59, 56, 20).build();
		guistate.put("button:button_summon", button_summon);
		this.addRenderableWidget(button_summon);
	}
}
