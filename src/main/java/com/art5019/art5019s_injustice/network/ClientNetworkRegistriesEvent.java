package com.art5019.art5019s_injustice.network;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.network.event.RegisterClientPayloadHandlersEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber(value = Dist.CLIENT)
public class ClientNetworkRegistriesEvent {

    @SubscribeEvent
    public static void register(RegisterClientPayloadHandlersEvent event) {
        event.register(
                SkillLevelUpPacket.TYPE,
                ClientPayloadHandler::handleDataOnMain
        );
    }
}
