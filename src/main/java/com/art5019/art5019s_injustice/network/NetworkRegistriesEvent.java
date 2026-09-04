package com.art5019.art5019s_injustice.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.network.event.RegisterClientPayloadHandlersEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber
public class NetworkRegistriesEvent {
    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                SkillLevelUpPacket.TYPE,
                SkillLevelUpPacket.STREAM_CODEC,
                ServerPayloadHandler::handleDataOnMain
        );
    }
}
