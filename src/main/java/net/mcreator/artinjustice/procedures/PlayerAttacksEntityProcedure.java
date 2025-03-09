package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;
import net.mcreator.artinjustice.entity.StormfrontEntity;
import net.mcreator.artinjustice.entity.MrNegativeEntity;
import net.mcreator.artinjustice.entity.LokiBossEntity;
import net.mcreator.artinjustice.entity.DeathstrokeEntity;

import javax.annotation.Nullable;

import java.util.Map;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class PlayerAttacksEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(),
					event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double probs = 0;
		double electricalcharge = 0;
		double bulletres = 0;
		double dx = 0;
		double d = 0;
		double dy = 0;
		double dz = 0;
		dx = Math.abs(sourceentity.getX() - entity.getX());
		dy = Math.abs(sourceentity.getY() - entity.getY());
		dz = Math.abs(sourceentity.getZ() - entity.getZ());
		d = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
		if (!world.isClientSide()) {
			probs = Math.random();
		}
		if (sourceentity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(Art5019injusticeModMobEffects.WEBBED.get()) || sourceentity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get())
				|| sourceentity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(Art5019injusticeModMobEffects.STUN.get())
				|| sourceentity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(Art5019injusticeModMobEffects.TIME_STOPPED.get())) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
		if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).masspunch > 4 && damagesource.is(DamageTypes.PLAYER_ATTACK)
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			MassPunchProcedure.execute(world, x, y, z, entity, sourceentity);
		}
		if (entity instanceof LivingEntity _livEnt15 && _livEnt15.isBlocking()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_AMERICA_SHIELD.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CAPTAIN_AMERICA_SHIELD.get()) {
				if (!((sourceentity.getDirection()) == (entity.getDirection()))) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					} else if (event != null && event.hasResult()) {
						event.setResult(Event.Result.DENY);
					}
				}
			}
		}
		if ((Art5019injusticeModItems.BLACK_PANTHER_SUIT_CHESTPLATE.get() == (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
				|| Art5019injusticeModItems.BLACK_PANTHER_SUIT_2_CHESTPLATE.get() == (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem())
				&& ItemStack.EMPTY.getItem() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (Math.random() < 0.3 && !(Art5019injusticeModItems.SPIDER_MAN_AG_2_HELMET.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
					&& Art5019injusticeModItems.SPIDER_MAN_AG_2_CHESTPLATE.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
					&& Art5019injusticeModItems.SPIDER_MAN_AG_2_LEGGINGS.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
					&& Art5019injusticeModItems.SPIDER_MAN_AG_2_BOOTS.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.BLEEDING.get(),
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.BLEEDING.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.BLEEDING.get()).getDuration() : 0) + 60), 1, false,
							false));
			}
		}
		if (Art5019injusticeModItems.NEURO_SUIT_CHESTPLATE.get() == (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
				&& Blocks.AIR.asItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && damagesource.is(DamageTypes.PLAYER_ATTACK)) {
			if (Math.random() < 0.3) {
				electricalcharge = electricalcharge + 40;
			}
			if (Math.random() < 0.3) {
				electricalcharge = electricalcharge + 40;
			}
		}
		if (Art5019injusticeModItems.NEURO_SUIT_BOOTS.get() == (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() && damagesource.is(DamageTypes.PLAYER_ATTACK)) {
			if (Math.random() < 0.3) {
				electricalcharge = electricalcharge + 20;
			}
			if (Math.random() < 0.3) {
				electricalcharge = electricalcharge + 20;
			}
		}
		if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 13 && damagesource.is(DamageTypes.PLAYER_ATTACK)) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl >= 3) {
				if (Math.random() < 0.4) {
					electricalcharge = electricalcharge + 40;
				}
				if (Math.random() < 0.4) {
					electricalcharge = electricalcharge + 40;
				}
			}
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl >= 5) {
				if (Math.random() < 0.2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FEAR.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FEAR.get()).getDuration() : 0) + 140), 1, false, true));
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
				&& EnchantmentHelper.getItemEnchantmentLevel(Art5019injusticeModEnchantments.MODULAR_FORTUNE.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (sourceentity instanceof LivingEntity _livEnt56 && _livEnt56.hasEffect(Art5019injusticeModMobEffects.FORTUNE.get())) {
				{
					Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					if (_enchantments.containsKey(Enchantments.MOB_LOOTING)) {
						_enchantments.remove(Enchantments.MOB_LOOTING);
						EnchantmentHelper.setEnchantments(_enchantments, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					}
				}
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.MOB_LOOTING,
						(int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.FORTUNE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.FORTUNE.get()).getAmplifier() : 0) + 1));
			} else if (sourceentity instanceof LivingEntity _livEnt62 && _livEnt62.hasEffect(Art5019injusticeModMobEffects.HAZARD.get())) {
				{
					ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt((int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.HAZARD.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.HAZARD.get()).getAmplifier() : 0) * 1 + 1),
							RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			} else {
				{
					Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					if (_enchantments.containsKey(Enchantments.MOB_LOOTING)) {
						_enchantments.remove(Enchantments.MOB_LOOTING);
						EnchantmentHelper.setEnchantments(_enchantments, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					}
				}
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem) {
			if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 9) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Art5019injusticeModEnchantments.MODULAR_FORTUNE.get(), 1);
			}
		}
		if (electricalcharge >= 20) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ELECTRICITY.get(),
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ELECTRICITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ELECTRICITY.get()).getDuration() : 0) + electricalcharge),
						0, false, true));
		}
		if (immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:bullet_projectiles")))) {
			bulletres = 0;
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("art5019injustice:bullet_proof")))) {
				bulletres = bulletres + 0.1;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("art5019injustice:bullet_proof")))) {
				bulletres = bulletres + 0.3;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("art5019injustice:bullet_proof")))) {
				bulletres = bulletres + 0.35;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("art5019injustice:bullet_proof")))) {
				bulletres = bulletres + 0.25;
			}
			if (Math.random() < bulletres) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		}
		if (sourceentity instanceof LivingEntity _livEnt83 && _livEnt83.hasEffect(Art5019injusticeModMobEffects.ILLUSIONED.get())) {
			sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) amount);
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
		if ((sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:humans"))) || entity instanceof Player) && entity instanceof LivingEntity _livEnt88
				&& _livEnt88.hasEffect(Art5019injusticeModMobEffects.PHEROMONES.get())) {
			if (d <= 14) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 40, 1, 0.5, 1, 1);
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entity) {
							if (!(entityiterator == sourceentity)) {
								if (sourceentity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							}
						}
					}
				}
			}
		}
		if (sourceentity instanceof StormfrontEntity) {
			if (!(entity instanceof LivingEntity _livEnt96 && _livEnt96.hasEffect(Art5019injusticeModMobEffects.ELECTRICITY.get())) && Math.random() < 0.3 && sourceentity.getPersistentData().getDouble("step") < 9) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ELECTRICITY.get(), 160, 1, false, false));
			}
		} else if (sourceentity instanceof LokiBossEntity && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 1.5) {
			if (Math.random() < 0.1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 80, 3, false, false));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLASH, x, y, z, 10, 3, 3, 3, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 30, 3, 3, 3, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			}
		} else if (!(entity instanceof LivingEntity _livEnt106 && _livEnt106.isBlocking()) && damagesource.is(DamageTypes.MOB_ATTACK)) {
			if (sourceentity instanceof DeathstrokeEntity) {
				if (20 - (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 0) {
					SwordFightingHitProcedure.execute(world, x, y, z, entity, sourceentity, 20 - (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0), 7);
				} else {
					SwordFightingHitProcedure.execute(world, x, y, z, entity, sourceentity, 0, 7);
				}
			} else if (sourceentity instanceof MrNegativeEntity) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.KATANA.get()) {
					if (18 - (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 0) {
						SwordFightingHitProcedure.execute(world, x, y, z, entity, sourceentity, 18 - (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0), 6);
					} else {
						SwordFightingHitProcedure.execute(world, x, y, z, entity, sourceentity, 0, 6);
					}
				} else {
					MrNegativePunchProcedure.execute(world, entity, sourceentity);
				}
			}
			if (probs <= 0.13 && EnchantmentHelper.getItemEnchantmentLevel(Art5019injusticeModEnchantments.DARK_ENERGY.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				DarkEnergyHitProcedure.execute(world, entity, sourceentity, 3);
			}
		}
		if (entity instanceof DeathstrokeEntity) {
			if (entity instanceof DeathstrokeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(DeathstrokeEntity.DATA_blockcycle, (int) ((entity instanceof DeathstrokeEntity _datEntI ? _datEntI.getEntityData().get(DeathstrokeEntity.DATA_blockcycle) : 0) + 1));
		}
	}
}
