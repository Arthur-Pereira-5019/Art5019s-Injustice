package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.MetalloEntity;
import net.mcreator.artinjustice.entity.KryptonitePistolProjectileEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class MetalloOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextupdate) : 0) <= 0) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				target = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
				if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) == 1) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 165) {
						if (entity instanceof MetalloEntity _datEntSetI)
							_datEntSetI.getEntityData().set(MetalloEntity.DATA_part, 2);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.HOSTILE, 1, (float) 1.2);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.HOSTILE, 1, (float) 1.2, false);
							}
						}
					}
				} else if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) == 2) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 145) {
						if (entity instanceof MetalloEntity _datEntSetI)
							_datEntSetI.getEntityData().set(MetalloEntity.DATA_part, 3);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, x, y, z, 60, 0.4, 1, 0.4, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0, false, false));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
							}
						}
					}
				} else if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) == 3) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 125) {
						if (entity instanceof MetalloEntity _datEntSetI)
							_datEntSetI.getEntityData().set(MetalloEntity.DATA_part, 4);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, x, y, z, 100, 0.4, 1, 0.4, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
					}
				} else if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) == 4) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 95) {
						if (entity instanceof MetalloEntity _datEntSetI)
							_datEntSetI.getEntityData().set(MetalloEntity.DATA_part, 5);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LAVA, x, y, z, 120, 0.4, 1, 0.4, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
					}
				} else if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) == 5) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 45) {
						if (entity instanceof MetalloEntity _datEntSetI)
							_datEntSetI.getEntityData().set(MetalloEntity.DATA_part, 6);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.destroy")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.destroy")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
						world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 85) {
							if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 5 == 0) {
								Art5019injusticeMod.queueServerWork(6, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
									world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
								});
								Art5019injusticeMod.queueServerWork(12, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
									world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
								});
								Art5019injusticeMod.queueServerWork(18, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 2, false, false));
									world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
									world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
								});
							}
						}
						if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 9 == 0) {
							Art5019injusticeMod.queueServerWork(6, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
								world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
							});
							Art5019injusticeMod.queueServerWork(12, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
								world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
							});
							Art5019injusticeMod.queueServerWork(18, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Art5019injusticeModItems.METALLO_MALLET.get()).copy();
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
								(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.KNOCKBACK, 3);
								world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
								world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
							});
						}
						if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 11 == 0) {
							Art5019injusticeMod.queueServerWork(6, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
								world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
							});
							Art5019injusticeMod.queueServerWork(12, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
								world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
							});
							Art5019injusticeMod.queueServerWork(18, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
								(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.KNOCKBACK, 3);
								world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
								world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
							});
						}
					}
				} else if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) == 6) {
					if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 12 == 0) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 4, false, false));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 120, 1, 0.4, 1, 0.4);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.HOSTILE, (float) 0.35, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.HOSTILE, (float) 0.35, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"particle dust 1.000 0.000 0.000 1 ~ ~ ~ 0.3 0.3 0.3 1 100 normal");
						Art5019injusticeMod.queueServerWork(12, () -> {
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, (y + 1), z, 4, Level.ExplosionInteraction.MOB);
						});
					} else if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 11 == 0) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 120, 1, 0.4, 1, 0.4);
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"particle dust 1.000 0.000 0.000 1 ~ ~ ~ 0.3 0.3 0.3 1 100 normal");
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.HOSTILE, (float) 0.35, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.HOSTILE, (float) 0.35, 1, false);
							}
						}
					}
					if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 12 == 6) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get(), 200, 2, false, false));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
								}
							}
						}
					}
					if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 12 == 7
							|| (entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 12 == 2) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get(), 200, 1, false, false));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
								}
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.pistol.reload")), SoundSource.HOSTILE, (float) 0.6, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.pistol.reload")), SoundSource.HOSTILE, (float) 0.6, 1, false);
							}
						}
					}
					if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 12 == 4) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 60, 1, 0.4, 1, 0.4);
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"particle dust 1.000 0.000 0.000 1 ~ ~ ~ 0.3 0.3 0.3 1 100 normal");
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.HOSTILE, (float) 0.35, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.HOSTILE, (float) 0.35, 1, false);
							}
						}
					}
					if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 12 == 5) {
						Art5019injusticeMod.queueServerWork(6, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
							world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
						});
						Art5019injusticeMod.queueServerWork(12, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
							world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
						});
						Art5019injusticeMod.queueServerWork(18, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Art5019injusticeModItems.PISTOL_ITEM.get()).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
							world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
							world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
						});
					}
					if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 12 == 10) {
						Art5019injusticeMod.queueServerWork(6, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
							world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
						});
						Art5019injusticeMod.queueServerWork(12, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
							world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
						});
						Art5019injusticeMod.queueServerWork(18, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.KNOCKBACK, 3);
							world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.IRON_BLOCK.defaultBlockState()));
							world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.POLISHED_DEEPSLATE.defaultBlockState()));
						});
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.PISTOL_ITEM.get()) {
						entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((target.getX()), (target.getY() + 1.5), (target.getZ())));
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new KryptonitePistolProjectileEntity(Art5019injusticeModEntities.KRYPTONITE_PISTOL_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 3, 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 1.4, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.pistol.shoot")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.pistol.shoot")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
					}
				}
				if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) >= 3 && (entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) <= 6) {
					if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) % 4 == 0) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world
									.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((4 + (entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) * 2) / 2d), e -> true).stream()
									.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
									if (!(entityiterator instanceof LivingEntity _livEnt150 && _livEnt150.hasEffect(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get()))) {
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get(), 200, 0, false, false));
									}
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
								}
							}
						}
					}
				}
				if (entity instanceof MetalloEntity _datEntSetI)
					_datEntSetI.getEntityData().set(MetalloEntity.DATA_nextattack, (int) ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextattack) : 0) + 1));
				if (entity instanceof MetalloEntity _datEntSetI)
					_datEntSetI.getEntityData().set(MetalloEntity.DATA_nextupdate, 50);
			}
		}
		if (entity instanceof MetalloEntity _datEntSetI)
			_datEntSetI.getEntityData().set(MetalloEntity.DATA_nextupdate, (int) ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_nextupdate) : 0) - 1));
	}
}
