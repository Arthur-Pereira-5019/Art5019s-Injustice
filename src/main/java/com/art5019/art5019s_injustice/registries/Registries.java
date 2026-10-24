package com.art5019.art5019s_injustice.registries;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import com.art5019.art5019s_injustice.data.emissors.TornadoEmissor;
import com.art5019.art5019s_injustice.data.emissors.mist.MistEmissor;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

import java.util.function.Supplier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber
public class Registries {
    public static final ResourceKey<Registry<MapCodec<? extends Emissor>>> EMISSOR_REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath(MODID, "emissors"));

    public static final Registry<MapCodec<? extends Emissor>> EMISSOR_REGISTRY =
            new RegistryBuilder<>(EMISSOR_REGISTRY_KEY).create();

    public static final DeferredRegister<MapCodec<? extends Emissor>> EMISSORS_DISPATCH =
            DeferredRegister.create(EMISSOR_REGISTRY, MODID);

    public static final Supplier<MapCodec<? extends Emissor>> TORNADO =
            EMISSORS_DISPATCH.register("tornado", () -> TornadoEmissor.TORNADO);

    public static final Supplier<MapCodec<? extends Emissor>> MIST =
            EMISSORS_DISPATCH.register("mist", () -> MistEmissor.MIST);


    @SubscribeEvent // on the mod event bus
    public static void registerRegistries(NewRegistryEvent event) {
        event.register(EMISSOR_REGISTRY);
    }

}
