
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

import net.mcreator.artinjustice.procedures.BioEvolutiveSerumPerfectedRightClickedProcedure;

import java.util.List;

public class BioEvolutiveSerumPerfectedItem extends Item {
	public BioEvolutiveSerumPerfectedItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Bio Evolutive Serum (Quality: \u00A7bPerfect)"));
		list.add(Component.literal("May grant:"));
		list.add(Component.literal("Ultimate Proto-Human Type A: 63%"));
		list.add(Component.literal("Ultimate Proto-Human Type B: 30%"));
		list.add(Component.literal("Ultimate Proto-Human Type C: 7%"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		BioEvolutiveSerumPerfectedRightClickedProcedure.execute(entity, ar.getObject());
		return ar;
	}
}
