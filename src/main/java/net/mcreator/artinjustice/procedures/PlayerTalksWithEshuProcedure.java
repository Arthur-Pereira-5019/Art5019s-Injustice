package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;
import net.mcreator.artinjustice.entity.EshuEntity;

import java.util.List;
import java.util.Comparator;

public class PlayerTalksWithEshuProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Scaling = 0;
		ItemStack bottle = ItemStack.EMPTY;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof EshuEntity) {
					if ((entityiterator instanceof EshuEntity _datEntI ? _datEntI.getEntityData().get(EshuEntity.DATA_lastDay) : 0) + 20000 <= world.dayTime()) {
						if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.ALCOHOL_FLASK.get())) : false) {
							entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(
										"<Eshu> I'm ocuppied now, but I can see, you have walked a really interesting path to be here, I can help you, take that alcohol that you got with you, drop it nearby a candle and a chicken, I will use it to wash away the evil on your pathes whenever you need, wherever you are."),
										false);
							bottle = new ItemStack(Art5019injusticeModItems.ALCOHOL_FLASK.get());
							bottle.enchant(Art5019injusticeModEnchantments.ESHU_BINDING.get(), 1);
							if (entity instanceof Player _player) {
								ItemStack _setstack = bottle.copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.ALCOHOL_FLASK.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							if (entity instanceof EshuEntity _datEntSetI)
								_datEntSetI.getEntityData().set(EshuEntity.DATA_lastDay, (int) world.dayTime());
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(
										"<Eshu> Can't you see I'm ocuppied mortal? Get back here with some alcohol and maybe we can talk then. Just one more thing, judging forces you don't bother to understand will make them unbothered to understanding you at the day of your judgement. Have a nice day."),
										false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal(
											"<Eshu> Someone was faster and opened up their pathes, which closed yours, maybe tomorrow you'll renember sooner about me mortal. Come back again tomorrow with an alcohol bottle and maybe I'll help you."),
									false);
					}
				}
			}
		}
	}
}
