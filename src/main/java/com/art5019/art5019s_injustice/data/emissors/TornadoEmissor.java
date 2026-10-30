package com.art5019.art5019s_injustice.data.emissors;

import com.art5019.art5019s_injustice.helper.GeoHelper;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.UUID;

import static net.minecraft.core.particles.ParticleTypes.BLOCK;
import static net.minecraft.core.particles.ParticleTypes.CLOUD;
import static net.minecraft.world.damagesource.DamageTypes.GENERIC;

public class TornadoEmissor extends Emissor {
    private float tornadoStrength;
    private double basicForce;
    private DamageSource damageSource;

    public static final MapCodec<TornadoEmissor> TORNADO = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.LONG.fieldOf("expiryTick").forGetter(TornadoEmissor::getExpiryTick),
                    Codec.DOUBLE.fieldOf("posX").forGetter(TornadoEmissor::getPosX),
                    Codec.DOUBLE.fieldOf("posY").forGetter(TornadoEmissor::getPosY),
                    Codec.DOUBLE.fieldOf("posZ").forGetter(TornadoEmissor::getPosZ),
                    Codec.STRING.fieldOf("uuid").forGetter(TornadoEmissor::getUuid),
                    Codec.FLOAT.fieldOf("strength").forGetter(TornadoEmissor::getTornadoStrength)
            ).apply(instance, TornadoEmissor::new)
    );

    public static final StreamCodec<FriendlyByteBuf, TornadoEmissor> TORNADO_STREAM = StreamCodec.composite(
            ByteBufCodecs.LONG,
            TornadoEmissor::getExpiryTick,
            ByteBufCodecs.DOUBLE,
            TornadoEmissor::getPosX,
            ByteBufCodecs.DOUBLE,
            TornadoEmissor::getPosY,
            ByteBufCodecs.DOUBLE,
            TornadoEmissor::getPosZ,
            ByteBufCodecs.STRING_UTF8,
            TornadoEmissor::getUuid,
            ByteBufCodecs.FLOAT,
            TornadoEmissor::getTornadoStrength,
            TornadoEmissor::new
    );


    public TornadoEmissor(long expiryTick, double posX, double posY, double posZ, float tornadoStrength) {
        super(expiryTick, posX, posY, posZ, UUID.randomUUID().toString());
        this.tornadoStrength = tornadoStrength;
        basicForce = Math.pow(2,tornadoStrength);
    }

    public TornadoEmissor(long expiryTick, double posX, double posY, double posZ, String uuid, float tornadoStrength) {
        super(expiryTick, posX, posY, posZ, uuid);
        this.tornadoStrength = tornadoStrength;
        basicForce = Math.pow(2,tornadoStrength);
    }


    @Override
    public void handle(ServerLevel serverLevel) {
        List<Entity> entities = GeoHelper.getEntitiesAt(this.getBlockPos().offset(0,(int) basicForce,0), basicForce*2, basicForce*1.2, serverLevel);
        double x = this.getPosX();
        double y = this.getPosY();
        double z = this.getPosZ();
        damageSource = new DamageSource(serverLevel.holderLookup(Registries.DAMAGE_TYPE).getOrThrow(GENERIC));
        int si = 0;
        for (int i = 0; i < tornadoStrength; i++) {
            serverLevel.sendParticles(CLOUD, false, true, x, y + 0 + 3 * i + si, z, 8 + i * 6, 0.1 + i * 0.8, 0.1 + i, 0.1 + i * 0.8, (double) i / 20);
            BlockPos tryToBreak = GeoHelper.randomCoordinates((int) tornadoStrength, (int) tornadoStrength*2 ,this.getBlockPos().offset(0, (int) tornadoStrength,0));
            if(serverLevel.getBlockState(tryToBreak).getDestroySpeed(serverLevel, tryToBreak) < tornadoStrength/3) {
                serverLevel.destroyBlock(tryToBreak, true);
            }
            si += i;
        }
        for (Entity e : entities) {
            applyMovement(e, serverLevel);
            if (e instanceof ServerPlayer serverPlayer) {
                serverPlayer.hurtMarked = true;
            }
        }
        Vec3 nextMove = GeoHelper.randomHCoordinates(0.1F, getVec3());
        BlockPos move = GeoHelper.Vec3ToBlockPos(nextMove);
        if (serverLevel.getBlockState(move).isSolid()) {
            if (!serverLevel.getBlockState(move.above()).isSolid()) {
                this.moveTo(nextMove.add(0, 1, 0), serverLevel);
            }
        } else if (serverLevel.getBlockState(move.below()).isSolid()) {
            this.moveTo(nextMove, serverLevel);
        } else if (serverLevel.getBlockState(move.below().below()).isSolid()) {
            this.moveTo(nextMove.add(0, -1, 0),serverLevel);
        }
    }


    public float getTornadoStrength() {
        return tornadoStrength;
    }

    public void setTornadoStrength(float tornadoStrength) {
        this.tornadoStrength = tornadoStrength;
    }

    public void applyMovement(Entity e, ServerLevel serverLevel) {
        Vec3 a = e.getPosition(0f);
        Vec3 b = this.getVec3();
        double distance = GeoHelper.horizontalDistance(a, b)+0.1;
        double relativeForce = Math.max((basicForce- distance/2)/40, 0.0);
        double rotationSpeed = relativeForce*0.4;
        double dx = GeoHelper.dx(a,b);
        double dz = GeoHelper.dz(a,b);
        double deltaMovementX = -relativeForce*(dx/ distance)+rotationSpeed*(dz/ distance);
        double deltaMovementZ = -relativeForce*(dz/ distance)-rotationSpeed*(dx/ distance);
        Vec3 vecna = new Vec3(deltaMovementX, relativeForce,deltaMovementZ);
        e.addDeltaMovement(vecna);
        if(serverLevel.getRandom().nextFloat() < 0.1) {
            e.hurtServer(serverLevel, damageSource, (float) (relativeForce*20));
        }
    }

    @Override
    public MapCodec<? extends Emissor> type() {
        return TORNADO;
    }

    @Override
    public StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor> streamCodec() {
        return TORNADO_STREAM;
    }
}
