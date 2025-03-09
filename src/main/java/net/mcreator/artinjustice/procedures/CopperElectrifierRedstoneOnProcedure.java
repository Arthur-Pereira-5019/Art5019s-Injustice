package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

import java.util.Comparator;

public class CopperElectrifierRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!(blockstate.getBlock().getStateDefinition().getProperty("activated") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1))) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("activated") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
			}
		}
		sx = -5;
		for (int index0 = 0; index0 < 11; index0++) {
			sy = -2;
			for (int index1 = 0; index1 < 5; index1++) {
				sz = -5;
				for (int index2 = 0; index2 < 11; index2++) {
					if ((new ItemStack((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock())).is(ItemTags.create(new ResourceLocation("forge:copper_blocks")))) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, (x + sx), (y + sy + 1), (z + sz), 10, 0.5, 0.5, 0.5, 0.4);
						if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + sx), (y + sy), (z + sz)), 4, 4, 4), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((x + sx), (y + sy), (z + sz))).findFirst().orElse(null)) == null)) {
							if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + sx), (y + sy), (z + sz)), 4, 4, 4), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((x + sx), (y + sy), (z + sz))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ELECTRICITY.get(), 100, 2, false, false));
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
