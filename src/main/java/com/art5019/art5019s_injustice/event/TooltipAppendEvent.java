package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.data.Power;
import com.art5019.art5019s_injustice.data.records.blood_syringe.BloodSyringeData;
import com.art5019.art5019s_injustice.data.records.blood_syringe.BloodSyringeEffect;
import com.art5019.art5019s_injustice.data.records.skill.Skill;
import com.art5019.art5019s_injustice.data.item.ItemDataComponents;
import com.art5019.art5019s_injustice.item.BloodSyringe;
import com.art5019.art5019s_injustice.item.SkillBook;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.BLOOD_TYPE_COMPONENT;

@Mod(MODID)
@EventBusSubscriber
public class TooltipAppendEvent {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {

        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();
        if(item instanceof SkillBook) {
            Skill bookSkill = itemStack.get(ItemDataComponents.SKILL_COMPONENT);
            event.getToolTip().add(bookSkill.getComponent());
        } else if (item instanceof BloodSyringe) {
            BloodSyringeData bloodSyringeData = itemStack.get(BLOOD_TYPE_COMPONENT);
            if(bloodSyringeData.labeled()) {
                BloodSyringeEffect bloodSyringeEffect = BloodSyringeEffect.fromId(bloodSyringeData.bloodEffectId());
                event.getToolTip().add(Component.translatable(MODID+".item.blood_syringe."+bloodSyringeEffect.translatable));
                if(bloodSyringeEffect == BloodSyringeEffect.MUTANT) {
                    event.getToolTip().add(Component.translatable(MODID+".power.scientific."+ Power.fromId(bloodSyringeData.extraEnumId())));
                }
            }
        }
    }

}
