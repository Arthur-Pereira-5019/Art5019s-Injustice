package com.art5019.art5019s_injustice.network.user_input;

import com.art5019.art5019s_injustice.network.packets.PlayerScrollsPacket;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber(value = Dist.CLIENT)
public class ScrollWheelEvent {
    @SubscribeEvent
    public static void scrollWheelEvent(InputEvent.MouseScrollingEvent mouseScrollingEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getConnection().send(new PlayerScrollsPacket(mouseScrollingEvent.getAccumulatedScrollY()));
    }
}
