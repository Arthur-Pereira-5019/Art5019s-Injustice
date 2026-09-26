package com.art5019.art5019s_injustice.event;


import com.art5019.art5019s_injustice.item.ModTooltiped;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber
public class TooltipAppendEvent {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();
        if(item instanceof ModTooltiped modTooltiped) {
            List<Component> tooltips = modTooltiped.display(itemStack);
            if(!tooltips.isEmpty()) {
                event.getToolTip().addAll(1,tooltips);
            }
        }
    }

}
