package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class HomelanderReturnSpecialBlocksProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		double Scaling = 0;
		Entity target = null;
		BlockState interest = Blocks.AIR.defaultBlockState();
		for (int index0 = 0; index0 < 34; index0++) {
			interest = (world.getBlockState(BlockPos.containing(entity.getX() + entity.getLookAngle().x * Scaling, entity.getY() + 1.65 + entity.getLookAngle().y * Scaling, entity.getZ() + entity.getLookAngle().z * Scaling)));
			if (interest.is(BlockTags.create(new ResourceLocation("art5019injustice:xray_interests")))) {
				return "Interests: " + (new ItemStack(interest.getBlock())).getDisplayName().getString();
			} else {
				Scaling = Scaling + 0.9;
			}
		}
		return " ";
	}
}
