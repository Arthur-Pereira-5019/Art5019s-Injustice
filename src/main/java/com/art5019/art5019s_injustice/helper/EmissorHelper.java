package com.art5019.art5019s_injustice.helper;

import com.art5019.art5019s_injustice.data.records.emissors.Emissor;
import com.art5019.art5019s_injustice.data.records.emissors.EmissorCollection;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.ArrayList;


import static com.art5019.art5019s_injustice.data.records.emissors.EmissorCollection.EMISSOR_ID;
import static com.art5019.art5019s_injustice.data.records.emissors.EmissorEffect.TORNADO;

public class EmissorHelper {
    private static void appendEmissor(ServerLevel serverLevel, Emissor emissor) {
        EmissorCollection emissorCollection = serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID);
        ArrayList<Emissor> emissors;
        emissors = new ArrayList<>(emissorCollection.getEmissors());
        emissors.add(emissor);
        serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID).setEmissors(emissors);
    }

    public static void appendTornado(ServerLevel serverLevel, BlockPos blockPos, int tornadoDuration, float tornadoStrength) {
        ArrayList<Float> parameters = new ArrayList<>();
        parameters.add(tornadoStrength);
        appendEmissor(serverLevel,
                 new Emissor(TORNADO.getId(),
                serverLevel.getGameTime() + (long) tornadoDuration,
                         parameters,
                         blockPos.getX(),
                blockPos.getY(),
                blockPos.getZ()
        ));
    }
}
