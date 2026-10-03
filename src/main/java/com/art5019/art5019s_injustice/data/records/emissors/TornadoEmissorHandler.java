package com.art5019.art5019s_injustice.data.records.emissors;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

import java.util.List;

public class TornadoEmissorHandler implements EmissorHandler{
    @Override
    public void handle(Emissor emissor, ServerLevel serverLevel) {
        serverLevel.explode(null, emissor.getPosX(), emissor.getPosY(), emissor.getPosZ(), 3F, true, Level.ExplosionInteraction.TNT);
    }
}
