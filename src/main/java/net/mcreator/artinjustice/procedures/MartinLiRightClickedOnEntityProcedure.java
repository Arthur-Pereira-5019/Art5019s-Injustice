package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class MartinLiRightClickedOnEntityProcedure {
	public static InteractionResult execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return InteractionResult.PASS;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.PAPER) {
			if (Art5019injusticeModVariables.MapVariables.get(world).event_id == 0 || Art5019injusticeModVariables.MapVariables.get(world).event_id == 2) {
				Art5019injusticeModVariables.MapVariables.get(world).event_id = 2;
				Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Marti Li> Here it is, thanks for helping us to make a better world!"), false);
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Art5019injusticeModItems.FEAST_CARDS.get()).copy();
					_setstack.setCount((int) (3 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount()));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (sourceentity instanceof Player _player) {
					ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount(),
							_player.inventoryMenu.getCraftSlots());
				}
				return InteractionResult.SUCCESS;
			} else if (Art5019injusticeModVariables.MapVariables.get(world).event_id == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Martin Li> It's not a good idea for now, we must stay hidden until the supremacists go away."), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Martin Li> I think it's not a good time for that."), false);
			}
		} else {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						"<Martin Li> Hi, my name is Martin Li, I'm the owner of the FEAST shelter, if you ever find someone that is on need of help, you can give them some of the FEAST cards. But we're out of paper these days, I'll need some papers to print more cards.."),
						false);
		}
		return InteractionResult.PASS;
	}
}
