package com.art5019.art5019s_injustice.helper;

import com.art5019.art5019s_injustice.data.records.emissors.Emissor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.ArrayList;

import static com.art5019.art5019s_injustice.data.DataAttachments.EMISSORS;
import static com.art5019.art5019s_injustice.data.DataAttachments.LEVEL_EMISSORS;
import static com.art5019.art5019s_injustice.data.records.emissors.EmissorEffect.TORNADO;

public class EmissorHelper {
    private static void appendEmissor(ServerLevel serverLevel, Emissor emissor) {
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(LEVEL_EMISSORS));
        emissors.add(emissor);
        serverLevel.setData(LEVEL_EMISSORS, emissors);
    }

    public static void appendTornado(ServerLevel serverLevel, BlockPos blockPos, int tornadoDuration, float tornadoStrength) {
        ArrayList<Float> parameters = new ArrayList<>();
        parameters.add(tornadoStrength);
        appendEmissor(serverLevel,
                 new Emissor(TORNADO.getId(),
                serverLevel.getGameTime() + (long) tornadoDuration,
                blockPos.getX(),
                blockPos.getY(),
                blockPos.getZ(),
                         parameters
        ));
    }
}
