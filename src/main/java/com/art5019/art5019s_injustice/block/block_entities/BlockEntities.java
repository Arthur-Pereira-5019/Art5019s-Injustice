package com.art5019.art5019s_injustice.block.block_entities;

import com.art5019.art5019s_injustice.block.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static final Supplier<BlockEntityType<EngineeringTableBlockEntity>> ENGINEERING_TABLE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "engineering_table_block_entity",
            () -> new BlockEntityType<>(
                    EngineeringTableBlockEntity::new,
                    false,
                    Blocks.ENGINEERING_TABLE.get()
            )
    );


}
