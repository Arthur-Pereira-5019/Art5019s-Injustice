package com.art5019.art5019s_injustice.data.records.emissors;

import net.minecraft.server.level.ServerLevel;

import java.util.List;

public interface EmissorHandler {
    void handle(Emissor emissor, ServerLevel serverLevel);
}
