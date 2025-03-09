package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;
import net.mcreator.artinjustice.entity.TheNightmareEntity;
import net.mcreator.artinjustice.entity.TheNightmareCloneEntity;
import net.mcreator.artinjustice.entity.SpecialSpiderEntity;
import net.mcreator.artinjustice.entity.AtlanteanZombieEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class BeforeEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		double random = 0;
		double probs = 0;
		double poisonTick = 0;
		double poisonAmplifier = 0;
		double distance = 0;
		double typecall = 0;
		{
			String _setval = entity.getStringUUID();
			sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.targetid = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		random = Math.random();
		distance = DistanceFinderProcedure.execute(sourceentity, entity);
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1
				|| (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 12) {
			if (SpidermanIsHurtProcedure.execute(world, x, y, z, entity, sourceentity)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 0) {
			if (sourceentity instanceof SpecialSpiderEntity) {
				if (random <= 0.1) {
					BecomeSpiderManProcedure.execute(entity);
				} else if (random <= 0.4) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.setHealth(0);
				}
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 9) {
			if (random < 0.2) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
			if (damagesource.is(DamageTypes.LIGHTNING_BOLT)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
			if (random <= 0.07 * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FORTUNE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FORTUNE.get()).getAmplifier() : 0)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.HAZARD.get(),
							(int) (200 * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FORTUNE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FORTUNE.get()).getAmplifier() : 0)),
							(int) (0 * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FORTUNE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FORTUNE.get()).getAmplifier() : 0)), false, true));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 3) {
			if (!(entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability1_toggle) {
				Ability1BlueBeetleJrProcedure.execute(world, x, y, z, entity);
			} else {
				if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4cooldown == 0) {
					SelfDefenseExplosionProcedure.execute(world, x, y, z, entity);
				}
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 5) {
			if (!(entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability1_toggle) {
				Ability1BlueBeetleDgProcedure.execute(world, x, y, z, entity);
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 10) {
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).suitid == 3
					&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getMaxDamage()
							- (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getDamageValue() <= 12
							|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getMaxDamage()
									- (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getDamageValue() <= 17
							|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getMaxDamage()
									- (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getDamageValue() <= 16
							|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getMaxDamage()
									- (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getDamageValue() <= 14)) {
				IronManMarkIIIForcedSuitOffProcedure.execute(world, x, y, z, entity);
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 22) {
			if (damagesource.is(DamageTypes.ON_FIRE) || damagesource.is(DamageTypes.IN_FIRE)) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_FIRE)), 3);
			}
		}
		if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 4 && damagesource.is(DamageTypes.PLAYER_ATTACK)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(),
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FEAR.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FEAR.get()).getDuration() : 0) + 240), 1, false, true));
		} else if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 13 && damagesource.is(DamageTypes.PLAYER_ATTACK)) {
			if (sourceentity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(Art5019injusticeModMobEffects.AWOKEN.get())) {
				NeuroUltimateAttackProcedure.execute(world, x, y, z, entity, sourceentity);
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.BANE_NOLAN_HELMET.get()) {
			HurtBaneNolanMaskProcedure.execute(entity);
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:fearentities"))) && !(entity instanceof TheNightmareCloneEntity || entity instanceof TheNightmareEntity)
				&& !(sourceentity instanceof LivingEntity _livEnt39 && _livEnt39.hasEffect(Art5019injusticeModMobEffects.FEAR.get()))) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:humans")))) {
			HumanIsHitProcedure.execute(world, x, y, z, entity, sourceentity);
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(Art5019injusticeModEnchantments.SANDMAN_SPRINKLING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(),
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FEAR.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FEAR.get()).getDuration() : 0)
								+ 120 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(Art5019injusticeModEnchantments.SANDMAN_SPRINKLING.get())),
						0, false, false));
		}
		if (IsSymbioteWeakToSoundProcedure.execute(entity) && damagesource.is(DamageTypes.SONIC_BOOM)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("A"), false);
			VenomSoundWeaknessProcedure.execute(world, x, y, z, entity);
		}
		if (13 == (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid) {
			if (5 > (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl
					&& 0 == (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability2cooldown) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), 6000, 0, false, false));
				{
					double _setval = 42000;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ability2cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((!(entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()))
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0) < 6)
					&& (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4cooldown == 0) {
				if (Math.random() < 0.2) {
					if (entity instanceof LivingEntity _livEnt52 && _livEnt52.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get())) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.IMPULSE.get(), 2400,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0) + 1), false,
									false));
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.IMPULSE.get(), 2400,
									entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0, false, false));
					}
				}
			} else if (6 == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0)) {
				{
					double _setval = 12000;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ability4cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (17 == (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid) {
			if ((!(entity instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()))
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0) < 6)
					&& (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability2cooldown == 0) {
				if (Math.random() < 0.2) {
					if (entity instanceof LivingEntity _livEnt60 && _livEnt60.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get())) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.IMPULSE.get(), 1800,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0) + 1), false,
									false));
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.IMPULSE.get(), 1800,
									entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0, false, false));
					}
				}
			} else if (6 == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMPULSE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMPULSE.get()).getAmplifier() : 0)) {
				{
					double _setval = 9600;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ability2cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.BLACK_PANTHER_SUIT_2_HELMET.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble("kinecticenergy") <= 100) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble("kinecticenergy",
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble("kinecticenergy") + amount / 4));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.BLACK_PANTHER_SUIT_2_CHESTPLATE.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("kinecticenergy") <= 100) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().putDouble("kinecticenergy",
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("kinecticenergy") + amount / 4));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.BLACK_PANTHER_SUIT_2_LEGGINGS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("kinecticenergy") <= 100) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().putDouble("kinecticenergy",
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("kinecticenergy") + amount / 4));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.BLACK_PANTHER_SUIT_2_BOOTS.get()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().getDouble("kinecticenergy") <= 100) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().putDouble("kinecticenergy",
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().getDouble("kinecticenergy") + amount / 4));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(Art5019injusticeModEnchantments.ROYALTY.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
						new AABB(_center, _center).inflate((11 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(Art5019injusticeModEnchantments.ROYALTY.get())) / 2d), e -> true)
						.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Drowned || entityiterator instanceof AtlanteanZombieEntity) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 30, 1, 1, 1, 1);
						if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			}
		} else if (EnchantmentHelper.getItemEnchantmentLevel(Art5019injusticeModEnchantments.OCEANIC_MAGIC.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& !(sourceentity instanceof LivingEntity _livEnt112 && _livEnt112.hasEffect(MobEffects.REGENERATION))) {
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
						(int) (120 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(Art5019injusticeModEnchantments.OCEANIC_MAGIC.get())), 0));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.IRON_SPIDER_TH_CHESTPLATE.get()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (sourceentity == entityiterator) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("instaKill")) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.NEUTRAL, 1, (float) 1.4);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.NEUTRAL, 1, (float) 1.4, false);
								}
							}
							sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), 7);
							{
								ItemStack _ist = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						} else {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), 4);
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("trackerid") >= 1) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entity.getPersistentData().getDouble("trackerid") == (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble("listeningId")) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " X: " + new java.text.DecimalFormat("##").format(entity.getX()) + " Y: " + new java.text.DecimalFormat("##").format(entity.getY()) + " Z: "
								+ new java.text.DecimalFormat("##").format(entity.getZ()))), true);
				}
			}
		}
		if (sourceentity instanceof LivingEntity _livEnt140 && _livEnt140.hasEffect(Art5019injusticeModMobEffects.HAZARD.get())) {
			if (random < probs + 0.1 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.HAZARD.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.HAZARD.get()).getAmplifier() : 0) + 1)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		}
		if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:sonic_damage")))) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("ouch"), false);
			if (20 == (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid
					|| 18 == (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid) {
				Art5019injusticeMod.queueServerWork(5, () -> {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) (amount * 2));
				});
			}
		} else if (damagesource.is(DamageTypes.LAVA)) {
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).res_fire == 2) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		} else if (damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.ON_FIRE)) {
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).res_fire >= 1) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
				entity.clearFire();
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("art5019injustice:blades")))) {
			Art5019injusticeMod.queueServerWork(5, () -> {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:bleeding_damage")))),
						(float) (0.4 * amount));
			});
		}
		if (Art5019injusticeModItems.METALLO_MALLET.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			MetalloMalletLivingEntityIsHitWithItemProcedure.execute(world, x, y, z, entity);
		}
		if (Art5019injusticeModItems.TACTICAL_KNIFE.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
				|| Art5019injusticeModItems.TACTICAL_IRON_KNIFE.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			typecall = 3;
		} else if (Art5019injusticeModItems.KRYPTONITE_KNIFE.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			typecall = 1;
		} else if (Art5019injusticeModItems.GOLDEN_KRYPTONITE_KNIFE.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			typecall = 2;
		}
		if (typecall != 0) {
			if (!TacticalKnifesGenericAttackProcedure.execute(entity, amount, distance, typecall)) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		}
	}
}
