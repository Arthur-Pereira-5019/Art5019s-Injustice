package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.data.records.skill.Skill;
import com.art5019.art5019s_injustice.data.item.ItemDataComponents;
import com.art5019.art5019s_injustice.item.BloodSyringe;
import com.art5019.art5019s_injustice.item.SkillBook;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber
public class TooltipAppendEvent {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        if(item instanceof SkillBook) {
            Skill bookSkill = event.getItemStack().get(ItemDataComponents.SKILL_COMPONENT);
            event.getToolTip().add(bookSkill.getComponent());
        } else if (item instanceof BloodSyringe) {

        }
    }

}
