package com.art5019.art5019s_injustice.registries;

import com.art5019.art5019s_injustice.data.emissors.ColdZoneEmissor;
import com.art5019.art5019s_injustice.data.emissors.Emissor;
import com.art5019.art5019s_injustice.data.emissors.TornadoEmissor;
import com.art5019.art5019s_injustice.data.emissors.MistEmissor;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
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

    public static final Supplier<MapCodec<? extends Emissor>> COLD_ZONE =
            EMISSORS_DISPATCH.register("cold_zone", () -> ColdZoneEmissor.COLD_ZONE);

    public static final ResourceKey<Registry<StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor>>> EMISSOR_STREAM_REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath(MODID, "emissor_stream"));

    public static final Registry<StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor>> EMISSOR_STREAM_REGISTRY =
            new RegistryBuilder<>(EMISSOR_STREAM_REGISTRY_KEY).sync(true).create();

    public static final DeferredRegister<StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor>> EMISSOR_STREAM_DISPATCH =
            DeferredRegister.create(EMISSOR_STREAM_REGISTRY_KEY, MODID);

    public static final Supplier<StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor>> TORNADO_STREAM =
            EMISSOR_STREAM_DISPATCH.register("tornado", () -> TornadoEmissor.TORNADO_STREAM);

    public static final Supplier<StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor>> MIST_STREAM =
            EMISSOR_STREAM_DISPATCH.register("mist", () -> MistEmissor.MIST_STREAM);

    public static final Supplier<StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor>> COLD_ZONE_STREAM =
            EMISSOR_STREAM_DISPATCH.register("cold_zone", () -> ColdZoneEmissor.COLD_ZONE_STREAM);


    @SubscribeEvent
    public static void registerRegistries(NewRegistryEvent event) {
        event.register(EMISSOR_REGISTRY);
        event.register(EMISSOR_STREAM_REGISTRY);
    }

}
