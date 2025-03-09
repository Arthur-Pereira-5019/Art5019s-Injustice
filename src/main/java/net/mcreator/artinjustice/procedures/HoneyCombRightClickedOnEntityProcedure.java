package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.entity.VoughtExecutiveEntity;
import net.mcreator.artinjustice.entity.StanTheLegendEntity;
import net.mcreator.artinjustice.entity.MrNegativeEntity;
import net.mcreator.artinjustice.entity.MayParkerEntity;
import net.mcreator.artinjustice.entity.KaleTheCaretakerEntity;
import net.mcreator.artinjustice.entity.FeastNPCEntity;
import net.mcreator.artinjustice.entity.CriminalEntity;
import net.mcreator.artinjustice.entity.ArtTheUnemployedEntity;

public class HoneyCombRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		boolean obtainedfingerprint = false;
		boolean canobtain = false;
		if (!(entity instanceof KaleTheCaretakerEntity)) {
			canobtain = true;
		}
		if (canobtain) {
			if ((itemstack.getOrCreateTag().getString("target1")).equals("None") || (itemstack.getOrCreateTag().getString("target1")).equals("")) {
				itemstack.getOrCreateTag().putString("target1", (entity.getStringUUID()));
				itemstack.getOrCreateTag().putString("target1name", (entity.getDisplayName().getString()));
				obtainedfingerprint = true;
			} else if (!(itemstack.getOrCreateTag().getString("target1")).equals(itemstack.getOrCreateTag().getString("target2"))
					&& ((itemstack.getOrCreateTag().getString("target2")).equals("Empty") || (itemstack.getOrCreateTag().getString("target2")).equals(""))) {
				itemstack.getOrCreateTag().putString("target2", (entity.getStringUUID()));
				itemstack.getOrCreateTag().putString("target2name", (entity.getDisplayName().getString()));
				if ((itemstack.getOrCreateTag().getString("target1name")).equals("???") && (itemstack.getOrCreateTag().getString("target1")).equals(itemstack.getOrCreateTag().getString("target2"))) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 0);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 0, false);
						}
					}
					itemstack.enchant(Enchantments.SMITE, 1);
					if (sourceentity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:identity_crisis_solver"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
					if (world instanceof ServerLevel _level)
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 2));
				}
				obtainedfingerprint = true;
			}
		}
		if (obtainedfingerprint) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 20, 1, 1, 1, 1);
			if (entity instanceof Villager) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity instanceof CriminalEntity) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 80, 0, false, false));
			} else if (entity instanceof ArtTheUnemployedEntity) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Art> The orange fat guy want's me back to my country?"), false);
			} else if (entity instanceof MayParkerEntity) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<May> Is that for any investigation related to Ben or Richard?"), false);
			} else if (entity instanceof FeastNPCEntity) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Paul Rabbit> Wait, the IRS sent you?"), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Stan> Who is suing me this time?"), false);
			} else if (entity instanceof StanTheLegendEntity) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Chris> I'm hoping this is not what I'm imagining you think from us..."), false);
			} else if (entity instanceof MrNegativeEntity) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Mr. Negative> What are you implying?"), false);
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), 2400, 1));
			} else if (entity instanceof VoughtExecutiveEntity) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(
									("<Vought Executive> Is this some sort of joke? Look, I don't know who you are, neither care about your insignificant existence. Vought will never, ever, ever, fall." + ReturnDynamicByeProcedure.execute(world))),
							false);
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 3600, 0, false, false));
			}
		}
	}
}
