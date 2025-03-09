package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.KaleTheCaretakerEntity;
import net.mcreator.artinjustice.entity.ArtTheUnemployedEntity;

import java.util.List;
import java.util.Comparator;

public class DialogueKaleTheCaretakerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack food = ItemStack.EMPTY;
		ItemStack toadd = ItemStack.EMPTY;
		String localart = "";
		if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_quest) : 0) == 1) {
			if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> Oh, hi! Sorry for not talking with you before, the things haven't been that easy these days."), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 1);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> Do you need something? I'm a little bit occupied."), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 2);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> You seem to be on your free time now. Some stray dogs that I've been helping these days costed a lot of the food on the fridge."), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 3);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal("<Kale> I don't care too much about giving our food to them, but the others don't seem to be appreciate that, so, Li said is ok to give them some of our food, as long as no one here starve."), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 4);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> The problem is, some accident happened on the truck that bring our red meat, so... someone must go out there and find our package. Go on, I don't got time for that."), false);
				food = new ItemStack(Art5019injusticeModItems.FOOD_PACKAGE.get());
				food.getOrCreateTag().putDouble("sent", 1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + Mth.nextInt(RandomSource.create(), -50, 50)), (y + 40), (z + Mth.nextInt(RandomSource.create(), -50, 50)), food);
					entityToSpawn.setPickUpDelay(10);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 5);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 5) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.FOOD_PACKAGE.get()
						&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sent") == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> Finally I can sleep knowing the stray pets will have their food secure. Thank you, you're a kind soul."), false);
					KaleTheCaretakerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 5, -0.0002, 2, 0);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> I'm already three minutes late to mine fifteen minute long sleep. Can't you find the food package faster?"), false);
				}
			}
		} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_quest) : 0) == 2) {
			if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kael> Hi there! As you must expect, I'm in a hurry now again, can you lend me a hand?"), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 1);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<Kale> We have some rain collectors at the gardens, but that water is not suitable for drinking, as it takes a lot of time to collect and some filth might stack up on the collectors, so, my plan is to build a filter, can you provide me the materials?"),
							false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 2);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> First, I'll need ten Gravel blocks. Which will filter part of the sediments."), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 3);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 3) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.GRAVEL.asItem()
						&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 10) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.GRAVEL);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 10, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<Kale> Nice, now we will need ten Activated Charcoals, just heat charcoal even more. They can filter a lot of impurities by adsorption, which is kinda like absorption, But instead of putting the matter inside, it will stick to its outside."),
								false);
					KaleTheCaretakerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 1, 0, 2, 4);
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 2));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> Don't forget, ten Gravel blocks."), false);
				}
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 4) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.ACTIVATED_CHARCOAL.get()
						&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 10) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.ACTIVATED_CHARCOAL.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 10, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> Good, the next step is 10 Red Sand Blocks"), false);
					KaleTheCaretakerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 3, 0, 2, 5);
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 6));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> Just heat 10 Charcoals on a Furnace."), false);
				}
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 5) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.RED_SAND.asItem()
						&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 10) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.RED_SAND);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 10, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> This will filter even more the impurities, for the next step, 10 Wool Blocks."), false);
					KaleTheCaretakerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 10, 0, 2, 6);
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 14));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> You may find Red Sand on Badlands."), false);
				}
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 6) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.WHITE_WOOL.asItem()
						&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 10) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.WHITE_WOOL);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 10, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> You're so good at this, we're almost finishing, just provide me more 10 Glass Bottles, so we'll be able to build the filter."), false);
					KaleTheCaretakerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 3, 0, 2, 7);
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 6));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<Kale> 10 Wool blocks is what I need, you can find some by shearing sheep, or by combining Strings. I heard Oscorp spiders are able produce an immense amount of string without damaging the actual spiders, but since they are from Oscorp, something evil is behind that, Li always remembers us about the Osborn dark history."),
								false);
				}
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 7) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE
						&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 10) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 10, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> Well, to end it all, we still need to heat that water to avoid bacteria contamination, can you yield me a Brewing Stand?"), false);
					KaleTheCaretakerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 3, 0, 2, 8);
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 6));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> 10 Glass Bottles, they are made from... Glass? I tought it was obvious."), false);
				}
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 8) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BREWING_STAND) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.BREWING_STAND);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> Finally, clean water for my stray cat- I mean, for everyone here on the shelter! Here, take one filter, it might help you on your journey."), false);
					KaleTheCaretakerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 7, 0, 3, 0);
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Art5019injusticeModItems.WATER_FILTER.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 13));
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> You know how to make a Brewing Stand, right?"), false);
				}
			}
		} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_quest) : 0) == 3) {
			if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> Can I talk with you for a minute?"), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 1);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 1) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> I have been gaining a lot of flowers recently."), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 2);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<Kale> I know it's supposed to be a good thing, but everyone here in the shelter know I don't want to have anything with anyone now. I'm really ocuppied taking care of the street animals that come here."), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 3);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 3) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> And, alongside the flowers, some letters asking for dates on some places that are far away from the shelter."), false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 4);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 4) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal("<Kale> My fear is, that some pet-hater want's to... you know what me due to my work. I know I already don't sleep a lot, but it's getting worse each night, so please, can you find who's behind that? "),
							false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 5);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 5) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Kale> My plan is, with some Honeycomb wax, you may be able to figure the fingerprint left on the flowers, and investigate people around the shelter to see if you find something. "),
							false);
				if (entity instanceof KaleTheCaretakerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(KaleTheCaretakerEntity.DATA_step, 6);
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 6) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.HONEYCOMB) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof ArtTheUnemployedEntity) {
								localart = entityiterator.getStringUUID();
							}
						}
					}
					if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("target1")).equals("")) {
						(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("target1", "None");
						(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("target2", "Empty");
					}
					if ((localart).equals((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("target2"))) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Kale> Wait, is it from... Art? How could I not... Thanks anyway, I'll have to, rethink some things..."), false);
						KaleTheCaretakerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 4, -0.0005, 3, 7);
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 13));
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:sunflower"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					} else if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("target1")).equals("None")) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof ArtTheUnemployedEntity) {
									if (sourceentity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.HONEYCOMB);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									toadd = new ItemStack(Items.HONEYCOMB);
									toadd.getOrCreateTag().putString("target1", (entityiterator.getStringUUID()));
									toadd.getOrCreateTag().putString("target1name", "???");
									if (sourceentity instanceof Player _player) {
										ItemStack _setstack = toadd.copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honeycomb.wax_on")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honeycomb.wax_on")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
								}
							}
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Kale> Here it is, the fingerprint."), false);
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Kale> The fingerprints don't match. Try again."), false);
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> We will need some Honeycomb for that."), false);
				}
			} else if ((entity instanceof KaleTheCaretakerEntity _datEntI ? _datEntI.getEntityData().get(KaleTheCaretakerEntity.DATA_step) : 0) == 7) {
				if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).gossipid == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Kale> He said that about me? He's a silly goose."), false);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HEART, x, (y + 1.65), z, 4, 0.1, 0.1, 0.1, 0.3);
					{
						double _setval = 0;
						sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gossipid = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else {
					if (Math.random() < 0.4) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Kale> About Art? I mean, he's... come on, go do something useful, I'm pretty sure May's nephew asked for some sewing classes."), false);
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Kale> Not now, I'm occupied."), false);
					}
				}
			}
		}
	}
}
