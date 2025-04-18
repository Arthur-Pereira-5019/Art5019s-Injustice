
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class SteelHoeItem extends HoeItem {
	public SteelHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 666;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 7f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 7;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.STEEL_INGOT.get()));
			}
		}, 0, -2.3f, new Item.Properties());
	}
}
