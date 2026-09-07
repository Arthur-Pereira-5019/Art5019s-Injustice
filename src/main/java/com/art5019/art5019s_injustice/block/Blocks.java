package com.art5019.art5019s_injustice.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.art5019.art5019s_injustice.Art5019sInjustice.BLOCKS;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
public class Blocks {
    public final static DeferredBlock<EngineeringTable> ENGINEERING_TABLE = BLOCKS.register("engineering_table", registryName -> new EngineeringTable(engineeringProperties(registryName)));

    public static BlockBehaviour.Properties engineeringProperties(Identifier registryName) {
        return BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK,registryName))
                .destroyTime(1.0f)
                .explosionResistance(8.0f)
                .sound(SoundType.METAL);
    }
}
