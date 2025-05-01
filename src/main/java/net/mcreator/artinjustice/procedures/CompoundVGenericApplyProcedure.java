package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class CompoundVGenericApplyProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack, double quality) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 0) {
				if (Math.random() < 0.3 * quality) {
					if (Math.random() < 0.7) {
						if (Math.random() < 0.1 * quality) {
							BecomeHomelanderProcedure.execute(entity);
						} else {
							BecomeATrainProcedure.execute(entity);
						}
					} else {
						BecomeDefaultSuperProcedure.execute(entity);
					}
				} else {
					if (Math.random() < 0.1 * quality) {
						BecomeDefaultSuperProcedure.execute(entity);
					} else {
						BecomeTranslucentProcedure.execute(entity);
					}
				}
			} else {
				if (Math.random() < 0.3) {
					if (Math.random() < 0.3) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) (12000 * quality), 2, false, false));
					} else {
						if (Math.random() < 0.3) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) (12000 * quality), 2, false, false));
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, (int) (12000 * quality), 3, false, false));
						}
					}
				} else {
					if (Math.random() < 0.3) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) (12000 * quality), 2, false, false));
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, (int) (12000 * quality), 2, false, false));
					}
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = itemstack;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.EMPTY_SYRINGE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
