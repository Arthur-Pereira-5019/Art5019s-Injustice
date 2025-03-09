package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.EyesMutantEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class EyesMutantRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_type) : 0) == 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
			if (Math.random() < 0.5) {
				if (Math.random() < 0.5) {
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_type, 1);
				} else {
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_type, 2);
				}
			} else {
				if (Math.random() < 0.5) {
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_type, 3);
				} else {
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_type, 4);
				}
			}
		} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_type) : 0) == 1) {
			if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> I'm feeling tired... thanks for taking that devil down. "), false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> My wife died right before they took me to here. I must attend to her funeral... can you help me?"), false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> I don't... I don't look good, can you retrieve one eye for me..."), false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 3) {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.HUMAN_EYE.get())) : false) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.HUMAN_EYE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 2;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<???> I don't... I don't look good, can you retrieve one eye for me...?"), false);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 4) {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.HUMAN_EYE.get())) : false) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 4));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.HUMAN_EYE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 3;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<???> I'm feeling better, can you retrieve another eye?"), false);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 5) {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.MEDICAL_KIT.get())) : false) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 11));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MEDICAL_KIT.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 5;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<???> I need to remove, remove those eyes around me, I need some sort of Medical Kit, can you get one for me?"), false);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 6) {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.POPPY)) : false) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 7));
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.POPPY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<???> You don't know how much that means to me... but I need another help of yours. I usually would go on alone on that, but since I'm still getting better from the experiments, I can't go behind that, since they've become a rarity in this destroyed world... a flower, any red poppy is enough, that were the ones she most loved."),
								false);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 7) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<???> Thanks, you don't know how much that means to me... you're my hero. I've heard those eyes have some uses beyond giving experiments like me visions of other worlds, here take some of them. Now... I must go. This, no, better, any other world needs to have more people like you. "),
							false);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ENDER_EYE));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ENDER_EYE));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ENDER_EYE));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)), 0.9);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
				Art5019injusticeMod.queueServerWork(120, () -> {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 11));
					if (!entity.level().isClientSide())
						entity.discard();
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 15;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				});
			}
		} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_type) : 0) == 2) {
			if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> Thanks... You don't know how I felt when I saw right before my eyes someone that could put down those fake gods."), false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<???> You know, the first thing they do when they bring you to places like that, is to burn down everything that has some meaning to you, so you don't have any reason to fight agains't the torture and the brainwashing... so I don't have a home to go."),
							false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> Wait, do you know a Freedom Fighters base? Can you give me an Access Badge?"), false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 3) {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.FREEDOM_FIGHTERS_BADGE.get())) : false) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.FREEDOM_FIGHTERS_BADGE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 5;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<???> Wait, do you know a Freedom Fighters base? Can you give me an Access Badge?"), false);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> Thanks... but those eyes despite giving me visions of other worlds, they don't actually work pretty well to actually let me see things, can you give me my two eyes back?"),
							false);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 5) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 2
						&& Art5019injusticeModItems.HUMAN_EYE.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 4));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.HUMAN_EYE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 2, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 3;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<???> Damn, this made me feel so much better, but all these other eyes keep hurting my brain, can you give me a Medical Kit so I'm able to take them all off?"), false);
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Come back with 2 Human Eyes on your Main Hand>"), false);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 6) {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.MEDICAL_KIT.get())) : false) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 11));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MEDICAL_KIT.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 5;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Come back with a Medical Kit on your Inventory>"), false);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 7) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> You saved my life, I won't forget you, and also I'll make sure no one ever forget."), false);
				Art5019injusticeMod.queueServerWork(120, () -> {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 11));
					if (!entity.level().isClientSide())
						entity.discard();
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 15;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ENDER_EYE));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ENDER_EYE));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ENDER_EYE));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				});
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)), 0.9);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			}
		} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_type) : 0) == 3) {
			if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> You know, this place is so cold that I can feel it on my blood. if I want to go outside? No, I'll warm myself by killing those who put me here."), false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<???> If I want to join the Freedom Fighters? No, they want justice for those who this monstrous regime killed, I just want revenge for myself, two things that seem similar, but are different in the root, therefore different in the fruits."),
							false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> If I want help? You already helped me enough... but if you could provide me some sort of blade, things would be easier, really easier."), false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 3) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 5;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<???> Wait, do you know a Freedom Fighters base? Can you give me an Access Badge?"), false);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<???> This one must be enough for the work... if I want my eyes back? No, no, no... I'll use theirs... instead, if you want to give me another thing, why not some alcohol so we can feast together before putting those ********* in the tomb, where they deserve to be?"),
							false);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 5) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 2
						&& Art5019injusticeModItems.ALCOHOL_FLASK.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 4));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.ALCOHOL_FLASK.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 2, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.drink")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.drink")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 900, 0));
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 3;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<???> Yeah, that's what I'm talking about, you know what, you are my hero, and every fight I take from now on, I'll renember how you put that fake god on his knees."), false);
					Art5019injusticeMod.queueServerWork(120, () -> {
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 16));
						if (!entity.level().isClientSide())
							entity.discard();
						{
							double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 15;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.alignment = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					});
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)), 0.9);
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7cBring two Alcohol Bottles on your main-hand"), true);
				}
			}
		} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_type) : 0) == 4) {
			if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<???> They forced me to tell everything I saw on these eyes, so they could take notes about the Multiverse and know where to attack, and how to attack, if I denied to say something or lied about any piece of information they would torture me no matter what. But I kept secret on one thing, on one single thing... your coming to this Earth."),
							false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> You're still here... I didn't tought someone like me could be useful on your journey... I promisse to be useful... just give me some eyes, like 8 eyes are enough."), false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 2) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 8
						&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.HUMAN_EYE.get()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 100));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 8, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 30;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7cCome back with 8 Human Eyes on your Main-Hand"), true);
				}
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<???> If I want them for me? No, no, no, these are for other experiments, or rebels who lost their eyes fighting agains't the Reich..."), false);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<???> Now, I just need some medical kits, four are enough. If I know how to use them? I was a doctor who used to help people whose were on the margins of the regime, until they discovered what I used to do, and then they put me here. But now I realize, I was only caught before fullfilling my destiny because I was afraid of going all out on it... so, I won't be afraid anymore."),
							false);
				if (entity instanceof EyesMutantEntity _datEntSetI)
					_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
			} else if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 5) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 4
						&& Art5019injusticeModItems.MEDICAL_KIT.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 4));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MEDICAL_KIT.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 4, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
					{
						double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 3;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alignment = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<???> Thanks, and yes, I'm sure about these eyes... I can live with them... and I'll use them to watch you wherever you are in this dimension, as a living memory of who allowed me to be alive in the first place."),
								false);
					Art5019injusticeMod.queueServerWork(120, () -> {
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 60));
						if (!entity.level().isClientSide())
							entity.discard();
						{
							double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 60;
							sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.alignment = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					});
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 40, 1, 1, 1, 1);
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((x + Mth.nextInt(RandomSource.create(), -10, 10)), (y + Mth.nextInt(RandomSource.create(), -10, 10)), (z + Mth.nextInt(RandomSource.create(), -10, 10)), 0.9);
					if (entity instanceof EyesMutantEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EyesMutantEntity.DATA_stats, (int) ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) + 1));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7cBring 4 Medical Kits on your main-hand"), true);
				}
			}
		}
	}
}
