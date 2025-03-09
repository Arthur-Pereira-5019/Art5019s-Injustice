package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.FeastNPCEntity;

public class DialoguePaulRabbitTheGamblerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_quest) : 0) == 1) {
			if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_step) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<Paul Rabbit> Oh, it seems that Mr. Li has brought help to the shelter. So... you've seen pretty strong, it remembers me of my old glory days... but it doesn't matter anymore, now I'm at my prime in the art of gambling, I know, that's how I got here in the first place, but with a little bit more of luck, I'll pay my debts and I'll pay back everything Mr. Li has done for us. But, in the first place, I need my card deck back. Some criminals stale mine last week. Can you retrieve it from those punks?"),
							false);
				if (entity instanceof FeastNPCEntity _datEntSetI)
					_datEntSetI.getEntityData().set(FeastNPCEntity.DATA_step, 1);
			} else if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_step) : 0) == 1) {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.CARD_DECK.get())) : false) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Paul Rabbit> Thanks lord you brought back it to me, you deserve a place in Heaven. Now, it's time to gamble, come back anyday if you think you can defeat me!"), false);
					FeastNPCGenericTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 3, 0.00015, 2, 0);
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.CARD_DECK.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Paul Rabbit> Go on! Those punks are dirtying my precious deck of the victory."), false);
				}
			}
		} else if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_quest) : 0) == 2) {
			if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_step) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<Paul Rabbit> The gambling stuff is going really bad these days, I need something to change my luck for better, if you bring me any sort of luck charm, I'll finally pay my debts and my family will love me again!"),
							false);
				if (entity instanceof FeastNPCEntity _datEntSetI)
					_datEntSetI.getEntityData().set(FeastNPCEntity.DATA_step, 1);
			} else if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_step) : 0) == 1) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:lucky_charm")))) {
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Paul Rabbit> Oh! That seems powerful, I can already feel... the hug of my grandson, thank you."), false);
					FeastNPCGenericTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 2, 0.00015, 3, 0);
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Paul Rabbit> Where is the charm? Go on! Soon Kale dogs will become fat with all soups I gambled with her."), false);
				}
			}
		} else if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_quest) : 0) == 3) {
			if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_step) : 0) == 0) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"<Paul Rabbit> Well, well, look who we got here? My hero, so... I won't ask you for helping me to gamble anymore, not after Li helped me with my alcohol addiction, my past is not blurred anymore, this is what put me here in the first place. Soon I'll get a job and will try to make contact with my wife again after all those fifteen years. She loved to collect Music Discs, she had a lot of them, but there was one wich I never allowed her to have, one that made us argue a lot on the dinner table, to me, it was some sort of devillish music, Pig-something, I don't remember, but I don't care anymore about my faith, I just want her back, can you find it for me?"),
							false);
				if (entity instanceof FeastNPCEntity _datEntSetI)
					_datEntSetI.getEntityData().set(FeastNPCEntity.DATA_step, 1);
			} else if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_step) : 0) == 1) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.MUSIC_DISC_PIGSTEP) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Paul Rabbit> Oh Lord! Thank you! Thank you so much! Finally I'm going back home! Here, take it, I don't need those cheap toys anymore!"), false);
					FeastNPCGenericTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 20, -0.00045, 3, 2);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Art5019injusticeModItems.DICE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Art5019injusticeModItems.DICE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.MUSIC_DISC_PIGSTEP);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (sourceentity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:help_paul_rabbit_the_gambler"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Paul Rabbit> Not yet? I know it will take some time until you find the disc, they don't make them anymore nowadays."), false);
				}
			} else if ((entity instanceof FeastNPCEntity _datEntI ? _datEntI.getEntityData().get(FeastNPCEntity.DATA_step) : 0) == 2) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Paul Rabbit> Soon I'll be gone."), false);
			}
		}
	}
}
