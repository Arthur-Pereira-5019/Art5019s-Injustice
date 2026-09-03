package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.data.Skill;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.function.Supplier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.CREATIVE_MODE_TABS;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.SKILL_COMPONENT;
import static com.art5019.art5019s_injustice.item.Items.ENGINEERING_BOOK;

@Mod(MODID)
@EventBusSubscriber
public class RegisterItens {

    public static final Supplier<CreativeModeTab> MOD_ITENS = CREATIVE_MODE_TABS.register("itens", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MODID + ".itens"))
            .icon(() -> new ItemStack(ENGINEERING_BOOK.get()))
            .displayItems((params, output) -> {
                generateBookTiers(output,ENGINEERING_BOOK.get(),1,7);
            })
            .build()
    );


    private static void generateBookTiers(CreativeModeTab.Output output, Item item, int skillId, int tierRange) {
        for (int i = 0; i < tierRange; i++) {
            ItemStack itemStack = new ItemStack(item);
            itemStack.set(SKILL_COMPONENT,new Skill(skillId,i));
            output.accept(itemStack);
        }
    }
}

