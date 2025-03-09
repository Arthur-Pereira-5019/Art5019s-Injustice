
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

import net.mcreator.artinjustice.procedures.WebCylinderRightclickedProcedure;

import java.util.List;

public class TrichloroethyleneItem extends Item {
	public TrichloroethyleneItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Content: Trichloroethylene Gas"));
		list.add(Component.literal("Generic Use: Anesthesic Gas (U = 80)"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		WebCylinderRightclickedProcedure.execute(entity);
		return ar;
	}
}
