package com.art5019.art5019s_injustice.data.emissors.mist;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.phys.Vec3;

import java.util.UUID;

import static com.art5019.art5019s_injustice.data.DataAttachments.GRAPHICS_STACK;
import static com.art5019.art5019s_injustice.effects.Effects.MIST_EFFECT;

public class MistEmissor extends Emissor {
    private final int mistRange;
    public static final MapCodec<MistEmissor> MIST = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.LONG.fieldOf("expiryTick").forGetter(MistEmissor::getExpiryTick),
                    Codec.DOUBLE.fieldOf("posX").forGetter(MistEmissor::getPosX),
                    Codec.DOUBLE.fieldOf("posY").forGetter(MistEmissor::getPosY),
                    Codec.DOUBLE.fieldOf("posZ").forGetter(MistEmissor::getPosZ),
                    Codec.STRING.fieldOf("uuid").forGetter(MistEmissor::getUuid),
                    Codec.INT.fieldOf("mistRange").forGetter(MistEmissor::getMistRange)
            ).apply(instance, MistEmissor::new)
    );

    public MistEmissor(long expiryTick, double posX, double posY, double posZ, int mistRange) {
        super(expiryTick, posX, posY, posZ, UUID.randomUUID().toString());
        this.mistRange = mistRange;
    }

    public MistEmissor(long expiryTick, double posX, double posY, double posZ, String uuid, int mistRange) {
        super(expiryTick, posX, posY, posZ, uuid);
        this.mistRange = mistRange;
    }


    @Override
    public void handle(ServerLevel serverLevel) {
        for (ServerPlayer player : serverLevel.players()) {
            Vec3 playerPos = player.position();
            double distance = GeoHelper.distanceBetweenPos(playerPos, this.getVec3());
            int value = player.getData(GRAPHICS_STACK);
            if(distance < mistRange) {
                if(serverLevel.getRandom().nextFloat() < 0.03) {
                    player.addEffect(new MobEffectInstance(MIST_EFFECT, 200, 0, false, false));
                }
            }
        }
    }


    @Override
    public MapCodec<? extends Emissor> type() {
        return MIST;
    }

    public int getMistRange() {
        return mistRange;
    }
}
