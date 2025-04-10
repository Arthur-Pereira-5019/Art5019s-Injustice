
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.artinjustice.procedures.DwarfStarHammerEntitySwingsItemProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class DwarfStarHammerItem extends PickaxeItem {
	public DwarfStarHammerItem() {
		super(new Tier() {
			public int getUses() {
				return 6000;
			}

			public float getSpeed() {
				return 13f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.DWARF_STAR.get()));
			}
		}, 1, -3.4f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		DwarfStarHammerEntitySwingsItemProcedure.execute(entity.level(), entity, itemstack);
		return retval;
	}
}
