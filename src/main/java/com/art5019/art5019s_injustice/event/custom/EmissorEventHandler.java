package com.art5019.art5019s_injustice.event.custom;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.emissors.EmissorCollection.EMISSOR_ID;

@EventBusSubscriber
@Mod(MODID)
public class EmissorEventHandler {
    @SubscribeEvent
    public static void onEmissorUpdate(EmissorUpdatedState event) {
        ServerLevel serverLevel = event.getServerLevel();
        Emissor emissor = event.getEmissor();
        serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID).update(emissor);
    }

}
