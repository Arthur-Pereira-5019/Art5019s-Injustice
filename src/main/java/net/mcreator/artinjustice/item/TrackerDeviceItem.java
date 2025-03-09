
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.procedures.TrackerDeviceRightclickedProcedure;
import net.mcreator.artinjustice.procedures.TrackerDeviceLivingEntityIsHitWithItemProcedure;

import java.util.List;

public class TrackerDeviceItem extends Item {
	public TrackerDeviceItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Frequency can be set with Right-Click"));
		list.add(Component.literal("Is attached upon damage"));
		list.add(Component.literal("Send signals when it's wielder is hurt"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		TrackerDeviceRightclickedProcedure.execute(entity, ar.getObject());
		return ar;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TrackerDeviceLivingEntityIsHitWithItemProcedure.execute(entity, sourceentity, itemstack);
		return retval;
	}
}
