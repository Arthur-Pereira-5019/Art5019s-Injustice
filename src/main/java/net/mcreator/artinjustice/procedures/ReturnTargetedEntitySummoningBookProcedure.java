package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.UncleSamEntity;
import net.mcreator.artinjustice.entity.LokiBossEntity;

import java.util.function.Supplier;
import java.util.Map;

public class ReturnTargetedEntitySummoningBookProcedure {
	public static Entity execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return null;
		Entity target = null;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING) {
			target = world instanceof Level _level ? new LokiBossEntity(Art5019injusticeModEntities.LOKI_BOSS.get(), _level) : null;
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
				.getItem() == Art5019injusticeModItems.AMERICA_CONSTITUTION.get()) {
			target = world instanceof Level _level ? new UncleSamEntity(Art5019injusticeModEntities.UNCLE_SAM.get(), _level) : null;
		}
		return target;
	}
}
