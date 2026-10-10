package com.art5019.art5019s_injustice.data.emissors;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;

import java.util.ArrayList;
import java.util.List;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.emissors.Emissor.INDIVIDUAL_EMISSOR_CODEC;

public class EmissorCollection extends SavedData {
    private List<Emissor> emissors = new ArrayList<>();
    public static final SavedDataType<EmissorCollection> EMISSOR_ID = new SavedDataType<>(
            Identifier.fromNamespaceAndPath(MODID, "emissor_id"),
            EmissorCollection::new,
            RecordCodecBuilder.create(instance -> instance.group(
                    INDIVIDUAL_EMISSOR_CODEC.listOf().fieldOf("emissors").forGetter(e -> e.emissors)
            ).apply(instance, EmissorCollection::new))

    );


    public EmissorCollection() {
    }

    public EmissorCollection(List<Emissor> emissors) {
        this.setDirty();
        this.emissors = emissors;
    }


    public void setEmissors(List<Emissor> emissors) {
        this.emissors = emissors;
        this.setDirty();
    }

    public List<Emissor> getEmissors() {
        return emissors;
    }
}
