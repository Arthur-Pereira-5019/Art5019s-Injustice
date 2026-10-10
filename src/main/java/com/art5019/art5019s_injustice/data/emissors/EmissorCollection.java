package com.art5019.art5019s_injustice.data.emissors;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.registries.Registries.*;

public class EmissorCollection extends SavedData {
    public static final Codec<Emissor> EMISSOR_CODEC =
            EMISSOR_REGISTRY.byNameCodec()
            .dispatch(
                    Emissor::type,
                    Function.identity()
            );

    private ArrayList<Emissor> emissors = new ArrayList<>();
    public static final SavedDataType<EmissorCollection> EMISSOR_ID = new SavedDataType<>(
            Identifier.fromNamespaceAndPath(MODID, "emissor_id"),
            EmissorCollection::new,
            RecordCodecBuilder.create(instance -> instance.group(
                    EMISSOR_CODEC.listOf().fieldOf("emissors").forGetter(EmissorCollection::getEmissors)
            ).apply(instance, EmissorCollection::new))
    );


    public EmissorCollection() {
    }

    public EmissorCollection(List<Emissor> emissors) {
        this.setDirty();
        this.emissors = new ArrayList<>(emissors);
    }


    public void setEmissors(List<Emissor> emissors) {
        this.emissors = new  ArrayList<>(emissors);
        this.setDirty();
    }

    public List<Emissor> getEmissors() {
        return emissors;
    }

    public void update(Emissor emissor) {
        emissors.remove(emissor);
        emissors.add(emissor);
        this.setDirty();
    }


}
