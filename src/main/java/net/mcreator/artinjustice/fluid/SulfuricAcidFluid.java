
package net.mcreator.artinjustice.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.artinjustice.init.Art5019injusticeModFluids;
import net.mcreator.artinjustice.init.Art5019injusticeModFluidTypes;
import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

public abstract class SulfuricAcidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> Art5019injusticeModFluidTypes.SULFURIC_ACID_TYPE.get(), () -> Art5019injusticeModFluids.SULFURIC_ACID.get(),
			() -> Art5019injusticeModFluids.FLOWING_SULFURIC_ACID.get()).explosionResistance(100f).levelDecreasePerBlock(3).slopeFindDistance(3).block(() -> (LiquidBlock) Art5019injusticeModBlocks.SULFURIC_ACID.get());

	private SulfuricAcidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

	public static class Source extends SulfuricAcidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SulfuricAcidFluid {
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
