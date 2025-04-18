
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.artinjustice.procedures.DwarfStarHammerEntitySwingsItemProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class SteelHammerItem extends PickaxeItem {
	public SteelHammerItem() {
		super(new Tier() {
			public int getUses() {
				return 1666;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 5f;
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
		}, 1, -3.4f, new Item.Properties());
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		DwarfStarHammerEntitySwingsItemProcedure.execute(entity.level(), entity, itemstack);
		return retval;
	}
}
