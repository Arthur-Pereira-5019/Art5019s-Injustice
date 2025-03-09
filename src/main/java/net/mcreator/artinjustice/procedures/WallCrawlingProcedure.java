package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class WallCrawlingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		dx = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
		dy = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
		dz = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
		if (!((world.getBlockState(BlockPos.containing(dx, dy, dz))).getBlock() instanceof LiquidBlock) && !(world.getBlockState(BlockPos.containing(dx, dy, dz))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
				|| !((world.getBlockState(BlockPos.containing(dx, dy + 1, dz))).getBlock() instanceof LiquidBlock) && !(world.getBlockState(BlockPos.containing(dx, dy + 1, dz))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
				|| !((world.getBlockState(BlockPos.containing(dx, dy - 1, dz))).getBlock() instanceof LiquidBlock) && !(world.getBlockState(BlockPos.containing(dx, dy - 1, dz))).is(BlockTags.create(new ResourceLocation("forge:any_air")))) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.18, (entity.getDeltaMovement().z())));
		}
	}
}
