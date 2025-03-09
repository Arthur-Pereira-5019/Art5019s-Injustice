
package net.mcreator.artinjustice.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.artinjustice.procedures.IfHasAlignmentNeg3Procedure;
import net.mcreator.artinjustice.procedures.IfHasAlignmentNeg2Procedure;
import net.mcreator.artinjustice.procedures.IfHasAlignmentNeg1Procedure;
import net.mcreator.artinjustice.procedures.IfHasAlignmentDefaultProcedure;
import net.mcreator.artinjustice.procedures.IfHasAlignment3Procedure;
import net.mcreator.artinjustice.procedures.IfHasAlignment2Procedure;
import net.mcreator.artinjustice.procedures.IfHasAlignment1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class AlignmentOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof InventoryScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level();
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (true) {
				if (IfHasAlignment1Procedure.execute(entity)) {
					event.getGuiGraphics().blit(new ResourceLocation("art5019injustice:textures/screens/alignment_pos_1.png"), w / 2 + 59, h / 2 + -79, 0, 0, 16, 16, 16, 16);
				}
				if (IfHasAlignment2Procedure.execute(entity)) {
					event.getGuiGraphics().blit(new ResourceLocation("art5019injustice:textures/screens/alignment_pos_2.png"), w / 2 + 59, h / 2 + -82, 0, 0, 16, 16, 16, 16);
				}
				if (IfHasAlignment3Procedure.execute(entity)) {
					event.getGuiGraphics().blit(new ResourceLocation("art5019injustice:textures/screens/alignment_pos_3.png"), w / 2 + 59, h / 2 + -82, 0, 0, 16, 16, 16, 16);
				}
				if (IfHasAlignmentNeg1Procedure.execute(entity)) {
					event.getGuiGraphics().blit(new ResourceLocation("art5019injustice:textures/screens/alignment_neg_1.png"), w / 2 + 59, h / 2 + -79, 0, 0, 16, 16, 16, 16);
				}
				if (IfHasAlignmentNeg3Procedure.execute(entity)) {
					event.getGuiGraphics().blit(new ResourceLocation("art5019injustice:textures/screens/aligment_neg_2.png"), w / 2 + 58, h / 2 + -80, 0, 0, 16, 16, 16, 16);
				}
				if (IfHasAlignmentDefaultProcedure.execute(entity)) {
					event.getGuiGraphics().blit(new ResourceLocation("art5019injustice:textures/screens/alignment_default.png"), w / 2 + 59, h / 2 + -79, 0, 0, 16, 16, 16, 16);
				}
				if (IfHasAlignmentNeg2Procedure.execute(entity)) {
					event.getGuiGraphics().blit(new ResourceLocation("art5019injustice:textures/screens/alignment_neg_3.png"), w / 2 + 59, h / 2 + -79, 0, 0, 16, 16, 16, 16);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
