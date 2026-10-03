package com.art5019.art5019s_injustice.data.records.emissors;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.attachment.AttachmentType;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.ATTACHMENT_TYPES;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.records.emissors.Emissor.INDIVIDUAL_EMISSOR_CODEC;

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
