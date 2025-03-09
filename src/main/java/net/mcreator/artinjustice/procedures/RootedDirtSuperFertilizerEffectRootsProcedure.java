package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

import java.util.List;
import java.util.Comparator;

public class RootedDirtSuperFertilizerEffectRootsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double d = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).targetid).equals(entityiterator.getStringUUID())) {
					sx = -1;
					for (int index0 = 0; index0 < 2; index0++) {
						sy = -2;
						for (int index1 = 0; index1 < 4; index1++) {
							sz = -1;
							for (int index2 = 0; index2 < 2; index2++) {
								if ((world.getBlockState(BlockPos.containing(entityiterator.getX() + sx, entity.getY() + sy, entityiterator.getZ() + sz))).is(BlockTags.create(new ResourceLocation("minecraft:lush_ground_replaceable")))) {
									if (Math.random() < 0.3) {
										{
											BlockPos _pos = BlockPos.containing(entityiterator.getX() + sx, entity.getY() + sy + 1, entityiterator.getZ() + sz);
											Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
											world.destroyBlock(_pos, false);
										}
										world.setBlock(BlockPos.containing(entityiterator.getX() + sx, entity.getY() + sy + 1, entityiterator.getZ() + sz), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
									}
								} else if (!world.getBlockState(BlockPos.containing(entityiterator.getX() + sx, entity.getY() + sy + 1, entityiterator.getZ() + sz)).canOcclude()) {
									if (Math.random() < 0.35) {
										world.setBlock(BlockPos.containing(entityiterator.getX() + sx, entity.getY() + sy + 1, entityiterator.getZ() + sz), Blocks.ROOTED_DIRT.defaultBlockState(), 3);
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
				}
			}
		}
	}
}
