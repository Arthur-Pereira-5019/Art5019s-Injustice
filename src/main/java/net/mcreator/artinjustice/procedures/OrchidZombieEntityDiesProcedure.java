package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;
import net.mcreator.artinjustice.entity.OrchidZombieEntity;

public class OrchidZombieEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double id = 0;
		id = entity instanceof OrchidZombieEntity _datEntI ? _datEntI.getEntityData().get(OrchidZombieEntity.DATA_orchidcolor) : 0;
		if (Math.random() < 0.3) {
			if (id != 1) {
				if (world.isEmptyBlock(BlockPos.containing(x, y, z)) && Art5019injusticeModBlocks.WINE_ORCHID.get().defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z))) {
					if (id == 8) {
						world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.STARRY_ORCHID.get().defaultBlockState(), 3);
					} else if (id == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.WINE_ORCHID.get().defaultBlockState(), 3);
					} else if (id == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.YELLOW_CATTLEYA.get().defaultBlockState(), 3);
					} else if (id == 4) {
						world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.WHITE_ORCHID.get().defaultBlockState(), 3);
					} else if (id == 5) {
						world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.LILAC_CATTLEYA.get().defaultBlockState(), 3);
					} else if (id == 6) {
						world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.PURPLE_ORCHID.get().defaultBlockState(), 3);
					} else if (id == 7) {
						world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.RAINBOW_ORCHID.get().defaultBlockState(), 3);
					}
				} else {
					if (id == 8) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(Art5019injusticeModBlocks.STARRY_ORCHID.get())));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (id == 2) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(Art5019injusticeModBlocks.WINE_ORCHID.get())));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (id == 3) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(Art5019injusticeModBlocks.YELLOW_CATTLEYA.get())));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (id == 4) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(Art5019injusticeModBlocks.WHITE_ORCHID.get())));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (id == 5) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(Art5019injusticeModBlocks.LILAC_CATTLEYA.get())));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (id == 6) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(Art5019injusticeModBlocks.PURPLE_ORCHID.get())));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (id == 7) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(Art5019injusticeModBlocks.RAINBOW_ORCHID.get())));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			} else {
				if (Blocks.BLUE_ORCHID.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z))) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.BLUE_ORCHID.defaultBlockState(), 3);
				} else {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(Blocks.BLUE_ORCHID)));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
