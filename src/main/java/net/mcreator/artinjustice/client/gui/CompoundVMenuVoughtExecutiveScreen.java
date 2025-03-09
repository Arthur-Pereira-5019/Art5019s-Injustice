package net.mcreator.artinjustice.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.artinjustice.world.inventory.CompoundVMenuVoughtExecutiveMenu;
import net.mcreator.artinjustice.network.CompoundVMenuVoughtExecutiveButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CompoundVMenuVoughtExecutiveScreen extends AbstractContainerScreen<CompoundVMenuVoughtExecutiveMenu> {
	private final static HashMap<String, Object> guistate = CompoundVMenuVoughtExecutiveMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_buy;

	public CompoundVMenuVoughtExecutiveScreen(CompoundVMenuVoughtExecutiveMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 288;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/compound_v_menu_vought_executive.png");

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

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/vought_icon.png"), this.leftPos + 4, this.topPos + 4, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_since_the_compoundv_is_our_most"), 70, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_valuable_asset_costing_millions"), 70, 14, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_of_dollars_to_fill_only_a_syring"), 70, 24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_our_transactions_are_built_aroun"), 71, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_diamond_blocks_the_starting_bid"), 71, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_are_10_of_those_im_sure_someon"), 71, 51, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_like_you_is_able_to_pay_that_amo"), 71, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_amount_for_our_weakest_serums_b"), 5, 69, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_as_inteligent_as_we_think_you_ar"), 5, 78, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.label_able_to_pay_way_more_in_exchange"), 5, 87, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_buy = Button.builder(Component.translatable("gui.art5019injustice.compound_v_menu_vought_executive.button_buy"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new CompoundVMenuVoughtExecutiveButtonMessage(0, x, y, z));
				CompoundVMenuVoughtExecutiveButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 96, 40, 20).build();
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
	}
}
