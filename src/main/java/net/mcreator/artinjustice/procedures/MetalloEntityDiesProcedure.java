package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModGameRules;
import net.mcreator.artinjustice.entity.MetalloEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class MetalloEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Art5019injusticeMod.queueServerWork(2, () -> {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.METALLO_MALLET.get()) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
		});
		if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
			if (sourceentity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:stronger_than_kryptonite"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (!(entity instanceof MetalloEntity _datEntL7 && _datEntL7.getEntityData().get(MetalloEntity.DATA_artificial))) {
			Art5019injusticeModVariables.MapVariables.get(world).criminality_rate = Art5019injusticeModVariables.MapVariables.get(world).criminality_rate
					- ((world.getLevelData().getGameRules().getInt(Art5019injusticeModGameRules.CRIMINALITY_EVENT_CHANGE_PERCENTAGE)) / 100) * 0.0001;
			Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
