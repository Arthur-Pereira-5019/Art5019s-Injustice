package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class HammerGenericRayCastProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double Scaling = 0;
		double lx = 0;
		double lz = 0;
		double ly = 0;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			for (int index0 = 0; index0 < 12; index0++) {
				lx = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
				ly = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
				lz = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
				if ((world.getBlockState(BlockPos.containing(lx, ly, lz))).getBlock() == Blocks.ANVIL) {
					{
						final Vec3 _center = new Vec3(lx, (ly + 1), lz);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof ItemEntity) {
								SuperAnvilForgingProcedure.execute(world, lx, ly, lz, entity, entityiterator, itemstack);
							}
						}
					}
				} else if (!world.getBlockState(BlockPos.containing(lx, ly, lz)).canOcclude()) {
					Scaling = Scaling + 0.7;
				} else {
					break;
				}
			}
		}
	}
}
