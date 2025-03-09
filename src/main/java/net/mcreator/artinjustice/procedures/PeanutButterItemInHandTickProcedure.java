package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

import java.util.List;
import java.util.Comparator;

public class PeanutButterItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
						&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_supes_peanut_butter"))).isDone()) {
					if (Math.random() < 0.01) {
						if (!(entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()))
								|| (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0) == 0) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ALLERGY.get(), 1200, 1, false, false));
						}
					}
				}
			}
		}
	}
}
