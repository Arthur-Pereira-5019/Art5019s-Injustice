
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.procedures.ScarecrowNolanverseSuitHelmetTickEventProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import java.util.List;

import com.google.common.collect.Iterables;

public abstract class ScarecrowNolanverseSuitItem extends ArmorItem {
	public ScarecrowNolanverseSuitItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 17;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{2, 3, 4, 2}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 15;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.WHEAT), new ItemStack(Art5019injusticeModItems.FABRIC_GRAY.get()));
			}

			@Override
			public String getName() {
				return "scarecrow_nolanverse_suit";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, type, properties);
	}

	public static class Helmet extends ScarecrowNolanverseSuitItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Dr. Jonathan Crane (Earth 2)"));
			list.add(Component.literal("\u00A76Gotham Raider:"));
			list.add(Component.literal("\u00A7n  -With this full Suit Set and Scarecrow powers, everytime you enter a village, the Rage effect is applied on you"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/scarecrow__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				ScarecrowNolanverseSuitHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
			}
		}
	}

	public static class Chestplate extends ScarecrowNolanverseSuitItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Dr. Jonathan Crane (Earth 2)"));
			list.add(Component.literal("\u00A76Gotham Raider:"));
			list.add(Component.literal("\u00A7n  -With this full Suit Set and Scarecrow powers, everytime you enter a village, the Rage effect is applied on you"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/scarecrow__layer_1.png";
		}
	}

	public static class Leggings extends ScarecrowNolanverseSuitItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Dr. Jonathan Crane (Earth 2)"));
			list.add(Component.literal("\u00A76Gotham Raider:"));
			list.add(Component.literal("\u00A7n  -With this full Suit Set and Scarecrow powers, everytime you enter a village, the Rage effect is applied on you"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/scarecrow__layer_2.png";
		}
	}

	public static class Boots extends ScarecrowNolanverseSuitItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Dr. Jonathan Crane (Earth 2)"));
			list.add(Component.literal("\u00A76Gotham Raider:"));
			list.add(Component.literal("\u00A7n  -With this full Suit Set and Scarecrow powers, everytime you enter a village, the Rage effect is applied on you"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/scarecrow__layer_1.png";
		}
	}
}
