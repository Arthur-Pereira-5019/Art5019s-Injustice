
package net.mcreator.artinjustice.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.artinjustice.procedures.XRayVisionDisplayOverlayIngameProcedure;
import net.mcreator.artinjustice.procedures.HomelanderReturnTypeProcedure;
import net.mcreator.artinjustice.procedures.HomelanderReturnSpecialBlocksProcedure;
import net.mcreator.artinjustice.procedures.HomelanderReturnHealthProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class XRayVisionOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
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
		if (XRayVisionDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("art5019injustice:textures/screens/filter_gray.png"), 0, 0, 0, 0, w, h, w, h);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					HomelanderReturnHealthProcedure.execute(world, entity), w / 2 + -41, h / 2 + -44, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					HomelanderReturnTypeProcedure.execute(world, entity), w / 2 + -41, h / 2 + -31, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					HomelanderReturnSpecialBlocksProcedure.execute(world, entity), w / 2 + -41, h / 2 + -18, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
