
package net.mcreator.artinjustice.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModFluids;
import net.mcreator.artinjustice.init.Art5019injusticeModFluidTypes;
import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

public abstract class ContaminedWaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> Art5019injusticeModFluidTypes.CONTAMINED_WATER_TYPE.get(), () -> Art5019injusticeModFluids.CONTAMINED_WATER.get(),
			() -> Art5019injusticeModFluids.FLOWING_CONTAMINED_WATER.get()).explosionResistance(100f).slopeFindDistance(12).bucket(() -> Art5019injusticeModItems.CONTAMINED_WATER_BUCKET.get())
			.block(() -> (LiquidBlock) Art5019injusticeModBlocks.CONTAMINED_WATER.get());

	private ContaminedWaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

	public static class Source extends ContaminedWaterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends ContaminedWaterFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
