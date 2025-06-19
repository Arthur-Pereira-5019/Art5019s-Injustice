package net.mcreator.artinjustice.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import java.util.concurrent.atomic.AtomicReference;

public class ReturnSawPowerProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String power = "";
		ItemStack compareto = ItemStack.EMPTY;
		ItemStack gear = ItemStack.EMPTY;
		double sawingpower = 0;
		double providedsawingpower = 0;
		compareto = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 1));
		gear = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0));
		if (compareto.is(ItemTags.create(new ResourceLocation("art5019injustice:tier_2_sawables")))) {
			sawingpower = 2;
		} else if (compareto.getItem() == Items.COAL) {
			sawingpower = 1;
		} else if (compareto.getItem() == Art5019injusticeModItems.STEEL_INGOT.get() || compareto.getItem() == Art5019injusticeModItems.ELEKTRUM_METAL.get() || compareto.getItem() == Art5019injusticeModItems.KRYPTONITE.get()) {
			sawingpower = 3;
		} else if (compareto.getItem() == Art5019injusticeModItems.IRIDIUM_INGOT.get() || compareto.getItem() == Art5019injusticeModItems.GOLD_TITANIUM_INGOT.get()) {
			sawingpower = 4;
		} else if (compareto.getItem() == Art5019injusticeModItems.VIBRANIUM_INGOT.get()) {
			sawingpower = 5;
		}
		if (gear.getItem() == Art5019injusticeModItems.WOODEN_SAW.get()) {
			providedsawingpower = 1;
		} else if (gear.getItem() == Art5019injusticeModItems.IRON_SAW.get()) {
			providedsawingpower = 2;
		} else if (gear.getItem() == Art5019injusticeModItems.STEEL_SAW.get()) {
			providedsawingpower = 3;
		} else if (gear.getItem() == Art5019injusticeModItems.VIBRANIUM_SAW.get()) {
			providedsawingpower = 6;
		}
		if (providedsawingpower == sawingpower) {
			return "Required Power: " + sawingpower;
		} else if (providedsawingpower > sawingpower) {
			return "\u00A7aRequired Power: " + sawingpower;
		}
		return "\u00A7cRequired Power: " + sawingpower;
	}
}
