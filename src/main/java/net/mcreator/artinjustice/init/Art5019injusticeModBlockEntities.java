
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.artinjustice.block.entity.SignalMachineBlockEntity;
import net.mcreator.artinjustice.block.entity.SawmillBlockEntity;
import net.mcreator.artinjustice.block.entity.PuzzleBlockBlockEntity;
import net.mcreator.artinjustice.block.entity.PetriTableBlockBlockEntity;
import net.mcreator.artinjustice.block.entity.MicroscopeBlockEntity;
import net.mcreator.artinjustice.block.entity.MeteoriteBlockEntity;
import net.mcreator.artinjustice.block.entity.LockedDoorBlockEntity;
import net.mcreator.artinjustice.block.entity.CorpseBlockEntity;
import net.mcreator.artinjustice.block.entity.ComputerBlockEntity;
import net.mcreator.artinjustice.block.entity.ChemistryTableBlockEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Art5019injusticeMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CHEMISTRY_TABLE = register("chemistry_table", Art5019injusticeModBlocks.CHEMISTRY_TABLE, ChemistryTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> METEORITE = register("meteorite", Art5019injusticeModBlocks.METEORITE, MeteoriteBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MICROSCOPE = register("microscope", Art5019injusticeModBlocks.MICROSCOPE, MicroscopeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COMPUTER = register("computer", Art5019injusticeModBlocks.COMPUTER, ComputerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SIGNAL_MACHINE = register("signal_machine", Art5019injusticeModBlocks.SIGNAL_MACHINE, SignalMachineBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SAWMILL = register("sawmill", Art5019injusticeModBlocks.SAWMILL, SawmillBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LOCKED_DOOR = register("locked_door", Art5019injusticeModBlocks.LOCKED_DOOR, LockedDoorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CORPSE = register("corpse", Art5019injusticeModBlocks.CORPSE, CorpseBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PETRI_TABLE_BLOCK = register("petri_table_block", Art5019injusticeModBlocks.PETRI_TABLE_BLOCK, PetriTableBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PUZZLE_BLOCK = register("puzzle_block", Art5019injusticeModBlocks.PUZZLE_BLOCK, PuzzleBlockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
