
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

import net.mcreator.artinjustice.procedures.PlagueBloodSyringeRightclickedProcedure;
import net.mcreator.artinjustice.procedures.PlagueBloodSyringeLivingEntityIsHitWithItemProcedure;

import java.util.List;

public class PlagueBloodSyringeItem extends Item {
	public PlagueBloodSyringeItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("-Fluid: Blood contamined with Yersinia pestis"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		PlagueBloodSyringeRightclickedProcedure.execute(entity, ar.getObject());
		return ar;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		PlagueBloodSyringeLivingEntityIsHitWithItemProcedure.execute(entity, sourceentity, itemstack);
		return retval;
	}
}
