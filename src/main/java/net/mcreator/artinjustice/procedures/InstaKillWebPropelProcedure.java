package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class InstaKillWebPropelProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double boost = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_2_BOOTS.get()) {
			boost = 0.3;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_2_LEGGINGS.get()) {
			boost = boost + 0.3;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_2_HELMET.get()) {
			boost = boost + 0.3;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_2_CHESTPLATE.get()) {
			boost = boost + 0.3;
		}
		entity.setDeltaMovement(new Vec3(((-1) * Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * (boost + 4.2)), ((-1) * Math.sin(Math.toRadians(entity.getXRot())) * (boost + 4.2)),
				(Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * (boost + 4.2))));
	}
}
