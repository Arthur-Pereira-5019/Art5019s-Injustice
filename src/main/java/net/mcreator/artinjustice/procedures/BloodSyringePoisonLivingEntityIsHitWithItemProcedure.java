package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class BloodSyringePoisonLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:not_has_blood")))) {
			if (itemstack.getOrCreateTag().getDouble("diseaseId") == 0) {
				itemstack.getOrCreateTag().putDouble("diseaseId", SetBloodDiseaseProcedure.execute(world, 1));
			}
			GenericApplyDiseaseProcedure.execute(entity, itemstack.getOrCreateTag().getDouble("diseaseId"));
			AlignmentUpdateProcedure.execute(world, x, y, z, entity, sourceentity, -20);
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = itemstack;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.EMPTY_SYRINGE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
