
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.procedures.EnrichedAxeToolInInventoryTickProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class EnrichedPickaxeItem extends PickaxeItem {
	public EnrichedPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 999;
			}

			public float getSpeed() {
				return 13f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.ENRICHED_URANIUM.get()));
			}
		}, 1, -3f, new Item.Properties());
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EnrichedAxeToolInInventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), itemstack);
	}
}
