package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class MeningitisOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		double lethality = 0;
		lethality = amplifier;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.AIDS.get())) {
			lethality = lethality + 2;
		}
		if (Math.random() < 0.5) {
			if (Math.random() < 0.05) {
				if (Math.random() < 0.5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), (int) (300 + 300 * lethality), 1, false, false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.DEAFNESS.get(), (int) (300 + 300 * lethality), 1, false, false));
				}
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:virulence")))),
						(float) (2 + lethality * 3));
			} else {
				if (Math.random() < 0.5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, (int) (200 + 200 * lethality), 0, false, false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, (int) (lethality * 2), false, false));
				}
			}
		} else {
			if (Math.random() < 0.5) {
				if (Math.random() < 0.5) {
					entity.setSecondsOnFire((int) (20 + 7 * lethality));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FALLING_WATER, x, y, z, 20, 0.4, 1, 0.4, 0.4);
				} else {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:virulence")))),
							(float) (3 + lethality * 3));
				}
			} else {
				if (Math.random() < 0.5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, (int) (lethality + lethality), false, false));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FALLING_WATER, x, y, z, 20, 0.4, 1, 0.4, 0.4);
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, (int) lethality, false, false));
				}
			}
		}
		if (Math.random() < 0.0001) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.MENINGITIS.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.MENINGITIS.get()).getAmplifier() : 0) < 3) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.MENINGITIS.get(), 48000,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.MENINGITIS.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.MENINGITIS.get()).getAmplifier() : 0) + 1), false,
							false));
			}
		}
		{
			Entity _ent = entity;
			_ent.setYRot(Mth.nextInt(RandomSource.create(), -180, 180));
			_ent.setXRot(Mth.nextInt(RandomSource.create(), -90, 90));
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
	}
}
