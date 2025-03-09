package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class TacticalKnifesGenericAttackProcedure {
	public static boolean execute(Entity entity, double amount, double distance, double type) {
		if (entity == null)
			return false;
		double random = 0;
		double probs = 0;
		double extrat = 0;
		if (distance >= 1.5) {
			return false;
		} else if (distance <= 1) {
			if (amount >= 5) {
				if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
						&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:blade_mastery"))).isDone()) {
					extrat = 80;
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.BLEEDING.get(),
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.BLEEDING.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.BLEEDING.get()).getDuration() : 0) + 100 + extrat), 1,
							false, false));
				if (type == 1) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get())
										? _livEnt.getEffect(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get()).getDuration()
										: 0) + 120 + extrat),
								1, false, false));
				} else if (type == 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
										? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getDuration()
										: 0) + 120),
								1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get(), 80, 0, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(), 120, 0, false, false));
				}
			}
		}
		return true;
	}
}
