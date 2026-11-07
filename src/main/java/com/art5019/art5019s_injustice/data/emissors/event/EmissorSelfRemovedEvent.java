package com.art5019.art5019s_injustice.data.emissors.event;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.Event;

public class EmissorSelfRemovedEvent extends Event {
    private Emissor emissor;
    private ServerLevel serverLevel;

    public EmissorSelfRemovedEvent(Emissor emissor, ServerLevel serverLevel) {
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
