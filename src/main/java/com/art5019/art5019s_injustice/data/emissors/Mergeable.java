package com.art5019.art5019s_injustice.data.emissors;

import net.minecraft.server.level.ServerLevel;

public interface Mergeable {
    public void mergeWith(Mergeable b, ServerLevel serverLevel);
    public double mergeDistance();
    public boolean optimizedQuery();
}
