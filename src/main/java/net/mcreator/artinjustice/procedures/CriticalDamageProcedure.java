package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;
import net.mcreator.artinjustice.entity.MrNegativeEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CriticalDamageProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getTarget(), event.getEntity(), event.isVanillaCritical());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, boolean isvanillacritical) {
		execute(null, world, x, y, z, entity, sourceentity, isvanillacritical);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, boolean isvanillacritical) {
		if (entity == null || sourceentity == null)
			return;
		double bulletres = 0;
		double probs = 0;
		double electricalcharge = 0;
		double random = 0;
		double distance = 0;
		double typecall = 0;
		if (isvanillacritical) {
			if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_1_HELMET.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_1_CHESTPLATE.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_1_BOOTS.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_1_LEGGINGS.get()) {
				Art5019injusticeMod.queueServerWork(11, () -> {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), 4);
				});
			}
			if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.GHOST_SPIDER_HELMET.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.GHOST_SPIDER_CHESTPLATE.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.GHOST_SPIDER_BOOTS.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.GHOST_SPIDER_LEGGINGS.get()) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.STICK) {
					Art5019injusticeMod.queueServerWork(11, () -> {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), 3);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(), 30, 0, false, false));
						for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 3, 7); index0++) {
							Art5019injusticeMod.queueServerWork(Mth.nextInt(RandomSource.create(), 5, 40), () -> {
								if (Math.random() < 0.5) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.basedrum")), SoundSource.PLAYERS, 1,
													(float) (1 / Mth.nextDouble(RandomSource.create(), 1, 10)));
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.basedrum")), SoundSource.PLAYERS, 1, (float) (1 / Mth.nextDouble(RandomSource.create(), 1, 10)),
													false);
										}
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.NOTE, x, (y + 1), z, 7, 0.4, 1, 0.4, 1);
								} else {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.snare")), SoundSource.PLAYERS, 1,
													(float) (1 / Mth.nextDouble(RandomSource.create(), 1, 10)));
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.snare")), SoundSource.PLAYERS, 1, (float) (1 / Mth.nextDouble(RandomSource.create(), 1, 10)),
													false);
										}
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.NOTE, x, (y + 1), z, 7, 0.4, 1, 0.4, 1);
								}
							});
						}
					});
				}
			}
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.VENOM_EDDIE_BROCK_SUIT_CHESTPLATE.get()
							|| (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.VENOM_PST_SUIT_CHESTPLATE.get())) {
				Art5019injusticeMod.queueServerWork(11, () -> {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), 4);
				});
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.ANTI_VENOM_SUIT_HELMET.get()
					&& !(entity instanceof LivingEntity _livEnt49 && _livEnt49.hasEffect(MobEffects.WEAKNESS) || entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()))) {
				AntiVenomCleaningHandsOnCriticalProcedure.execute(world, x, y, z, sourceentity);
			}
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 3
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1 && sourceentity instanceof ServerPlayer _plr53
					&& _plr53.level() instanceof ServerLevel && _plr53.getAdvancements().getOrStartProgress(_plr53.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_electrical_touch"))).isDone()
					&& (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ELECTRICITY.get(), 80, 2, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.INTERFERENCE.get(), 1200, 0, false, false));
				{
					double _setval = 6000;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ability6cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.NEUTRAL, (float) 0.8, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.NEUTRAL, (float) 0.8, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle dust 0 0.933 1.000 1 ~ ~ ~ 1 1 1 1 200 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle dust 1 0.933 1.000 1 ~ ~ ~ 1 1 1 1 200 normal");
			}
			if (sourceentity instanceof LivingEntity _livEnt59 && _livEnt59.hasEffect(Art5019injusticeModMobEffects.UNCLE_SAM_POSSESSED.get())) {
				Art5019injusticeMod.queueServerWork(5, () -> {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 1, (entity.getDeltaMovement().z())));
				});
				Art5019injusticeMod.queueServerWork(15, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon firework_rocket ~ ~ ~ {FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:1,Colors:[I;16711680,993707]},{Type:2,Colors:[I;16777215]}]}}}}");
				});
			}
			if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.QUEEN_MAEVE_SUIT_HELMET.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.QUEEN_MAEVE_SUIT_CHESTPLATE.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.QUEEN_MAEVE_SUIT_BOOTS.get()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.QUEEN_MAEVE_SUIT_LEGGINGS.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 1, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, 1, false, false));
			}
			if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.INNER_DEMON_MASK_HELMET.get()) {
				if (EnchantmentHelper.getItemEnchantmentLevel(Art5019injusticeModEnchantments.DARK_ENERGY.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					DarkEnergyHitProcedure.execute(world, entity, sourceentity, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(Art5019injusticeModEnchantments.DARK_ENERGY.get()) + 1);
				} else {
					DarkEnergyHitProcedure.execute(world, entity, sourceentity, 1);
				}
			} else if (EnchantmentHelper.getItemEnchantmentLevel(Art5019injusticeModEnchantments.DARK_ENERGY.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				DarkEnergyHitProcedure.execute(world, entity, sourceentity, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(Art5019injusticeModEnchantments.DARK_ENERGY.get()));
			}
			if (entity instanceof MrNegativeEntity) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLASH, x, y, z, 10, 1, 1, 1, 1);
				MrNegativeAura1Procedure.execute(world, entity);
			}
		} else {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.ANTI_VENOM_SUIT_HELMET.get()) {
				AntiVenomCleaningHandsOnHitProcedure.execute(world, x, y, z, entity, sourceentity);
			}
		}
	}
}
