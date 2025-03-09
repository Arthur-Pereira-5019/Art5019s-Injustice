package net.mcreator.artinjustice.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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

import net.mcreator.artinjustice.procedures.BlueScarabMakeItemGlowProcedure;
import net.mcreator.artinjustice.procedures.IronManMarkIIITickProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;


import java.util.List;


public abstract class IronManMarkIIIItem extends ArmorItem {
	public IronManMarkIIIItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 63;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{6, 8, 9, 5}[type.getSlot().getIndex()];
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
				return Ingredient.of(new ItemStack(Art5019injusticeModItems.GOLD_TITANIUM_INGOT.get()));
			}

			@Override
			public String getName() {
				return "iron_man_mark_iii";
			}

			@Override
			public float getToughness() {
				return 4f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.3f;
			}
		}, type, properties);
	}

	public static class Helmet extends IronManMarkIIIItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean isFoil(ItemStack itemstack) {
			return BlueScarabMakeItemGlowProcedure.execute();
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("HUD"));
			list.add(Component.literal("Type Help to see Jarvis full voice commands list"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("-Ability 1 to Deactivate Suit"));
			list.add(Component.literal("Can be disabled with Interference II or Higher"));

		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/iron_man_mark_3__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			IronManMarkIIITickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		}


	}

	public static class Chestplate extends IronManMarkIIIItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean isFoil(ItemStack itemstack) {
			return BlueScarabMakeItemGlowProcedure.execute();
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("Can Shot: Missiles and Machine Gun Bullets via Ability 5"));
			list.add(Component.literal("Press Ability 2 to Shot Repulsor Blasts and Ability 4 to Fire the Unibeam"));
			list.add(Component.literal("-Bulletproof"));
			list.add(Component.literal("-Fly Speed: 1.5"));
			list.add(Component.literal("-Passive - + 5 Strength"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/iron_man_mark_3__layer_1.png";
		}

	}

	public static class Leggings extends IronManMarkIIIItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean isFoil(ItemStack itemstack) {
			return BlueScarabMakeItemGlowProcedure.execute();
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("Can Shot: Flares via Suit Ability 1"));
			list.add(Component.literal("-Bulletproof"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/iron_man_mark_3__layer_2.png";
		}

	}

	public static class Boots extends IronManMarkIIIItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean isFoil(ItemStack itemstack) {
			return BlueScarabMakeItemGlowProcedure.execute();
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("Makes you Fall Immune"));
			list.add(Component.literal("Allows you to levitate and fly using Ability 3"));
			list.add(Component.literal("-Bulletproof"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "art5019injustice:textures/models/armor/iron_man_mark_3__layer_1.png";
		}

	}
}
