package com.art5019.art5019s_injustice.data.emissors;

import com.art5019.art5019s_injustice.helper.GeoHelper;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;
import java.util.UUID;

import static com.art5019.art5019s_injustice.effects.Effects.MIST_EFFECT;
import static net.minecraft.core.particles.ParticleTypes.CLOUD;

public class MistEmissor extends Emissor {
    private final int mistRange;
    private final boolean visualEmissor;
    public static final MapCodec<MistEmissor> MIST = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.LONG.fieldOf("expiryTick").forGetter(MistEmissor::getExpiryTick),
                    Codec.DOUBLE.fieldOf("posX").forGetter(MistEmissor::getPosX),
                    Codec.DOUBLE.fieldOf("posY").forGetter(MistEmissor::getPosY),
                    Codec.DOUBLE.fieldOf("posZ").forGetter(MistEmissor::getPosZ),
                    Codec.STRING.fieldOf("uuid").forGetter(MistEmissor::getUuid),
                    Codec.INT.fieldOf("mistRange").forGetter(MistEmissor::getMistRange),
                    Codec.BOOL.fieldOf("visualEmissor").forGetter(MistEmissor::isVisualEmissor)
            ).apply(instance, MistEmissor::new)
    );

    public MistEmissor(long expiryTick, double posX, double posY, double posZ, int mistRange, boolean visualEmissor) {
        super(expiryTick, posX, posY, posZ, UUID.randomUUID().toString());
        this.mistRange = mistRange;
        this.visualEmissor = visualEmissor;
    }

    public MistEmissor(long expiryTick, double posX, double posY, double posZ, String uuid, int mistRange, boolean visualEmissor) {
        super(expiryTick, posX, posY, posZ, uuid);
        this.mistRange = mistRange;
        this.visualEmissor = visualEmissor;
    }


    @Override
    public void handle(ServerLevel serverLevel) {
        serverLevel.sendParticles(CLOUD, false, true, getPosX(), getPosY(), getPosZ(), 16, 4, 4, 4, 0.1);
        if(serverLevel.getRandom().nextFloat() < 0.03) {
            List<Entity> entities = GeoHelper.getEntitiesAt(this.getBlockPos(), mistRange, serverLevel);
            for (Entity entity : entities) {
                if(entity instanceof LivingEntity livingEntity) {
                    livingEntity.addEffect(new MobEffectInstance(MIST_EFFECT, 200, 0, false, false));
                }
            }
        }
    }

    public boolean isVisualEmissor() {
        return visualEmissor;
    }

    @Override
    public MapCodec<? extends Emissor> type() {
        return MIST;
    }

    public int getMistRange() {
        return mistRange;
    }
}
