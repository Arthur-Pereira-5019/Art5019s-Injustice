
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.artinjustice.fluid.SulfuricAcidFluid;
import net.mcreator.artinjustice.fluid.LazarusPitWaterFluid;
import net.mcreator.artinjustice.fluid.ContaminedWaterFluid;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, Art5019injusticeMod.MODID);
	public static final RegistryObject<FlowingFluid> CONTAMINED_WATER = REGISTRY.register("contamined_water", () -> new ContaminedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_CONTAMINED_WATER = REGISTRY.register("flowing_contamined_water", () -> new ContaminedWaterFluid.Flowing());
	public static final RegistryObject<FlowingFluid> LAZARUS_PIT_WATER = REGISTRY.register("lazarus_pit_water", () -> new LazarusPitWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_LAZARUS_PIT_WATER = REGISTRY.register("flowing_lazarus_pit_water", () -> new LazarusPitWaterFluid.Flowing());
	public static final RegistryObject<FlowingFluid> SULFURIC_ACID = REGISTRY.register("sulfuric_acid", () -> new SulfuricAcidFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_SULFURIC_ACID = REGISTRY.register("flowing_sulfuric_acid", () -> new SulfuricAcidFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(CONTAMINED_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CONTAMINED_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(LAZARUS_PIT_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LAZARUS_PIT_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(SULFURIC_ACID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_SULFURIC_ACID.get(), RenderType.translucent());
		}
	}
}
