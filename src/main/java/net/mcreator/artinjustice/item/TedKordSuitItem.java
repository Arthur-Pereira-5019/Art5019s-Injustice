
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

public abstract class TedKordSuitItem extends ArmorItem {
	public TedKordSuitItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 21;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{5, 6, 6, 4}[type.getSlot().getIndex()];
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
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.SEWING_KIT.get()));
			}

			@Override
			public String getName() {
				return "ted_kord_suit";
			}

			@Override
			public float getToughness() {
				return 0.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, type, properties);
	}

	public static class Helmet extends TedKordSuitItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Ted Kord (Earth Prime)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A7e-Radiation Proof"));
			list.add(Component.literal("\u00A76Kord Tech:"));
			list.add(Component.literal("\u00A7n  -Each piece of this Suit Set adds one fourth of a 20% boost to any \u00A73Kord Tech \u00A7fweapon"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/tkbluebeetle2__layer_1.png";
		}
	}

	public static class Chestplate extends TedKordSuitItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Ted Kord (Earth Prime)"));
			list.add(Component.literal("Suction Pads (Key: Suit Ability 1)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A7e-Radiation Proof"));
			list.add(Component.literal("\u00A76Kord Tech:"));
			list.add(Component.literal("\u00A7n  -Each piece of this Suit Set adds one fourth of a 20% boost to any \u00A73Kord Tech \u00A7fweapon"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/tkbluebeetle2__layer_1.png";
		}
	}

	public static class Leggings extends TedKordSuitItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Ted Kord (Earth Prime)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A7e-Radiation Proof"));
			list.add(Component.literal("\u00A76Kord Tech:"));
			list.add(Component.literal("\u00A7n  -Each piece of this Suit Set adds one fourth of a 20% boost to any \u00A73Kord Tech \u00A7fweapon"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/tkbluebeetle2__layer_2.png";
		}
	}

	public static class Boots extends TedKordSuitItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Ted Kord (Earth Prime)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A7e-Radiation Proof"));
			list.add(Component.literal("\u00A76Kord Tech:"));
			list.add(Component.literal("\u00A7n  -Each piece of this Suit Set adds one fourth of a 20% boost to any \u00A73Kord Tech \u00A7fweapon"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/tkbluebeetle2__layer_1.png";
		}
	}
}
