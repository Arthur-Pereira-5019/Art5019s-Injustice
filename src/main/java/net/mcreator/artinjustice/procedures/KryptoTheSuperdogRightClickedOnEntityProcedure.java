package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;

public class KryptoTheSuperdogRightClickedOnEntityProcedure {
	public static InteractionResult execute(Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BONE) {
			return InteractionResult.FAIL;
		}
		return InteractionResult.PASS;
	}
}
