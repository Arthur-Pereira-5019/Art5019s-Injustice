package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class VenomTierProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double boost = 0;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) <= 3
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.WEBBED.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.WEBBED.get()).getDuration() : 0) <= 900) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration() : 0) + (boost + 80) - ReturnStrengthProcedure.execute(entity)),
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) + 1), false, false));
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) <= 3) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.WEBBED.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.WEBBED.get()).getDuration() : 0) <= 900) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getDuration() : 0) + (boost + 80) - ReturnStrengthProcedure.execute(entity)),
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1), false, false));
			}
		} else {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.WEBBED.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.WEBBED.get()).getDuration() : 0) <= 900) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.WEBBED.get(),
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.WEBBED.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.WEBBED.get()).getDuration() : 0) + (boost + 80)
									- ReturnStrengthProcedure.execute(entity)),
							1, false, false));
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"particle block coal_block ~ ~ ~ 1 1 1 1 35 normal");
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
