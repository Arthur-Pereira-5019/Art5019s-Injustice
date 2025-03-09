
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

import net.mcreator.artinjustice.procedures.StarkWalletRightclickedProcedure;

import java.util.List;

public class StarkWalletItem extends Item {
	public StarkWalletItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Mark III"));
		list.add(Component.literal("\u00A7eMight not work properly with multiple same-type wallets"));
		list.add(Component.literal("-Armor Capabilities:"));
		list.add(Component.literal(" .Fall Immunity"));
		list.add(Component.literal(" .Allows Levitation and Fly (1.5 Speed)"));
		list.add(Component.literal(" .100% Bulletproof"));
		list.add(Component.literal(" .Shoots: Flares, Missiles and Machine Gun Bullets, Repulsors and Unibeam"));
		list.add(Component.literal(" .Integrated JARVIS AI"));
		list.add(Component.literal(" .+5 Strength"));
		list.add(Component.literal(" .HUD"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		StarkWalletRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
