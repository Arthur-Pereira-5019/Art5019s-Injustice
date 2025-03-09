
package net.mcreator.artinjustice.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.artinjustice.init.Art5019injusticeModFluids;
import net.mcreator.artinjustice.init.Art5019injusticeModFluidTypes;
import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

public abstract class LazarusPitWaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> Art5019injusticeModFluidTypes.LAZARUS_PIT_WATER_TYPE.get(), () -> Art5019injusticeModFluids.LAZARUS_PIT_WATER.get(),
			() -> Art5019injusticeModFluids.FLOWING_LAZARUS_PIT_WATER.get()).explosionResistance(100f).block(() -> (LiquidBlock) Art5019injusticeModBlocks.LAZARUS_PIT_WATER.get());

	private LazarusPitWaterFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LazarusPitWaterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LazarusPitWaterFluid {
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
