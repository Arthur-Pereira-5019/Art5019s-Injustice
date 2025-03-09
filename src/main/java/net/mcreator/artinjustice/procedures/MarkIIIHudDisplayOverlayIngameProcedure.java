package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class MarkIIIHudDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.IRON_MAN_MARK_III_HELMET.get()) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.INTERFERENCE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.INTERFERENCE.get()).getAmplifier() : 0) == 0
					|| !(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(Art5019injusticeModMobEffects.INTERFERENCE.get()))) {
				return true;
			}
			return false;
		}
		return false;
	}
}
