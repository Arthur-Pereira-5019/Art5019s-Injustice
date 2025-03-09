package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class SpaceStoneItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("mode") == 3) {
			if (itemstack.getOrCreateTag().getDouble("cadency") == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4, false, true));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0, false, true));
				if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(Art5019injusticeModMobEffects.RADIATION.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.RADIATION.get(), 100, 1, false, true));
				}
			}
		}
		if (itemstack.getOrCreateTag().getDouble("cadency") >= 1) {
			itemstack.getOrCreateTag().putDouble("cadency", (itemstack.getOrCreateTag().getDouble("cadency") - 1));
		}
	}
}
