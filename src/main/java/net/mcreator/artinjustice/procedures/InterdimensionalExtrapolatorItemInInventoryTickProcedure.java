package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class InterdimensionalExtrapolatorItemInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("leadsto")).equals("")) {
			itemstack.getOrCreateTag().putString("leadsto", "Random Earth");
		}
		{
			Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
			if (_enchantments.containsKey(Enchantments.MENDING)) {
				_enchantments.remove(Enchantments.MENDING);
				EnchantmentHelper.setEnchantments(_enchantments, itemstack);
			}
		}
	}
}
