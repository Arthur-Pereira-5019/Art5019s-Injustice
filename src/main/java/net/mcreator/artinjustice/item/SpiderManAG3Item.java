
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

public abstract class SpiderManAG3Item extends ArmorItem {
	public SpiderManAG3Item(ArmorItem.Type type, Item.Properties properties) {
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
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.FABRIC_RED.get()), new ItemStack(Art5019injusticeModItems.FABRIC_BLUE.get()));
			}

			@Override
			public String getName() {
				return "spider_man_ag_3";
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

	public static class Helmet extends SpiderManAG3Item {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Peter Parker (Earth 1)"));
			list.add(Component.literal("Second version"));
			list.add(Component.literal("\u00A76Electro-Buster"));
			list.add(Component.literal("\u00A7n  -With the full Suit Set and having Spider powers, you're completely immune to Lightning"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/spider_man_laag3__layer_1.png";
		}
	}

	public static class Chestplate extends SpiderManAG3Item {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Peter Parker (Earth 1)"));
			list.add(Component.literal("Second version"));
			list.add(Component.literal("\u00A76Electro-Buster"));
			list.add(Component.literal("\u00A7n  -With the full Suit Set and having Spider powers, you're completely immune to Lightning"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/spider_man_laag3__layer_1.png";
		}
	}

	public static class Leggings extends SpiderManAG3Item {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Peter Parker (Earth 1)"));
			list.add(Component.literal("Second version"));
			list.add(Component.literal("\u00A76Electro-Buster"));
			list.add(Component.literal("\u00A7n  -With the full Suit Set and having Spider powers, you're completely immune to Lightning"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/spider_man_laag3__layer_2.png";
		}
	}

	public static class Boots extends SpiderManAG3Item {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Peter Parker (Earth 1)"));
			list.add(Component.literal("Second version"));
			list.add(Component.literal("\u00A76Electro-Buster"));
			list.add(Component.literal("\u00A7n  -With the full Suit Set and having Spider powers, you're completely immune to Lightning"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/spider_man_laag3__layer_1.png";
		}
	}
}
