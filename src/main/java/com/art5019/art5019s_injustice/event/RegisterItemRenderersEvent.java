package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.graphics.item_rendering.BookTierRendering;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

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
