package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class GreenEssenceAppliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double timer = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SUNFLOWER) {
			for (int index0 = 0; index0 < 10; index0++) {
				timer = timer + 1;
				Art5019injusticeMod.queueServerWork((int) (15 * timer), () -> {
					SuperFertilizerSunflowerEffectProcedure.execute(world, x, y, z, entity);
				});
			}
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_sunflower"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.RARE_BLUE_FLOWER.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon area_effect_cloud ~ ~ ~ {ReapplicationDelay:90,Color:0,Radius:4,Duration:400,WaitTime:100,Potion:\"art5019injustice:scarecrow_formula\"}");
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_rare_blue_flower"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WITHER_ROSE) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon area_effect_cloud ~ ~ ~ {ReapplicationDelay:80,Color:0,Radius:4,Duration:400,WaitTime:100,Effects:[{Id:20,Duration:200,Amplifier:1,ShowParticles:1b,ShowIcon:1}]}");
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_wither_rose"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:tulips")))) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon area_effect_cloud ~ ~ ~ {ReapplicationDelay:40,Color:65280,Radius:4,Duration:400,WaitTime:100,Potion:\"art5019injustice:allergy_potion\"}");
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_tulip"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DANDELION) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon area_effect_cloud ~ ~ ~ {ReapplicationDelay:40,Color:3046700,Radius:4,Duration:600,WaitTime:100,Potion:\"art5019injustice:hunger_potion\"}");
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_dandelion"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:sand")))) {
			if (Blocks.CACTUS.defaultBlockState().canSurvive(world, BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.CACTUS.defaultBlockState(), 3);
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_sand"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AZURE_BLUET) {
			SuperFertilizerAzureBluetEffectProcedure.execute(world, x, y, z);
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_azure_bluets"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:orchids")))) {
			SuperFertilizerOrchidEffectProcedure.execute(world, x, y, z, entity);
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_orchids"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AZALEA || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWERING_AZALEA) {
			RootedDirtSuperFertilizerEffectProcedure.execute(world, x, y, z, entity);
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_azalea_trees"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ROSE_BUSH || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CACTUS
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SWEET_BERRY_BUSH) {
			PricklyPathOnBoneMealSuccessProcedure.execute(world, x, y, z);
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_prickly_path"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.PEONY || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.ALOE_VERA.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon area_effect_cloud ~ ~ ~ {ReapplicationDelay:80,Color:12278963,Radius:3,Duration:400,WaitTime:20,Potion:\"strong_regeneration\"}");
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_aloe_vera"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LILY_OF_THE_VALLEY) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon area_effect_cloud ~ ~ ~ {ReapplicationDelay:60,Color:2970918,Radius:4,Duration:400,WaitTime:100,Potion:\"minecraft:poison\"}");
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_lily_of_the_valley"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.MOSS_BLOCK) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~4 ~4 ~4 ~-4 ~-4 ~-4 moss_block replace #minecraft:moss_replaceable");
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_moss"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.VINE) {
			VinesSuperFertilizerEffectProcedure.execute(world, x, y, z);
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_vine"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.VENUS_FLY_TRAP.get()) {
			SuperFertilizerOnVenusFlyTrapProcedure.execute(world, x, y, z);
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:green_effect_venus_fly_trap"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (world instanceof Level _level) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
				if (!_level.isClientSide())
					_level.levelEvent(2005, _bp, 0);
			}
		}
		if ((world.getBlockState(BlockPos.containing(3 + x, y, z + 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 + x, y, z + 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(3 + x, y + 1, z + 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 + x, y + 1, z + 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(3 + x, y - 1, z + 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 + x, y - 1, z + 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(3 + x, y, z - 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 + x, y, z - 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(3 + x, y + 1, z - 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 + x, y + 1, z - 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(3 + x, y - 1, z - 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 + x, y - 1, z - 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(3 - x, y, z - 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 - x, y, z - 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(3 - x, y + 1, z - 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 - x, y + 1, z - 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(3 - x, y - 1, z - 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 - x, y - 1, z - 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(3 - x, y, z + 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 - x, y, z + 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(3 - x, y + 1, z + 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 - x, y + 1, z + 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(3 - x, y - 1, z + 3))).getBlock() instanceof BonemealableBlock) {
			if (world instanceof Level _level) {
				BlockPos _bp = BlockPos.containing(3 - x, y - 1, z + 3);
				if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
					if (!_level.isClientSide())
						_level.levelEvent(2005, _bp, 0);
				}
			}
		}
	}
}
