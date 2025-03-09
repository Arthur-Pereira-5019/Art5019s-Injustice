
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
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

import net.mcreator.artinjustice.procedures.BlackPantherSuitHelmetTickEventProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import java.util.List;

import com.google.common.collect.Iterables;

public abstract class BlackPantherSuit2Item extends ArmorItem {
	public BlackPantherSuit2Item(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 148;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{18, 36, 48, 18}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.VIBRANIUM_INGOT.get()));
			}

			@Override
			public String getName() {
				return "black_panther_suit_2";
			}

			@Override
			public float getToughness() {
				return 10f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.5f;
			}
		}, type, properties);
	}

	public static class Helmet extends BlackPantherSuit2Item {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("T'Challa (Earth Prime)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A7a-Kinect Energy Storing:"));
			list.add(Component.literal("\u00A7n  -With the Full Suit, press Suit Ability 1 to release all the Kinectic Energy stored on your suit"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/black_panther_movies__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				BlackPantherSuitHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), itemstack);
			}
		}
	}

	public static class Chestplate extends BlackPantherSuit2Item {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("T'Challa (Earth Prime)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("-Claws: On critical with a free main-hand, there's a slight chance to apply or increase the bleeding effect on the enemy"));
			list.add(Component.literal("\u00A7a-Kinect Energy Storing:"));
			list.add(Component.literal("\u00A7n  -With the Full Suit, press Suit Ability 1 to release all the Kinectic Energy stored on your suit"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/black_panther_movies__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				BlackPantherSuitHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), itemstack);
			}
		}
	}

	public static class Leggings extends BlackPantherSuit2Item {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("T'Challa (Earth Prime)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A7a-Kinect Energy Storing:"));
			list.add(Component.literal("\u00A7n  -With the Full Suit, press Suit Ability 1 to release all the Kinectic Energy stored on your suit"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/black_panther_movies__layer_2.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				BlackPantherSuitHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), itemstack);
			}
		}
	}

	public static class Boots extends BlackPantherSuit2Item {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("T'Challa (Earth Prime)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A7a-Kinect Energy Storing:"));
			list.add(Component.literal("\u00A7n  -With the Full Suit, press Suit Ability 1 to release all the Kinectic Energy stored on your suit"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/black_panther_movies__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				BlackPantherSuitHelmetTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), itemstack);
			}
		}
	}
}
