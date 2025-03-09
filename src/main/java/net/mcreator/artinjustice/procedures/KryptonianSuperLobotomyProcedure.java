package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

import java.util.List;
import java.util.Comparator;

public class KryptonianSuperLobotomyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Scaling = 0;
		double lx = 0;
		double ly = 0;
		double lz = 0;
		if (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.TEMP_LIGHT_BLOCK.get().defaultBlockState(), 3);
		}
		for (int index0 = 0; index0 < 20; index0++) {
			lx = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
			ly = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			lz = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(Scaling)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
			if ((world.getBlockState(BlockPos.containing(lx, ly, lz))).is(BlockTags.create(new ResourceLocation("art5019injustice:laser_ignore")))) {
				Scaling = Scaling + 1;
			} else {
				break;
			}
			{
				final Vec3 _center = new Vec3(lx, ly, lz);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (!((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get())
								? _livEnt.getEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()).getDuration()
								: 0) >= 300)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get(),
										(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get())
												? _livEnt.getEffect(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get()).getDuration()
												: 0) + 5),
										1, false, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(),
										(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get())
												? _livEnt.getEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()).getDuration()
												: 0) + 3),
										1, false, false));
						}
					}
				}
			}
		}
	}
}
