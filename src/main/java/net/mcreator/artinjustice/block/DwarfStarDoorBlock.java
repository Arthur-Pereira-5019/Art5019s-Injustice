
package net.mcreator.artinjustice.block;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import net.mcreator.artinjustice.procedures.DwarfStarDoorOnBlockRightClickedProcedure;

public class DwarfStarDoorBlock extends DoorBlock {
	public DwarfStarDoorBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.METAL).strength(200f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false), BlockSetType.STONE);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		 ItemStack heldItem = entity.getItemInHand(hand);

        if (heldItem.is(Art5019injusticeModItems.DWARF_STAR_KEY.get())) {
            return super.use(blockstate, world, pos, entity, hand, hit);
        } else {
            if (!world.isClientSide) {
                entity.displayClientMessage(Component.literal("§cYou will need a Dwarf Star Key to open this door."), true);
            }
            return InteractionResult.CONSUME;
        }
    }
}
