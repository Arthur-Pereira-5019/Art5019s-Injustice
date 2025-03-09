
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import java.util.List;

public abstract class NegativeSpidermanSuitItem extends ArmorItem {
	public NegativeSpidermanSuitItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 29;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{3, 6, 7, 3}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 35;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.SEWING_KIT.get()));
			}

			@Override
			public String getName() {
				return "negative_spiderman_suit";
			}

			@Override
			public float getToughness() {
				return 0.4f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, type, properties);
	}

	public static class Helmet extends NegativeSpidermanSuitItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Peter Parker (Earth 5)"));
			list.add(Component.literal("\u00A7a-Negative Shockwave:"));
			list.add(Component.literal("\u00A7n-Press Suit Ability 1 Button to release a blast of negative energy (2.5 Minutes Cooldown)"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/negative_spiderman__layer_1.png";
		}
	}

	public static class Chestplate extends NegativeSpidermanSuitItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Peter Parker (Earth 5)"));
			list.add(Component.literal("\u00A7a-Negative Shockwave:"));
			list.add(Component.literal("\u00A7n-Press Suit Ability 1 Button to release a blast of negative energy (2.5 Minutes Cooldown)"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/negative_spiderman__layer_1.png";
		}
	}

	public static class Leggings extends NegativeSpidermanSuitItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Peter Parker (Earth 5)"));
			list.add(Component.literal("\u00A7a-Negative Shockwave:"));
			list.add(Component.literal("\u00A7n-Press Suit Ability 1 Button to release a blast of negative energy (2.5 Minutes Cooldown)"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/negative_spiderman__layer_2.png";
		}
	}

	public static class Boots extends NegativeSpidermanSuitItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Peter Parker (Earth 5)"));
			list.add(Component.literal("\u00A7a-Negative Shockwave:"));
			list.add(Component.literal("\u00A7n-Press Suit Ability 1 Button to release a blast of negative energy (2.5 Minutes Cooldown)"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/negative_spiderman__layer_1.png";
		}
	}
}
