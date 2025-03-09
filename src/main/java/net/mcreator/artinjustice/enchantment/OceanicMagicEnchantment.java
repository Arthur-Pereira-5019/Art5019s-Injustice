
package net.mcreator.artinjustice.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;

import java.util.List;

public class OceanicMagicEnchantment extends Enchantment {
	public OceanicMagicEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.TRIDENT, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Art5019injusticeModEnchantments.ROYALTY.get()).contains(ench);
	}
}
