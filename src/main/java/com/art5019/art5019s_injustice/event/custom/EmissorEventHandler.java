package com.art5019.art5019s_injustice.event.custom;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
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
    public static void onEmissorUpdate(EmissorUpdatedState event) {
        ServerLevel serverLevel = event.getServerLevel();
        Emissor emissor = event.getEmissor();
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(EMISSORS_ATTACHMENT));
        emissors.remove(emissor);
        emissors.add(emissor);
        serverLevel.setData(EMISSORS_ATTACHMENT, emissors);
    }

}
