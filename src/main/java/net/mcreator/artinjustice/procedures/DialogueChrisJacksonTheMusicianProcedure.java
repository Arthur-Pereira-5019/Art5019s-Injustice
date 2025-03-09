package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.ChrisTheMusicianEntity;

public class DialogueChrisJacksonTheMusicianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.HONEYCOMB)) {
			if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_quest) : 0) == 1) {
				if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 0) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Chris Jackson> What's up man? Nice to meet ya. My name is Christopher Jackson, but you can call me Chris."), false);
					if (entity instanceof ChrisTheMusicianEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ChrisTheMusicianEntity.DATA_step, 1);
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<Chris> Hey bro. Can you help me with something? So, Martin Li is a nice guy, but something is on with his accounts these days, he spent most of his days in the office or solving things outside the shelter, and now, he cutted the money on the A of the FEAST, so, guess what? No more money to fix my glasses. So... you see to be a handyman, can you provide me two of those Amethyst Lenses?"),
								false);
					if (entity instanceof ChrisTheMusicianEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ChrisTheMusicianEntity.DATA_step, 2);
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 2) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.AMETHYST_LENSES.get()
							&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.AMETHYST_LENSES.get()) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(
									"<Chris> Yooo! You really got it? Thanks my guy! Finally I can read those music sheets. Here, take it. I don't have too much by now, but one day, when I become famous, I'll pay you back, and Mr. Li, and my mom too."),
									false);
						ChrisJacksonTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 4, -0.00015, 2, 0);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Art5019injusticeModItems.PEANUT_BUTTER.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.AMETHYST_LENSES.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 2, _player.inventoryMenu.getCraftSlots());
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.AMETHYST_LENSES.get()
							|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.AMETHYST_LENSES.get()) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Chris> Yes, that is the lense I need, but where is the other one?"), false);
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Chris> Not yet? Remember, two Amethyst Lenses, not the Diamond ones."), false);
					}
				}
			} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_quest) : 0) == 2) {
				if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 0) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Chris> Hey! The music stuff is going great, but not for Mr. Li these days... I wish I could help him."), false);
					if (entity instanceof ChrisTheMusicianEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ChrisTheMusicianEntity.DATA_step, 1);
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(
								Component.literal(
										"<Chris> Now I'm trying to make some drift phonk beat to boost my socials, but some instruments are missing for the noteblocks. So, can you find them for me? I'll need a Cow Bell, a Bass Drum and Bells."),
								false);
					if (entity instanceof ChrisTheMusicianEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ChrisTheMusicianEntity.DATA_step, 2);
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 2) {
					if ((sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.GOLD_BLOCK)) : false)
							&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.SOUL_SAND)) : false)
							&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.STONE)) : false)) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.STONE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.GOLD_BLOCK);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.SOUL_SAND);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Chris> Damn! You came back faster than I expected, I hope that my rise to the top be as fast as you are lil bro."), false);
						ChrisJacksonTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 6, -0.00015, 3, 0);
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Chris> Did you forgot the instruments? It's a Stone for the Kick, a Block of Gold for the Bell and a Soul Sand for the Cow Bell."), false);
					}
				}
			} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_quest) : 0) == 3) {
				if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 0) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Chris> What's up man? I'll ask you for help one more time. My songs are already booming, it's not me that needs help anymore, it's my brother."), false);
					if (entity instanceof ChrisTheMusicianEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ChrisTheMusicianEntity.DATA_step, 1);
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<Chris> He went to a college in Central City with a scholarship due his amazing athlete skills, but to pay for the college, the scolarship wasn't enough, so he had to do some lab research with an old man \"Einstein\" or something to get money, which takes time of his training. Now, due to a championship, he needs a month away from the lab to get ready, so him will need either money or some help with the research."),
								false);
					if (entity instanceof ChrisTheMusicianEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ChrisTheMusicianEntity.DATA_step, 2);
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 2) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<Chris> I would help him with the money from my musics, but I was keeping it to help the shelter and our mom, Relax, I won't ask for money, but for research with his \"Firestorm Matrix\" or something like that. He need something that will fullfill his power supply requirements, can you provide us something like that?"),
								false);
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Art5019injusticeModItems.ANNOTATION_PAPER.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof ChrisTheMusicianEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ChrisTheMusicianEntity.DATA_step, 3);
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 3) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.END_CRYSTAL) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Chris> You are an absolute legend man, thank you, here it is, I would buy some fast food to me with the money I earned yesterday, but you can keep it, thank you bro."),
									false);
						ChrisJacksonTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 20, -0.0025, 3, 4);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.DIAMOND));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:out_of_the_matrix"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.END_CRYSTAL);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Chris> Did you lost the paper? No problem, I remember, he told me on the call it was something called \"Final Crystal\" or something like that."), false);
					}
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_step) : 0) == 4) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Chris> Soon I'll be on the radio, I'm so excited."), false);
				}
			}
		}
	}
}
