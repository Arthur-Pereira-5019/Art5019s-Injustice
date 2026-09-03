package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.data.Skill;
import com.art5019.art5019s_injustice.data.item.ItemDataComponents;
import com.art5019.art5019s_injustice.item.SkillBook;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.SKILL_COMPONENT;

@Mod(MODID)
@EventBusSubscriber
public class TooltipAppendEvent {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        if(event.getItemStack().getItem() instanceof SkillBook) {
            Skill bookSkill = event.getItemStack().get(ItemDataComponents.SKILL_COMPONENT);
            event.getToolTip().add(bookSkill.getComponent());
        }
    }

}
