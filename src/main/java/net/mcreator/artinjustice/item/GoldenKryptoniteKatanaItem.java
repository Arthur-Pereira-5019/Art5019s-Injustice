
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.procedures.GoldenKryptoniteKatanaLivingEntityIsHitWithToolProcedure;
import net.mcreator.artinjustice.procedures.GoldenKryptoniteItemInIventoryTickProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class GoldenKryptoniteKatanaItem extends SwordItem {
	public GoldenKryptoniteKatanaItem() {
		super(new Tier() {
			public int getUses() {
				return 300;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 4;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.GOLDEN_KRYPTONITE.get()));
			}
		}, 3, -2.2f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		GoldenKryptoniteKatanaLivingEntityIsHitWithToolProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			GoldenKryptoniteItemInIventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}
}
