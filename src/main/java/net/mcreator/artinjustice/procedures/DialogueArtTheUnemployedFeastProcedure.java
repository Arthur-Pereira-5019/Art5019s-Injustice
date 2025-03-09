package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.ArtTheUnemployedEntity;

public class DialogueArtTheUnemployedFeastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.HONEYCOMB)) {
			if (CanTalkWithArtProcedure.execute(sourceentity)) {
				if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_quest) : 0) == 1) {
					if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 0) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Art> Opa! I mean, hi! How are you doing? Sorry for mischoosing the words, I'm stil adapting."), false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 1);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 1) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Art> Want some advice? I travelled a lot before getting on this situation."), false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 2);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 2) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(
									"<Art> Something that I can say for sure it's to never mistake pride for being yourself despite everything that being yourself caused to you, even if you can or cannot change that, with being prideful for who you are and use that to make yourself better than the others."),
									false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 3);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 3) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Art> Remember, pride is the first sin in the bible, a major sin in Islam, one of the five poisons in budhism, and the list can go on forever."), false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 4);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 4) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(
									"<Art> Why am I telling you that? It's because people seem to love religion these days, but more on the parts of being part of a group of choosen people, and not on the \"Love your neighbor as yourself\" part."),
									false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 5);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 5) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(
									"<Art> Are you really willing to help this world? Go on, and wear off your ego. Look above, and down, you won't see anyone. We are in the same plan, we are in the same place, the same plane, in the same planet"),
									false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 6);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 6) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Art> Take back to me this feather that I found on my trip to Egypt when it feels heavier than you."), false);
						if (sourceentity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(Art5019injusticeModItems.MAAT_FEATHER.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 7);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 7) {
						if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.MAAT_FEATHER.get()
								&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("weight") >= 500) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(
										"<Art> I can already see it being an uncomfortable weight for you. You are free from the burden of the feather, but now you may ask yourself, are you free from your own burdens, or may I say... \u00A7cyour inner demons?"),
										false);
							ArtTheUnemployedTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 25, -0.00055, 2, 0);
							if (sourceentity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MAAT_FEATHER.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							if (world instanceof ServerLevel _level)
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 30));
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<Art> The Feather is an artifact only found in Egyptian temples, some good men that I found said it weighed about half of a kilogram."), false);
						}
					}
				} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_quest) : 0) == 2) {
					if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 0) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal("\u00A77\u00A7oArt whispers to you: I overheard Martin Li speaking chinese last night. He was talking with some mobsters, asking for more manpower... he is Mr Negative. He needs to be stopped."),
									false);
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:hidden_agenda"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 1);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 1) {
						if (sourceentity instanceof ServerPlayer _plr40 && _plr40.level() instanceof ServerLevel
								&& _plr40.getAdvancements().getOrStartProgress(_plr40.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:the_heartofthe_matter"))).isDone()) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(
										Component.literal("<Art> As I would say on my country: Tu \u00E9 do c******** mermo meu parceiro! tu \u00E9 f*** cara! Now Li will see the sun raise square. Wait, you don't say that here? It's so obvious!"),
										false);
							ArtTheUnemployedTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 50, -0.00755, 3, 0);
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A77\u00A7oArt whispers to you: Stop him."), false);
						}
					}
				} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_quest) : 0) == 3) {
					if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 0) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Art> Hello, how you've been doing?"), false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 1);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 1) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal("<Art> For us, it's been hard times. Li used a lot of money to run this place. Even tough it's a pretty self-sustainable place, we still needed a lot of money to keep the things on the rails."),
									false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 2);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 2) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(
									"<Art> We tried to find help within banks and from the government . You know what is funny, what some places such my country and others scattered around the world call human rights, here you call comunist propaganda. Alongside the fact this place used to be ran by a monster. But what other northern charity institution is not? "),
									false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 3);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 3) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal(
											"<Art> Hell yeah, the best country in the world you say. But anyway, this anger won't bring food to those folks over here. If you have something to help us, go on and donate to May, hunger doesn't wait."),
									false);
						if (entity instanceof ArtTheUnemployedEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ArtTheUnemployedEntity.DATA_step, 4);
					} else if ((entity instanceof ArtTheUnemployedEntity _datEntI ? _datEntI.getEntityData().get(ArtTheUnemployedEntity.DATA_step) : 0) == 4) {
						if (!world.isClientSide()) {
							if (Math.random() < 0.6) {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("<Art> \u00A77[Distracted] Tic tac... hunger doesn't know time, but time knows hunger."), false);
							} else {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(
											"<Art> About Kale? We're talking more these days, still is pretty awkward, but now she got actual spare time to think about her actual life. Li used to keep her more busy than anyone else here. Maybe it's because she's the most intelligent girl I know in the world and would easily find out about his identity if she wasn't that busy. Although she will never admit it. You can go say it to her if you want."),
											false);
								{
									double _setval = 1;
									sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.gossipid = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
							}
						}
					}
				}
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Art> My time on this country has been harsh to me. It will take sometime to build trust. Relax, it's nothing personal agains't you. Go on and help other people on the shelter."),
							false);
			}
		}
	}
}
