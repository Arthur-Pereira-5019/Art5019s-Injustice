
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

import net.mcreator.artinjustice.procedures.XGeneBloodSyringeRightClickedProcedure;

import java.util.List;

public class XGeneBloodSyringeItem extends Item {
	public XGeneBloodSyringeItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Fluid: Blood"));
		list.add(Component.literal("Sample: Unknown Homo superior genes"));
		list.add(Component.literal("Can be analyzed with a Tier 2 Lense or Higher on a Microscope"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		XGeneBloodSyringeRightClickedProcedure.execute(entity);
		return ar;
	}
}
