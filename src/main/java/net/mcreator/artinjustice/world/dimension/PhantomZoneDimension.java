
package net.mcreator.artinjustice.world.dimension;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.renderer.DimensionSpecialEffects;

import net.mcreator.artinjustice.procedures.PhantomZonePlayerLeavesDimensionProcedure;
import net.mcreator.artinjustice.procedures.PhantomZonePlayerEntersDimensionProcedure;

@Mod.EventBusSubscriber
public class PhantomZoneDimension {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class PhantomZoneSpecialEffectsHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(0.7764705882, 0, 1);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return true;
				}
			};
			event.register(new ResourceLocation("art5019injustice:phantom_zone"), customEffect);
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
		Entity entity = event.getEntity();
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if (event.getFrom() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("art5019injustice:phantom_zone"))) {
			PhantomZonePlayerLeavesDimensionProcedure.execute(entity);
		}
		if (event.getTo() == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("art5019injustice:phantom_zone"))) {
			PhantomZonePlayerEntersDimensionProcedure.execute(entity);
		}
	}
}
