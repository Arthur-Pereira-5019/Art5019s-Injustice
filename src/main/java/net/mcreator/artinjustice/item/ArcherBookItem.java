
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.procedures.ArcherBookRightClickedProcedure;

import java.util.List;

public class ArcherBookItem extends Item {
	public ArcherBookItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Grants the Peak Human Superpower (Requires being powerless)"));
		list.add(Component.literal("Grants Power Experience and Skills to Vigilante-related superpowers"));
		list.add(Component.literal("If cannot fulfill any of those possibilities, will grant Experience Points"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ArcherBookRightClickedProcedure.execute(entity);
		return ar;
	}
}
