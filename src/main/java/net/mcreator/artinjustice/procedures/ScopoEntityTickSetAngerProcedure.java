package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.entity.ScopoEntity;

import java.util.List;
import java.util.Comparator;

public class ScopoEntityTickSetAngerProcedure {
	public static void execute(LevelAccessor world, Entity rcplr, double scal) {
		if (rcplr == null)
			return;
		double Scaling = 0;
		Entity rcplrs = null;
		{
			final Vec3 _center = new Vec3(
					(rcplr.level().clip(new ClipContext(rcplr.getEyePosition(1f), rcplr.getEyePosition(1f).add(rcplr.getViewVector(1f).scale(scal)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, rcplr)).getBlockPos().getX()),
					(rcplr.level().clip(new ClipContext(rcplr.getEyePosition(1f), rcplr.getEyePosition(1f).add(rcplr.getViewVector(1f).scale(scal)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, rcplr)).getBlockPos().getY()),
					(rcplr.level().clip(new ClipContext(rcplr.getEyePosition(1f), rcplr.getEyePosition(1f).add(rcplr.getViewVector(1f).scale(scal)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, rcplr)).getBlockPos().getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof ScopoEntity) {
					if (rcplr instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0, false, false));
				}
			}
		}
	}
}
