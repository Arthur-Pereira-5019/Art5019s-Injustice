package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class GoldenKryptonitePoisoningOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		double kr = 0;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getDuration() : 0)
				% 200 == 0) {
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
				if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
						&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance_iv"))).isDone()) {
					kr = 4;
				} else if (entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel
						&& _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance_iii"))).isDone()) {
					kr = 3;
				} else if (entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
						&& _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance_ii"))).isDone()) {
					kr = 2;
				} else if (entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel
						&& _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance"))).isDone()) {
					kr = 1;
				} else {
					kr = 0;
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
						? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getDuration()
						: 0) >= 1600 + kr * 400) {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
							? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getAmplifier()
							: 0) <= 5) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get(), 100,
									(int) (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
											? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getAmplifier()
											: 0))));
					} else {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:superman_golden_kryptonite"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						ResetProcedure.execute(world, entity);
					}
				}
				if (Math.random() < 0.15 * amplifier) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get(), 120, 0));
				}
				if (Math.random() < 0.07 * amplifier) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(), 120, 0));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle dust 1.000 0.867 0.000 1 ~ ~ ~ 1 1 1 1 3 normal");
			}
		}
	}
}
