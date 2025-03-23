package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class BountyPaperRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		boolean sucess = false;
		double hirePower = 0;
		double iteration = 0;
		double ry = 0;
		double rx = 0;
		double rz = 0;
		hirePower = new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(0) * 2 + new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(1) + new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(2) * 10;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entityiterator.getDisplayName().getString()).equals(guistate.containsKey("text:KillTarget") ? ((EditBox) guistate.get("text:KillTarget")).getValue() : "")) {
				if (hirePower < 20) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("But nobody came."), false);
					sucess = true;
				} else if (hirePower < 70) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute at " + (guistate.containsKey("text:KillTarget") ? ((EditBox) guistate.get("text:KillTarget")).getValue() : "") + " run summon art5019injustice:scarecrow_i"));
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Scarecrow Hired"), false);
					Art5019injusticeModVariables.MapVariables.get(world).today_news = 2;
					Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
					sucess = true;
				} else if (hirePower >= 75) {
					while (iteration <= 15 && sucess == false) {
						ry = Mth.nextInt(RandomSource.create(), 0, 6) + y;
						rz = Mth.nextInt(RandomSource.create(), -10, 10) + z;
						rx = Mth.nextInt(RandomSource.create(), -10, 10) + x;
						if (!world.getBlockState(BlockPos.containing(rx, ry, rz)).canOcclude() && !world.getBlockState(BlockPos.containing(rx, ry + 1, rz)).canOcclude()) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = Art5019injusticeModEntities.DEATHSTROKE.get().spawn(_level, BlockPos.containing(rx, ry, rz), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Deathstroke Hired"), false);
							Art5019injusticeModVariables.MapVariables.get(world).today_news = 3;
							Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
							sucess = true;
						} else {
							iteration = iteration + 1;
						}
					}
				}
			}
		}
		if (sucess) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(0)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(1)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(2)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.BOUNTY_PAPER.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wandering_trader.trade")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wandering_trader.trade")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("But nobody came"), false);
		}
	}
}
