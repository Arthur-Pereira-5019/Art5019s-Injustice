package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.data.Skill;
import com.art5019.art5019s_injustice.graphics.item_rendering.BookTierRendering;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.neoforge.client.event.RegisterSelectItemModelPropertyEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.SKILL_COMPONENT;

@Mod(MODID)
@EventBusSubscriber
public class RegisterItemRenderersEvent {
    @SubscribeEvent
    public static void registerRangeProperties(RegisterRangeSelectItemModelPropertyEvent event) {
        event.register(
                Identifier.fromNamespaceAndPath("art5019sinjustice", "book_tier_rendering"),
                BookTierRendering.MAP_CODEC
        );
    }
}
