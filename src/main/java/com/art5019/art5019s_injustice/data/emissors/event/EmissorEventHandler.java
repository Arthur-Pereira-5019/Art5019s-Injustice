package com.art5019.art5019s_injustice.data.emissors.event;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import com.art5019.art5019s_injustice.helper.EmissorHelper;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import java.util.ArrayList;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.DataAttachments.EMISSORS_ATTACHMENT;

@EventBusSubscriber
@Mod(MODID)
public class EmissorEventHandler {
    @SubscribeEvent
    public static void onEmissorUpdate(EmissorUpdatedStateEvent event) {
        ServerLevel serverLevel = event.getServerLevel();
        Emissor emissor = event.getEmissor();
        EmissorHelper.removeEmissor(emissor, serverLevel);
        EmissorHelper.appendEmissor(serverLevel, emissor);
    }

    @SubscribeEvent
    public static void onEmissorUpdate(EmissorSelfRemovedEvent event) {
        ServerLevel serverLevel = event.getServerLevel();
        Emissor emissor = event.getEmissor();
        EmissorHelper.removeEmissor(emissor, serverLevel);
    }

}
