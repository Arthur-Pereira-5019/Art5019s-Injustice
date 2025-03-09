package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

import java.util.List;
import java.util.Comparator;

public class GoldenKryptoniteItemInIventoryTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get(),
								(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
										? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getDuration()
										: 0) + 3),
								entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
										? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getAmplifier()
										: 0,
								false, false));
				} else {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get(), 200, 0, false, false));
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get(),
								(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
										? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getDuration()
										: 0) + 3),
								entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
										? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getAmplifier()
										: 0,
								false, false));
				} else {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get(), 100, 0, false, false));
				}
			}
		}
	}
}
