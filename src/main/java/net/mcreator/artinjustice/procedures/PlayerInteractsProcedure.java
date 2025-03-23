package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.world.inventory.VillagerPassMenu;
import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModGameRules;
import net.mcreator.artinjustice.Art5019injusticeMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import io.netty.buffer.Unpooled;

@Mod.EventBusSubscriber
public class PlayerInteractsProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.ANTIBIOTICS.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.ANTIBIOTICS.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HEART, x, y, z, 40, 1, 1, 1, 1);
			BacteriaKillingProcedure.execute(world, entity);
			AlignmentUpdateProcedure.execute(world, x, y, z, entity, sourceentity, 1);
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.VACCINE_TYPE_I.get()) {
			VaccineTypeIAppliedProcedure.execute(entity);
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VACCINE_TYPE_I.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.EMPTY_SYRINGE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.VACCINE_CARRIER.get()) {
			VaccineCarrierRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity);
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.VACCINE_TYPE_II.get()) {
			VaccineTypeIIApliedProcedure.execute(entity);
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VACCINE_TYPE_II.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.EMPTY_SYRINGE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.MEDICAL_NANOTECH.get()) {
			MedicalNanotechAppliedProcedure.execute(entity);
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MEDICAL_NANOTECH.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.VACCINE_CARRIER_B.get()) {
			VaccineCarrierRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity);
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.HANDCUFF.get()) {
			ArrestingProcedure.execute(world, x, y, z, entity, sourceentity);
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.FEAST_CARDS.get()
				&& !(sourceentity instanceof Player _plrCldCheck25 && _plrCldCheck25.getCooldowns().isOnCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()))) {
			FeastSendingProcedure.execute(world, x, y, z, entity, sourceentity, sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.FOOD_PACKAGE.get()) {
			if (entity instanceof Villager) {
				FoodControlProcedure.execute(world, x, y, z, entity);
			}
		} else if (entity instanceof Villager || entity instanceof WanderingTrader) {
			if (entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(Art5019injusticeModMobEffects.FEAR.get())) {
				Art5019injusticeMod.queueServerWork(2, () -> {
					if (sourceentity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("VillagerPass");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new VillagerPassMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				});
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DRIPPING_WATER, x, y, z, 20, 0.6, 1, 0.6, 1);
			} else if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment < -50
					|| sourceentity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(Art5019injusticeModMobEffects.RAGE.get())) {
				Art5019injusticeMod.queueServerWork(2, () -> {
					if (sourceentity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("VillagerPass");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new VillagerPassMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				});
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DRIPPING_WATER, x, y, z, 20, 0.6, 1, 0.6, 1);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof IronGolem) {
							if (entityiterator instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						}
					}
				}
				if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment < -2500) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7c\u00A7oFear me... run, scream for help, your heroes won't come to save you this time"), false);
				} else if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment < -500) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7c\u00A7oRun, run, run, as fast as you can..."), false);
				} else if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment < -100) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7oGet out of my way..."), false);
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7oMaybe I scared Him"), false);
				}
			}
		} else if (entity instanceof IronGolem) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.IRON_NANITES.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600000, 3));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600000, 0));
				if (sourceentity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:metal_golem_solid"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.IRON_NANITES.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CRIMINAL_BUNDLE.get()) {
				{
					double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment + 6;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.alignment = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.CRIMINAL_BUNDLE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 25, 1, 1, 1, 0);
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:return_to_owner"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				Art5019injusticeModVariables.MapVariables.get(world).criminality_rate = Art5019injusticeModVariables.MapVariables.get(world).criminality_rate
						- ((world.getLevelData().getGameRules().getInt(Art5019injusticeModGameRules.CRIMINALITY_EVENT_CHANGE_PERCENTAGE)) / 100) * 0.000003;
				Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.HONEYCOMB) {
			HoneyCombRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		}
	}
}
