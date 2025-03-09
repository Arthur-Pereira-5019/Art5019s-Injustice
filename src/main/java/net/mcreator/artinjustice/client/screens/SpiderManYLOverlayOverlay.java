
package net.mcreator.artinjustice.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.artinjustice.procedures.SpiderManTH2OverlayDisplayOverlayIngameProcedure;
import net.mcreator.artinjustice.procedures.ReturnWebShooterModeProcedure;
import net.mcreator.artinjustice.procedures.ReturnRemainingWebsProcedure;
import net.mcreator.artinjustice.procedures.ReturnNearbyEntitiesProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SpiderManYLOverlayOverlay {
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
		if (SpiderManTH2OverlayDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnNearbyEntitiesProcedure.execute(world, x, y, z, entity), 6, 6, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnWebShooterModeProcedure.execute(entity), 6, 17, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnRemainingWebsProcedure.execute(entity), 6, 28, -1, false);
		}
	}
}
