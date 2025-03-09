
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

public abstract class DeadpoolSuitItem extends ArmorItem {
	public DeadpoolSuitItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 21;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{3, 4, 5, 3}[type.getSlot().getIndex()];
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
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.FABRIC_RED.get()), new ItemStack(Art5019injusticeModItems.FABRIC_BLACK.get()));
			}

			@Override
			public String getName() {
				return "deadpool_suit";
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

	public static class Helmet extends DeadpoolSuitItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Wade Wilson (Earth 0)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A76Dirty Deeds Done Dirt Cheap:"));
			list.add(Component.literal("\u00A7n-By killing humans, or human-like beings, sometimes you got some extra payment (Requires respective Superpower)."));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/deadpool_comics__layer_1.png";
		}
	}

	public static class Chestplate extends DeadpoolSuitItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Wade Wilson (Earth 0)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A76Dirty Deeds Done Dirt Cheap:"));
			list.add(Component.literal("\u00A7n-By killing humans, or human-like beings, sometimes you got some extra payment (Requires respective Superpower)."));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/deadpool_comics__layer_1.png";
		}
	}

	public static class Leggings extends DeadpoolSuitItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Wade Wilson (Earth 0)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A76Dirty Deeds Done Dirt Cheap:"));
			list.add(Component.literal("\u00A7n-By killing humans, or human-like beings, sometimes you got some extra payment (Requires respective Superpower)."));
			list.add(Component.literal("-Magazine Support: Can stack up to 12 Magazine of Each Type"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/deadpool_comics__layer_2.png";
		}
	}

	public static class Boots extends DeadpoolSuitItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("Wade Wilson (Earth 0)"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("\u00A76Dirty Deeds Done Dirt Cheap:"));
			list.add(Component.literal("\u00A7n-By killing humans, or human-like beings, sometimes you got some extra payment (Requires respective Superpower)."));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/deadpool_comics__layer_1.png";
		}
	}
}
