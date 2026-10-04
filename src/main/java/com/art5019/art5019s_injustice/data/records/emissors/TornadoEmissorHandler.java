package com.art5019.art5019s_injustice.data.records.emissors;

import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class TornadoEmissorHandler implements EmissorHandler{
    @Override
    public void handle(Emissor emissor, ServerLevel serverLevel) {
        GeoHelper.getEntitiesAt(emissor.getBlockPos(), emissor.parameters.get(0), serverLevel);
    }
}
