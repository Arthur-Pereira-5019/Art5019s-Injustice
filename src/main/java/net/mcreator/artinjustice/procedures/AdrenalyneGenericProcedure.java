package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class AdrenalyneGenericProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack, double adrenampfac, double adrentimfac) {
		if (entity == null)
			return;
		boolean worked = false;
		double rest = 0;
		double amp = 0;
		double timefactor = 0;
		double ampfactor = 0;
		worked = true;
		timefactor = adrentimfac;
		ampfactor = adrenampfac;
		if (timefactor == 0) {
			timefactor = 1;
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).toxicRes != 0) {
			timefactor = 1 / (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).toxicRes;
		}
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.FEAR.get())) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(),
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FEAR.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FEAR.get()).getDuration() : 0) + 600 * timefactor),
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FEAR.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FEAR.get()).getAmplifier() : 0) + ampfactor + 1), false, false));
		} else if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get())) {
			rest = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getDuration() : 0;
			amp = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0;
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(Art5019injusticeModMobEffects.ALLERGY.get());
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ALLERGY.get(),
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getDuration() : 0) - 600 * timefactor),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0, false, false));
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid != 13) {
			if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(Art5019injusticeModMobEffects.RAGE.get())) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.RAGE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.RAGE.get()).getAmplifier() : 0) < 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.RAGE.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.RAGE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.RAGE.get()).getDuration() : 0) + 600 * timefactor),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.RAGE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.RAGE.get()).getAmplifier() : 0) + ampfactor + 1), false,
								false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) (300 * timefactor), (int) (ampfactor + 1), false, false));
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.RAGE.get(), (int) (600 * timefactor), (int) ampfactor, false, false));
			}
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.WITHER)),
					(float) ((ampfactor + 1) * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.RAGE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.RAGE.get()).getAmplifier() : 0)));
		} else {
			if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get())) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0) < 6) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.IMPULSE.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getDuration() : 0) + 600),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0) + ampfactor + 1),
								false, false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, (int) ampfactor, false, false));
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.IMPULSE.get(), 600, (int) ampfactor, false, false));
			}
		}
		if (worked) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.EMPTY_SYRINGE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = itemstack;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
