
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.artinjustice.fluid.types.SulfuricAcidFluidType;
import net.mcreator.artinjustice.fluid.types.LazarusPitWaterFluidType;
import net.mcreator.artinjustice.fluid.types.ContaminedWaterFluidType;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Art5019injusticeMod.MODID);
	public static final RegistryObject<FluidType> CONTAMINED_WATER_TYPE = REGISTRY.register("contamined_water", () -> new ContaminedWaterFluidType());
	public static final RegistryObject<FluidType> LAZARUS_PIT_WATER_TYPE = REGISTRY.register("lazarus_pit_water", () -> new LazarusPitWaterFluidType());
	public static final RegistryObject<FluidType> SULFURIC_ACID_TYPE = REGISTRY.register("sulfuric_acid", () -> new SulfuricAcidFluidType());
}
