package com.art5019.art5019s_injustice.event.custom;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.Event;

public class EmissorUpdatedState extends Event {
    private Emissor emissor;
    private ServerLevel serverLevel;

    public EmissorUpdatedState(Emissor emissor, ServerLevel serverLevel) {
        this.emissor = emissor;
        this.serverLevel = serverLevel;
    }

    public Emissor getEmissor() {
        return emissor;
    }

    public ServerLevel getServerLevel() {
        return serverLevel;
    }
}
