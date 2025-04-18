
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.procedures.HammerGenericRayCastProcedure;
import net.mcreator.artinjustice.procedures.DwarfStarItemInInventoryTickProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class DwarfStarHammerItem extends PickaxeItem {
	public DwarfStarHammerItem() {
		super(new Tier() {
			public int getUses() {
				return 10000;
			}

			public float getSpeed() {
				return 13f;
			}

			public float getAttackDamageBonus() {
				return 7f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 30;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.DWARF_STAR.get()));
			}
		}, 1, -3.4f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		HammerGenericRayCastProcedure.execute(entity.level(), entity, itemstack);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		DwarfStarItemInInventoryTickProcedure.execute(entity);
	}
}
