
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.procedures.EnrichedSwordLivingEntityIsHitWithToolProcedure;
import net.mcreator.artinjustice.procedures.EnrichedAxeToolInInventoryTickProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class EnrichedSwordItem extends SwordItem {
	public EnrichedSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 666;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.ENRICHED_URANIUM.get()));
			}
		}, 3, -2.6f, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		EnrichedSwordLivingEntityIsHitWithToolProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EnrichedAxeToolInInventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), itemstack);
	}
}
