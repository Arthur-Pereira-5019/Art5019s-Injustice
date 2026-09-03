package com.art5019.art5019s_injustice.graphics.item_rendering;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.SKILL_COMPONENT;

public record BookTierRendering() implements RangeSelectItemModelProperty {

    public static final MapCodec<BookTierRendering> MAP_CODEC =
            MapCodec.unit(new BookTierRendering());

    @Override
    public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable ItemOwner owner, int seed) {
        return (float) stack.get(SKILL_COMPONENT).level();
    }

    @Override
    public MapCodec<BookTierRendering> type() {
        return MAP_CODEC;
    }
}