package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SpaceStoneLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double propel = 0;
		double distance = 0;
		double impact = 0;
		double power = 0;
		double radius = 0;
		if (itemstack.getOrCreateTag().getDouble("mode") == 4) {
			if (entity.getZ() >= entity.getZ()) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), 3));
			} else {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (-3)));
			}
			if (entity.getY() >= entity.getY()) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 3, (entity.getDeltaMovement().z())));
			} else {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-3), (entity.getDeltaMovement().z())));
			}
			if (entity.getX() >= entity.getX()) {
				entity.setDeltaMovement(new Vec3(3, (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
			} else {
				entity.setDeltaMovement(new Vec3((-3), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 0.000 0.867 1.000 1 ~ ~ ~ 0.4 0.4 0.4 1 600 normal");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.spacestone.freeze")), SoundSource.NEUTRAL, (float) 0.6, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.spacestone.freeze")), SoundSource.NEUTRAL, (float) 0.6, 1, false);
				}
			}
			sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:radiation_damage")))), 3);
			itemstack.getOrCreateTag().putDouble("cadency", 200);
		}
	}
}
