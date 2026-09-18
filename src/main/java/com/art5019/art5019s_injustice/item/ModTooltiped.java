package com.art5019.art5019s_injustice.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

public interface ModTooltiped {
    List<Component> display(ItemStack itemStack);
}
