package com.art5019.art5019s_injustice.data.emissors;

import com.mojang.datafixers.util.Pair;
import net.minecraft.server.level.ServerLevel;

public interface Mergeable {
    public Pair<Boolean, ? extends Emissor> mergeWith(Mergeable b, ServerLevel serverLevel);
    public double mergeDistance();
    public boolean optimizedQuery();
}
