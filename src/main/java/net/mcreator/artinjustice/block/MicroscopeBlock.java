
package net.mcreator.artinjustice.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.procedures.MicroscopeOnBlockRightClickedProcedure;
import net.mcreator.artinjustice.block.entity.MicroscopeBlockEntity;

public class MicroscopeBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public MicroscopeBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.METAL).strength(5f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(7, 1, 5, 9, 2, 11), box(7, 2, 4, 9, 3, 9), box(7, 3, 3, 9, 4, 5), box(7.5, 11, 3, 8.5, 16, 4), box(6, 5, 4, 10, 6, 10), box(7, 9, 4, 9, 11, 8), box(6, 8, 6, 7, 9, 7),
					box(9, 8, 6, 10, 9, 7), box(7.5, 8, 8, 8.5, 9, 9), box(6.5, 11, 6, 7.5, 12, 10), box(8.5, 11, 6, 9.5, 12, 10), box(7, 4, 3, 9, 10, 4), box(6, 7, 3, 7, 8, 4), box(9, 7, 3, 10, 8, 4));
			case NORTH -> Shapes.or(box(6, 0, 4, 10, 1, 12), box(7, 1, 5, 9, 2, 11), box(7, 2, 7, 9, 3, 12), box(7, 3, 11, 9, 4, 13), box(7.5, 11, 12, 8.5, 16, 13), box(6, 5, 6, 10, 6, 12), box(7, 9, 8, 9, 11, 12), box(9, 8, 9, 10, 9, 10),
					box(6, 8, 9, 7, 9, 10), box(7.5, 8, 7, 8.5, 9, 8), box(8.5, 11, 6, 9.5, 12, 10), box(6.5, 11, 6, 7.5, 12, 10), box(7, 4, 12, 9, 10, 13), box(9, 7, 12, 10, 8, 13), box(6, 7, 12, 7, 8, 13));
			case EAST -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(5, 1, 7, 11, 2, 9), box(4, 2, 7, 9, 3, 9), box(3, 3, 7, 5, 4, 9), box(3, 11, 7.5, 4, 16, 8.5), box(4, 5, 6, 10, 6, 10), box(4, 9, 7, 8, 11, 9), box(6, 8, 9, 7, 9, 10),
					box(6, 8, 6, 7, 9, 7), box(8, 8, 7.5, 9, 9, 8.5), box(6, 11, 8.5, 10, 12, 9.5), box(6, 11, 6.5, 10, 12, 7.5), box(3, 4, 7, 4, 10, 9), box(3, 7, 9, 4, 8, 10), box(3, 7, 6, 4, 8, 7));
			case WEST -> Shapes.or(box(4, 0, 6, 12, 1, 10), box(5, 1, 7, 11, 2, 9), box(7, 2, 7, 12, 3, 9), box(11, 3, 7, 13, 4, 9), box(12, 11, 7.5, 13, 16, 8.5), box(6, 5, 6, 12, 6, 10), box(8, 9, 7, 12, 11, 9), box(9, 8, 6, 10, 9, 7),
					box(9, 8, 9, 10, 9, 10), box(7, 8, 7.5, 8, 9, 8.5), box(6, 11, 6.5, 10, 12, 7.5), box(6, 11, 8.5, 10, 12, 9.5), box(12, 4, 7, 13, 10, 9), box(12, 7, 6, 13, 8, 7), box(12, 7, 9, 13, 8, 10));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		MicroscopeOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new MicroscopeBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof MicroscopeBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof MicroscopeBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
