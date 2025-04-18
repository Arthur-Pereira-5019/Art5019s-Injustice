
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.artinjustice.procedures.DwarfStarHammerEntitySwingsItemProcedure;

public class GoldenHammerItem extends PickaxeItem {
	public GoldenHammerItem() {
		super(new Tier() {
			public int getUses() {
				return 600;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.GOLD_INGOT));
			}
		}, 1, -3.3f, new Item.Properties());
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		DwarfStarHammerEntitySwingsItemProcedure.execute(entity.level(), entity, itemstack);
		return retval;
	}
}
