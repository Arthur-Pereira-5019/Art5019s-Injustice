package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

public class TWebShooterTier2ChooseFormProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("cadency") == 0) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("instaKill")) {
				InstaKillTier2RightClickedProcedure.execute(world, x, y, z, entity, itemstack);
			} else {
				TWebShooterTier2RightClickedProcedure.execute(world, x, y, z, entity, itemstack);
			}
		}
	}
}
