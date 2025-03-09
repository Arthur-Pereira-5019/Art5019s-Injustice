package net.mcreator.artinjustice.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.ScarecrowIEntity;
import net.mcreator.artinjustice.entity.RedSkullEntity;
import net.mcreator.artinjustice.entity.LokiBossEntity;
import net.mcreator.artinjustice.entity.DeathstrokeEntity;
import net.mcreator.artinjustice.entity.BlietzKriegEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class PlayerKillsEntityProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double cruelty = 0;
		double parsealignment = 0;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:leather_animals")))) {
			if (sourceentity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("art5019injustice:black_fabric_recipe")});
			if (sourceentity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("art5019injustice:fabric_lime_recipe")});
			if (sourceentity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("art5019injustice:blue_fabric_recipe")});
			if (sourceentity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("art5019injustice:red_fabric_recipe")});
			if (sourceentity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("art5019injustice:fabric_white_recipe")});
			if (sourceentity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("art5019injustice:fabric_gray_recipe")});
			if (sourceentity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("art5019injustice:fabric_brown_recipe")});
			if (sourceentity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("art5019injustice:fabric_green_recipe")});
		}
		if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(Art5019injusticeModMobEffects.COMPOUND_V_MOB.get())) {
			for (int index0 = 0; index0 < (int) Math.floor(entity.getBbWidth() * entity.getBbHeight()); index0++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Art5019injusticeModItems.SUPE_REMAINS.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (IsIllProcedure.execute(entity)) {
			for (int index1 = 0; index1 < (int) Math.floor(entity.getBbWidth() * entity.getBbHeight()); index1++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Art5019injusticeModItems.CONTAMINED_HUMAN_REMAINS.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:humans")))) {
			for (int index2 = 0; index2 < (int) Math.floor(entity.getBbWidth() * entity.getBbHeight()); index2++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Art5019injusticeModItems.HUMAN_REMAINS.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		cruelty = 1;
		if (entity instanceof LivingEntity _livEnt20 && _livEnt20.isBaby()) {
			cruelty = 2;
		}
		if (entity.isOnFire()) {
			cruelty = cruelty + 1.5;
		}
		if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MobEffects.POISON)) {
			cruelty = cruelty + 0.5;
		}
		if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(Art5019injusticeModMobEffects.FEAR.get()) || entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(MobEffects.BLINDNESS)) {
			cruelty = cruelty + 1.5;
		}
		if (entity.getAirSupply() < 10) {
			cruelty = cruelty + 0.5;
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:alignment_minus_one")))) {
			parsealignment = (-1) * cruelty;
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:alignment_plus_five")))) {
			parsealignment = 5;
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:alignment_plus_one")))) {
			parsealignment = 1;
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:alignment_plus_twenty_five")))) {
			parsealignment = 25;
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:alignment_minus_ten")))) {
			parsealignment = (-10) * cruelty;
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:alignment_minus_twenty_five")))) {
			parsealignment = (-25) * cruelty;
		}
		AlignmentUpdateProcedure.execute(world, x, y, z, entity, sourceentity, parsealignment);
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:npc_entities")))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:npc_entities")))) {
						if (Math.random() < 0.3) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), 3600, 0, false, false));
						}
						if (((Entity) world.getEntitiesOfClass(IronGolem.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.DEADPOOL_SUIT_LEGGINGS.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.DEADPOOL_SUIT_BOOTS.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.DEADPOOL_SUIT_HELMET.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.DEADPOOL_SUIT_CHESTPLATE.get()
				&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 7) {
			if (Math.random() < 0.1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.POISON_IVY_BODY_SUIT_LEGGINGS.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.POISON_IVY_BODY_SUIT_CHESTPLATE.get()
				&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 22) {
			if (Math.random() < 0.3) {
				if (world instanceof Level _level) {
					BlockPos _bp = BlockPos.containing(x, y - 1, z);
					if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
						if (!_level.isClientSide())
							_level.levelEvent(2005, _bp, 0);
					}
				}
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:enemies_of_the_nation")))) {
			if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_BRITAN_BOOTS.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_BRITAN_LEGGINGS.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_BRITAN_CHESTPLATE.get()) {
				if (world instanceof ServerLevel _level)
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 1));
			}
			if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_AMERICA_FIRST_SUIT_BOOTS.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_AMERICA_FIRST_SUIT_LEGGINGS.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_AMERICA_FIRST_SUIT_CHESTPLATE.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_AMERICA_FIRST_SUIT_HELMET.get()) {
				if (sourceentity instanceof LivingEntity _livEnt68 && _livEnt68.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,
								(int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HERO_OF_THE_VILLAGE) ? _livEnt.getEffect(MobEffects.HERO_OF_THE_VILLAGE).getDuration() : 0) + 300),
								sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HERO_OF_THE_VILLAGE) ? _livEnt.getEffect(MobEffects.HERO_OF_THE_VILLAGE).getAmplifier() : 0, false, false));
				} else {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 300, 0, false, false));
				}
			}
		}
		if (entity instanceof WitherBoss) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid < 3) {
				if (Math.random() < 0.5) {
					if (!(sourceentity instanceof ServerPlayer _plr74 && _plr74.level() instanceof ServerLevel
							&& _plr74.getAdvancements().getOrStartProgress(_plr74.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_responsabilities"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_responsabilities"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr76 && _plr76.level() instanceof ServerLevel
								&& _plr76.getAdvancements().getOrStartProgress(_plr76.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_organic_web"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_organic_web"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				} else {
					if (!(sourceentity instanceof ServerPlayer _plr78 && _plr78.level() instanceof ServerLevel
							&& _plr78.getAdvancements().getOrStartProgress(_plr78.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_organic_web"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_organic_web"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr80 && _plr80.level() instanceof ServerLevel
								&& _plr80.getAdvancements().getOrStartProgress(_plr80.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_responsabilities"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_responsabilities"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			}
		} else if (entity instanceof EnderDragon) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid < 3) {
				if (Math.random() < 0.5) {
					if (!(sourceentity instanceof ServerPlayer _plr83 && _plr83.level() instanceof ServerLevel
							&& _plr83.getAdvancements().getOrStartProgress(_plr83.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_acrobatics"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_acrobatics"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr85 && _plr85.level() instanceof ServerLevel
								&& _plr85.getAdvancements().getOrStartProgress(_plr85.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_friendly_neighborhood"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_friendly_neighborhood"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				} else {
					if (!(sourceentity instanceof ServerPlayer _plr87 && _plr87.level() instanceof ServerLevel
							&& _plr87.getAdvancements().getOrStartProgress(_plr87.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_friendly_neighborhood"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_friendly_neighborhood"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr89 && _plr89.level() instanceof ServerLevel
								&& _plr89.getAdvancements().getOrStartProgress(_plr89.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_acrobatics"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_acrobatics"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			}
		} else if (entity instanceof BlietzKriegEntity) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid < 3) {
				if (Math.random() < 0.5) {
					if (!(sourceentity instanceof ServerPlayer _plr92 && _plr92.level() instanceof ServerLevel
							&& _plr92.getAdvancements().getOrStartProgress(_plr92.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_electrical_touch"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_electrical_touch"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr94 && _plr94.level() instanceof ServerLevel
								&& _plr94.getAdvancements().getOrStartProgress(_plr94.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				} else {
					if (!(sourceentity instanceof ServerPlayer _plr96 && _plr96.level() instanceof ServerLevel
							&& _plr96.getAdvancements().getOrStartProgress(_plr96.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr98 && _plr98.level() instanceof ServerLevel
								&& _plr98.getAdvancements().getOrStartProgress(_plr98.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_electrical_touch"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_electrical_touch"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			}
		} else if (entity instanceof RedSkullEntity) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid < 3) {
				if (Math.random() < 0.5) {
					if (!(sourceentity instanceof ServerPlayer _plr101 && _plr101.level() instanceof ServerLevel
							&& _plr101.getAdvancements().getOrStartProgress(_plr101.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_spiderverse"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_spiderverse"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr103 && _plr103.level() instanceof ServerLevel
								&& _plr103.getAdvancements().getOrStartProgress(_plr103.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_science"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_science"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				} else {
					if (!(sourceentity instanceof ServerPlayer _plr105 && _plr105.level() instanceof ServerLevel
							&& _plr105.getAdvancements().getOrStartProgress(_plr105.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_science"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_science"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr107 && _plr107.level() instanceof ServerLevel
								&& _plr107.getAdvancements().getOrStartProgress(_plr107.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_spiderverse"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_spiderverse"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			}
		} else if (entity instanceof LokiBossEntity) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid < 3) {
				if (Math.random() < 0.5) {
					if (!(sourceentity instanceof ServerPlayer _plr110 && _plr110.level() instanceof ServerLevel
							&& _plr110.getAdvancements().getOrStartProgress(_plr110.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr112 && _plr112.level() instanceof ServerLevel
								&& _plr112.getAdvancements().getOrStartProgress(_plr112.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_man_great_responsabilities"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_responsabilities"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				} else {
					if (!(sourceentity instanceof ServerPlayer _plr114 && _plr114.level() instanceof ServerLevel
							&& _plr114.getAdvancements().getOrStartProgress(_plr114.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_responsabilities"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_responsabilities"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						{
							double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.powerlvl = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else {
						if (!(sourceentity instanceof ServerPlayer _plr116 && _plr116.level() instanceof ServerLevel
								&& _plr116.getAdvancements().getOrStartProgress(_plr116.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
							{
								double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
								sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.powerlvl = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			}
		} else if (entity instanceof ScarecrowIEntity) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid < 3) {
				if (Math.random() < 0.5 && !(sourceentity instanceof ServerPlayer _plr119 && _plr119.level() instanceof ServerLevel
						&& _plr119.getAdvancements().getOrStartProgress(_plr119.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_science"))).isDone())) {
					if (sourceentity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_science"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					{
						double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.powerlvl = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
		} else if (entity instanceof DeathstrokeEntity) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid < 3) {
				if (Math.random() < 0.5 && !(sourceentity instanceof ServerPlayer _plr122 && _plr122.level() instanceof ServerLevel
						&& _plr122.getAdvancements().getOrStartProgress(_plr122.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"))).isDone())) {
					if (sourceentity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_stronger_sense"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					{
						double _setval = 1 + (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.powerlvl = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
		}
	}
}
