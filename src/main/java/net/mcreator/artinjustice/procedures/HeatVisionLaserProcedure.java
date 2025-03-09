package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

import java.util.List;
import java.util.Comparator;

public class HeatVisionLaserProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double power) {
		if (entity == null)
			return;
		double Scaling = 0;
		double lx = 0;
		double ly = 0;
		double lz = 0;
		if (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.TEMP_LIGHT_BLOCK.get().defaultBlockState(), 3);
		}
		for (int index0 = 0; index0 < (int) (power * 12); index0++) {
			lx = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
			ly = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			lz = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
			if ((world.getBlockState(BlockPos.containing(lx, ly, lz))).is(BlockTags.create(new ResourceLocation("art5019injustice:laser_ignore")))) {
				Scaling = Scaling + 1;
			} else if (world.getBlockState(BlockPos.containing(lx, ly, lz)).getDestroySpeed(world, BlockPos.containing(lx, ly, lz)) <= Math.random() * 0.4 * power
					&& world.getBlockState(BlockPos.containing(lx, ly, lz)).getDestroySpeed(world, BlockPos.containing(lx, ly, lz)) >= 0) {
				if (!world.isClientSide()) {
					{
						BlockPos _pos = BlockPos.containing(lx, ly, lz);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(lx, ly, lz), null);
						world.destroyBlock(_pos, false);
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(lx, ly, lz), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~ ~-1 ~ ~ ~1 ~ fire replace #forge:any_air");
				break;
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(lx, ly, lz), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 1.000 0.000 0.000 1 ~ ~ ~ 0.3 0.3 0.3 3 3 normal");
			{
				final Vec3 _center = new Vec3(lx, ly, lz);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (entityiterator instanceof ItemEntity) {
							if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getRarity() == Rarity.COMMON) {
								if (Math.random() < 0.7) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LAVA)), (float) (power / 2));
								}
								entityiterator.setSecondsOnFire((int) (power * 1.5));
							}
						} else {
							if (Math.random() < 0.7) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LAVA)), (float) (power / 2));
							}
							entityiterator.setSecondsOnFire((int) (power * 1.5));
						}
					}
				}
			}
		}
	}
}
