package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class OrchidZombieEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		if (damagesource.is(DamageTypes.IN_FIRE)) {
			Art5019injusticeMod.queueServerWork(1, () -> {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_FIRE)), 3);
			});
		}
		if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:bleeding_damage")))) {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.MOSS_BLOCK.defaultBlockState()));
		}
	}
}
