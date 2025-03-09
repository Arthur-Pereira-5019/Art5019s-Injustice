package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;
import net.mcreator.artinjustice.entity.CriminalEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.ArrayList;

public class CriminalOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (Math.random() < Art5019injusticeModVariables.MapVariables.get(world).criminality_rate && TaskMasterNaturalEntitySpawningConditionProcedure.execute(world, x, y, z)) {
				if (entity instanceof CriminalEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CriminalEntity.DATA_gun, Mth.nextInt(RandomSource.create(), 0, 8));
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (entity instanceof CriminalEntity _datEntSetI)
						_datEntSetI.getEntityData().set(CriminalEntity.DATA_affiliation, 0);
					if ((entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
						if (Math.random() < 0.33) {
							if (entity instanceof CriminalEntity _datEntSetI)
								_datEntSetI.getEntityData().set(CriminalEntity.DATA_affiliation, 1);
						}
					}
					if (Art5019injusticeModVariables.MapVariables.get(world).event_id == 2) {
						if (Math.random() < Art5019injusticeModVariables.MapVariables.get(world).event_meter) {
							if (entity instanceof CriminalEntity _datEntSetI)
								_datEntSetI.getEntityData().set(CriminalEntity.DATA_affiliation, 2);
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Art5019injusticeModItems.INNER_DEMON_MASK_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Art5019injusticeModItems.INNER_DEMON_MASK_HELMET.get()));
								}
							}
							if (Math.random() < 0.3) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 99999, 0));
								if (Math.random() < 0.5) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 99999, 1));
								}
							}
							if (Math.random() < 0.3) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 99999, 0));
								if (Math.random() < 0.5) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 99999, 1));
								}
							}
							if (Math.random() < 0.3) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 99999, 0));
								if (Math.random() < 0.5) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 99999, 1));
								}
							}
							if (Math.random() < 0.3) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 99999, 0));
								if (Math.random() < 0.5) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 99999, 1));
								}
							}
							if (Math.random() < 0.3) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 99999, 0));
							}
						}
					}
					if ((entityiterator instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.POLICE_RADIO.get())) : false)
							|| (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("policeRadio")
							|| (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDERMAN_ENHANCED_SUIT_HELMET.get()) {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal(("New crime occurence in: X: " + new java.text.DecimalFormat("##").format(x) + " Y: " + new java.text.DecimalFormat("##").format(y) + " Z: " + new java.text.DecimalFormat("##").format(z))),
									false);
					}
				}
				if (entity instanceof CriminalEntity _datEntSetI)
					_datEntSetI.getEntityData().set(CriminalEntity.DATA_skin, Mth.nextInt(RandomSource.create(), 0, 4));
				if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_gun) : 0) == 1 || (entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_gun) : 0) == 0
						|| (entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_gun) : 0) == 2) {
					if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_affiliation) : 0) == 2) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.IRON_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Art5019injusticeModEnchantments.DARK_ENERGY.get(), Mth.nextInt(RandomSource.create(), 1, 2));
					} else if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_affiliation) : 0) == 1) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Art5019injusticeModItems.KRYPTONITE_KNIFE.get()).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Art5019injusticeModItems.TACTICAL_IRON_KNIFE.get()).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				} else if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_gun) : 0) == 3 || (entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_gun) : 0) == 4) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Art5019injusticeModItems.OLD_PISTOL.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_gun) : 0) == 5) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Art5019injusticeModItems.AK_47.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_gun) : 0) == 7) {
					if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_affiliation) : 0) == 1) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Art5019injusticeModItems.KRYPTONITE_GRENADE.get()).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_affiliation) : 0) == 2) {
						if (Math.random() < 0.3) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Art5019injusticeModItems.GRENADE.get()).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						} else {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Art5019injusticeModItems.FLASH_BANG_GRENADE.get()).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					} else {
						if (Math.random() < 0.2) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Art5019injusticeModItems.GRENADE.get()).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						} else {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Art5019injusticeModItems.LIGHT_MOLOTOV.get()).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				} else if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_gun) : 0) == 8) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Art5019injusticeModItems.WRENCH.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			} else {
				Art5019injusticeMod.queueServerWork(2, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
				});
			}
		}
	}
}
