package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

import java.util.List;
import java.util.Comparator;

public class GenericLaserProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double power) {
		if (entity == null)
			return;
		double Scaling = 0;
		double lx = 0;
		double ly = 0;
		double lz = 0;
		Entity target = null;
		if (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			world.setBlock(BlockPos.containing(x, y, z), Art5019injusticeModBlocks.TEMP_LIGHT_BLOCK.get().defaultBlockState(), 3);
		}
		for (int index0 = 0; index0 < (int) (power * 12); index0++) {
			lx = entity.getX() + entity.getLookAngle().x * Scaling;
			ly = entity.getY() + 1.65 + entity.getLookAngle().y * Scaling;
			lz = entity.getZ() + entity.getLookAngle().z * Scaling;
			if ((world.getBlockState(BlockPos.containing(lx, ly, lz))).is(BlockTags.create(new ResourceLocation("art5019injustice:laser_ignore")))) {
				Scaling = Scaling + 1;
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(lx, ly, lz), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~ ~-1 ~ ~ ~1 ~ fire replace #forge:any_air");
				break;
			}
			GenerateDustParticlesProcedure.execute(world, lx, ly, lz, "" + new java.text.DecimalFormat("##").format(power * 1.1), "0.2", "0.2", "0.2", "1.000 0.000 0.000 1", "1");
			{
				final Vec3 _center = new Vec3(lx, ly, lz);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (entityiterator instanceof ItemEntity) {
							if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getRarity() == Rarity.COMMON) {
								if (Math.random() < 0.7) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LAVA)), (float) (power / 2));
								}
								entityiterator.setSecondsOnFire((int) (power * 1.5));
							}
						} else {
							if (Math.random() < 0.7) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LAVA)), (float) (power / 2));
							}
							entityiterator.setSecondsOnFire((int) (power * 1.5));
						}
					}
				}
			}
		}
	}
}
