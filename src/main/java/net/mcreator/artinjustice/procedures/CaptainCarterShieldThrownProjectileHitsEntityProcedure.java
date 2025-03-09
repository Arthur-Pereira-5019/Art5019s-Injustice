package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class CaptainCarterShieldThrownProjectileHitsEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double dis = 0;
		dis = Math.sqrt(Math.pow(entity.getX() - sourceentity.getX(), 2) + Math.pow(entity.getY() - sourceentity.getY(), 2) + Math.pow(sourceentity.getZ() - entity.getZ(), 2));
		Art5019injusticeMod.queueServerWork((int) (dis + 2), () -> {
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.CAPTAIN_CARTER_VIBRANIUM_SHIELD.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		});
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
