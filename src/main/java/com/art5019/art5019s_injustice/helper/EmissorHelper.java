package com.art5019.art5019s_injustice.helper;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import com.art5019.art5019s_injustice.data.emissors.EmissorCollection;
import com.art5019.art5019s_injustice.data.emissors.TornadoEmissor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;


import static com.art5019.art5019s_injustice.data.emissors.EmissorCollection.EMISSOR_ID;

public class EmissorHelper {
    private static void appendEmissor(ServerLevel serverLevel, Emissor emissor) {
        EmissorCollection emissorCollection = serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID);
        ArrayList<Emissor> emissors = new ArrayList<>(emissorCollection.getEmissors());
        emissors.add(emissor);
        serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID).setEmissors(emissors);
    }


    public static void appendTornado(ServerLevel serverLevel, BlockPos blockPos, int tornadoDuration, float tornadoStrength) {
        appendEmissor(serverLevel,
                 new TornadoEmissor(expiryTick(tornadoDuration, serverLevel), tornadoStrength, blockPos.getX(), blockPos.getY(), blockPos.getZ())
        );
    }

    public static void revokeEmissors(ServerLevel serverLevel, BlockPos blockPos, int radius, Class<? extends Emissor> type) {
        EmissorCollection emissorCollection = serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID);
        ArrayList<Emissor> emissors = new ArrayList<>(emissorCollection.getEmissors());
        List<? extends Emissor> emissorsAt = findEmissorsAt(emissors, serverLevel, blockPos, radius, type);
        emissors.removeAll(emissorsAt);
        serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID).setEmissors(emissors);
    }

    public static List<? extends Emissor> findEmissorsAt(ArrayList<Emissor> emissors, ServerLevel serverLevel, BlockPos blockPos, int radius, Class<? extends Emissor> type) {
        AABB aabb = GeoHelper.generateAABB(blockPos, radius);
        return emissors.stream().filter(x -> aabb.contains(new Vec3(x.getPosX(), x.getPosY(), x.getPosZ())) && type.isInstance(x)).toList();
    }

    public static long expiryTick(int tornadoDuration, ServerLevel serverLevel) {
        return serverLevel.getGameTime() + tornadoDuration;
    }
}
