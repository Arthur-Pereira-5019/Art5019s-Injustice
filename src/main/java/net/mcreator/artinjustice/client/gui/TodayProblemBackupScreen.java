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

import net.mcreator.artinjustice.world.inventory.TodayProblemBackupMenu;
import net.mcreator.artinjustice.procedures.TodayProblemChronometerProcedure;
import net.mcreator.artinjustice.procedures.ReturnTodayProblemResProcedure;
import net.mcreator.artinjustice.procedures.ReturnTodayProblemOpProcedure;
import net.mcreator.artinjustice.procedures.ReturnTodayProblemN2Procedure;
import net.mcreator.artinjustice.network.TodayProblemBackupButtonMessage;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TodayProblemBackupScreen extends AbstractContainerScreen<TodayProblemBackupMenu> {
	private final static HashMap<String, Object> guistate = TodayProblemBackupMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox n1;
	Button button_validate;

	public TodayProblemBackupScreen(TodayProblemBackupMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 80;
	}

	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/screens/today_problem_backup.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		n1.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("art5019injustice:textures/screens/spider_clock.png"), this.leftPos + 298, this.topPos + 7, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (n1.isFocused())
			return n1.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		n1.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String n1Value = n1.getValue();
		super.resize(minecraft, width, height);
		n1.setValue(n1Value);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnTodayProblemOpProcedure.execute(entity), 139, 36, -16777216, false);
		guiGraphics.drawString(this.font,

				ReturnTodayProblemN2Procedure.execute(entity), 151, 36, -16777216, false);
		guiGraphics.drawString(this.font,

				ReturnTodayProblemResProcedure.execute(entity), 262, 36, -16777216, false);
		guiGraphics.drawString(this.font,

				TodayProblemChronometerProcedure.execute(entity), 272, 12, -16777216, false);
	}

	@Override
	public void init() {
		super.init();
		n1 = new EditBox(this.font, this.leftPos + 9, this.topPos + 31, 118, 18, Component.translatable("gui.art5019injustice.today_problem_backup.n1")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.today_problem_backup.n1").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.art5019injustice.today_problem_backup.n1").getString());
				else
					setSuggestion(null);
			}
		};
		n1.setSuggestion(Component.translatable("gui.art5019injustice.today_problem_backup.n1").getString());
		n1.setMaxLength(32767);
		guistate.put("text:n1", n1);
		this.addWidget(this.n1);
		button_validate = Button.builder(Component.translatable("gui.art5019injustice.today_problem_backup.button_validate"), e -> {
			if (true) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new TodayProblemBackupButtonMessage(0, x, y, z));
				TodayProblemBackupButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 187, this.topPos + 30, 67, 20).build();
		guistate.put("button:button_validate", button_validate);
		this.addRenderableWidget(button_validate);
	}
}
