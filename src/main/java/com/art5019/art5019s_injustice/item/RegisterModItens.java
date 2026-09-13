package com.art5019.art5019s_injustice.item;

import com.art5019.art5019s_injustice.data.Power;
import com.art5019.art5019s_injustice.data.records.blood_syringe.BloodSyringeData;
import com.art5019.art5019s_injustice.data.records.blood_syringe.BloodSyringeEffect;
import com.art5019.art5019s_injustice.data.records.skill.Skill;
import com.art5019.art5019s_injustice.data.records.skill.Skills;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import java.util.List;
import java.util.function.Supplier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.CREATIVE_MODE_TABS;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.block.BlockItems.ENGINEERING_TABLE_ITEM;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.BLOOD_TYPE_COMPONENT;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.SKILL_COMPONENT;
import static com.art5019.art5019s_injustice.item.Items.*;

@Mod(MODID)
@EventBusSubscriber
public class RegisterModItens {

    public static final Supplier<CreativeModeTab> MOD_ITENS = CREATIVE_MODE_TABS.register("itens", () -> CreativeModeTab.builder()
            .title(Component.translatable(MODID + ".itemGroup.itens"))
            .icon(() -> new ItemStack(ENGINEERING_BOOK.get()))
            .displayItems((params, output) -> {
                generateBookTiers(output,ENGINEERING_BOOK.get(),1);
                output.accept(ENGINEERING_TABLE_ITEM);
                output.accept(IRON_PLATE);
                output.accept(IRON_STICK);
                output.accept(SILICON_BIT);
                output.accept(SILICON);
                output.accept(EMPTY_SYRINGE);
                generateBloodSyringes(output);
            })
            .build()
    );


    private static void generateBookTiers(CreativeModeTab.Output output, Item item, int skillId) {
        for (int i = 1; i <= Skills.fromId(skillId).levelCap; i++) {
            ItemStack itemStack = new ItemStack(item);
            itemStack.set(SKILL_COMPONENT,new Skill(skillId,i));
            output.accept(itemStack);
        }
    }

    private static void generateBloodSyringes(CreativeModeTab.Output output) {
        BloodSyringeEffect[] values = BloodSyringeEffect.values();
        for (int i = 1; i < values.length; i++) {
            ItemStack itemStack = new ItemStack(BLOOD_SYRINGE.get());
            if(values[i] != BloodSyringeEffect.MUTANT) {
                itemStack.set(BLOOD_TYPE_COMPONENT, new BloodSyringeData(values[i].bloodEffectId,0, true));
                output.accept(itemStack);
            } else {
                List<Power> mutantPower = Power.collapseReferences(Power.MUTANT);
                for (Power power : mutantPower) {
                    itemStack.set(BLOOD_TYPE_COMPONENT, new BloodSyringeData(BloodSyringeEffect.MUTANT.bloodEffectId, power.powerId, true));
                    output.accept(itemStack);
                }
            }
        }
    }
}

