package com.art5019.art5019s_injustice.block;

import net.minecraft.world.item.BlockItem;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.art5019.art5019s_injustice.Art5019sInjustice.ITEMS;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.block.Blocks.ENGINEERING_TABLE;

@Mod(MODID)
public class BlockItems {
    public static final DeferredItem<BlockItem> ENGINEERING_TABLE_ITEM = ITEMS.registerSimpleBlockItem(
            "engineering_table",
            ENGINEERING_TABLE,
            props -> props
    );
}
