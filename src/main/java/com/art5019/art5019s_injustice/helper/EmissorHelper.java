package com.art5019.art5019s_injustice.helper;

import com.art5019.art5019s_injustice.data.records.emissors.Emissor;
import com.art5019.art5019s_injustice.data.records.emissors.EmissorCollection;
import com.art5019.art5019s_injustice.data.records.emissors.TornadoEmissor;
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
        appendEmissor(serverLevel,
                 new TornadoEmissor(expiryTick(tornadoDuration, serverLevel), tornadoStrength, blockPos.getX(), blockPos.getY(), blockPos.getZ())
        );
    }

    public static long expiryTick(int tornadoDuration, ServerLevel serverLevel) {
        return serverLevel.getGameTime() + tornadoDuration;
    }
}
