
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.procedures.TWebShooterTier2ItemInInventoryTickProcedure;
import net.mcreator.artinjustice.procedures.TWebShooterTier1RightclickedProcedure;

import java.util.List;

public class TWebShooterTier1Item extends Item {
	public TWebShooterTier1Item() {
		super(new Item.Properties().durability(1600).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Tier 1"));
		list.add(Component.literal("Right-Click to Shoot"));
		list.add(Component.literal("Requires Web Cylinder"));
		list.add(Component.literal("K to Change Mode"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		TWebShooterTier1RightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		TWebShooterTier2ItemInInventoryTickProcedure.execute(itemstack);
	}
}
