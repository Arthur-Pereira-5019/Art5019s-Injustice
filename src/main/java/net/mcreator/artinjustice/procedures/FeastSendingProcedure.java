package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.CriminalEntity;

public class FeastSendingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:arrestables")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 50
					&& (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()) || entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.WEAKNESS))
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) > 50 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 25) {
				if (!world.isClientSide()) {
					if (Math.random() < 0.25) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 10, 0.5, 0.5, 0.5, 1);
						if (entity instanceof CriminalEntity) {
							CriminalDropManagementProcedure.execute(world, x, y, z, entity);
						} else {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute as @p run loot spawn ~ ~ ~ kill @e[type=" + ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString() + ",limit=1,sort=nearest]"));
						}
						if (!entity.level().isClientSide())
							entity.discard();
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HEART, x, y, z, 40, 0.5, 0.5, 0.5, 1);
						AlignmentUpdateProcedure.execute(world, x, y, z, entity, sourceentity, 5);
						CriminalityRateChangeProcedure.execute(world, -0.001);
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:snyder_weakest_hater"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:hero_journey"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.FEAST_CARDS.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 6));
						if (Art5019injusticeModVariables.MapVariables.get(world).event_id == 2 && Art5019injusticeModVariables.MapVariables.get(world).event_meter < 0.95) {
							Art5019injusticeModVariables.MapVariables.get(world).event_meter = Art5019injusticeModVariables.MapVariables.get(world).event_meter + 0.025;
							Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
							if (Art5019injusticeModVariables.MapVariables.get(world).event_meter == 0.025) {
								Art5019injusticeModVariables.MapVariables.get(world).today_news = 41;
								Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
							} else if (Art5019injusticeModVariables.MapVariables.get(world).event_meter == 0.25) {
								Art5019injusticeModVariables.MapVariables.get(world).today_news = 42;
								Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
							} else if (Art5019injusticeModVariables.MapVariables.get(world).event_meter == 0.5) {
								Art5019injusticeModVariables.MapVariables.get(world).today_news = 43;
								Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
							} else if (Art5019injusticeModVariables.MapVariables.get(world).event_meter == 0.6) {
								Art5019injusticeModVariables.MapVariables.get(world).today_news = 44;
								Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
							} else if (Art5019injusticeModVariables.MapVariables.get(world).event_meter == 0.625) {
								Art5019injusticeModVariables.MapVariables.get(world).today_news = 45;
								Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
							}
						}
					} else {
						if (sourceentity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 140);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 40, 0.5, 0.5, 0.5, 1);
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7eI must try again!"), true);
					}
				}
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cStill too strong..."), true);
			}
		} else {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cCannot be arrested (at least on this way)..."), true);
		}
	}
}
