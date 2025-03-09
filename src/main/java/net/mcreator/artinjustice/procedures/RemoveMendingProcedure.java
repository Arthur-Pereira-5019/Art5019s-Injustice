package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class RemoveMendingProcedure {
	public static void execute(ItemStack itemstack) {
		{
			Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
			if (_enchantments.containsKey(Enchantments.MENDING)) {
				_enchantments.remove(Enchantments.MENDING);
				EnchantmentHelper.setEnchantments(_enchantments, itemstack);
			}
		}
	}
}
