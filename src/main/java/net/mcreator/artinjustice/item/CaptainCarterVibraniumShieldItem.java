
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.artinjustice.procedures.CaptainCarterVibraniumShieldLivingEntityIsHitWithToolProcedure;
import net.mcreator.artinjustice.procedures.CaptainCarterShieldEntitySwingsItemProcedure;

public class CaptainCarterVibraniumShieldItem extends ShieldItem {
	public CaptainCarterVibraniumShieldItem() {
		super(new Item.Properties().durability(0).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		CaptainCarterVibraniumShieldLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity);
		return retval;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		CaptainCarterShieldEntitySwingsItemProcedure.execute(entity);
		return retval;
	}
}
