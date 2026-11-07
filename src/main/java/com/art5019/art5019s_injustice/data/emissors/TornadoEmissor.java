package com.art5019.art5019s_injustice.data.emissors;

import com.art5019.art5019s_injustice.data.emissors.event.EmissorSelfRemovedEvent;
import com.art5019.art5019s_injustice.data.emissors.event.EmissorUpdatedStateEvent;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import com.art5019.art5019s_injustice.helper.MathHelper;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;
import java.util.UUID;

import static net.minecraft.core.particles.ParticleTypes.CLOUD;
import static net.minecraft.world.damagesource.DamageTypes.GENERIC;

public class TornadoEmissor extends Emissor implements Mergeable {
    private float tornadoStrength;
    private double basicForce;
    private float xComponent;
    private float zComponent;
    private DamageSource damageSource;

    public static final MapCodec<TornadoEmissor> TORNADO = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.LONG.fieldOf("expiryTick").forGetter(TornadoEmissor::getExpiryTick),
                    Codec.DOUBLE.fieldOf("posX").forGetter(TornadoEmissor::getPosX),
                    Codec.DOUBLE.fieldOf("posY").forGetter(TornadoEmissor::getPosY),
                    Codec.DOUBLE.fieldOf("posZ").forGetter(TornadoEmissor::getPosZ),
                    Codec.STRING.fieldOf("uuid").forGetter(TornadoEmissor::getUuid),
                    Codec.FLOAT.fieldOf("strength").forGetter(TornadoEmissor::getTornadoStrength),
                    Codec.FLOAT.fieldOf("xComponent").forGetter(TornadoEmissor::getxComponent),
                    Codec.FLOAT.fieldOf("zComponent").forGetter(TornadoEmissor::getzComponent)
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
            ByteBufCodecs.FLOAT,
            TornadoEmissor::getxComponent,
            ByteBufCodecs.FLOAT,
            TornadoEmissor::getzComponent,
            TornadoEmissor::new
    );


    public TornadoEmissor(long expiryTick, double posX, double posY, double posZ, float tornadoStrength, float xComponent, float zComponent) {
        super(expiryTick, posX, posY, posZ, UUID.randomUUID().toString());
        this.tornadoStrength = tornadoStrength;
        this.xComponent = xComponent;
        this.zComponent = zComponent;
        basicForce = Math.pow(2,tornadoStrength);
    }

    public TornadoEmissor(long expiryTick, double posX, double posY, double posZ, String uuid, float tornadoStrength, float xComponent, float zComponent) {
        super(expiryTick, posX, posY, posZ, uuid);
        this.tornadoStrength = tornadoStrength;
        this.xComponent = xComponent;
        this.zComponent = zComponent;
        basicForce = Math.pow(2,tornadoStrength);
    }


    @Override
    public void handle(ServerLevel serverLevel) {
        List<Entity> entities = GeoHelper.getEntitiesAt(this.getBlockPos().offset(0, (int) basicForce, 0), basicForce * 2, basicForce * 1.2, serverLevel);
        double x = this.getPosX();
        double y = this.getPosY();
        double z = this.getPosZ();
        damageSource = new DamageSource(serverLevel.holderLookup(Registries.DAMAGE_TYPE).getOrThrow(GENERIC));
        int si = 0;
        for (int i = 0; i < tornadoStrength; i++) {
            serverLevel.sendParticles(CLOUD, true, true, x, y + 0 + 3 * i + si, z, 8 + i * 6, 0.1 + i * 0.8, 0.1 + i, 0.1 + i * 0.8, (double) i / 20);
            for(int j = 0; j < tornadoStrength/2; j++) {
                BlockPos tryToBreak = GeoHelper.randomCoordinates((int) tornadoStrength, (int) tornadoStrength * 2, this.getBlockPos().offset(0, (int) tornadoStrength, 0));
                if (serverLevel.getBlockState(tryToBreak).getDestroySpeed(serverLevel, tryToBreak) < tornadoStrength / 3) {
                    serverLevel.destroyBlock(tryToBreak, true);
                }
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
        nextMove = nextMove.add(xComponent * (basicForce / 60), 0, zComponent * (basicForce / 60));
        for (int i = (int) basicForce; i > -basicForce; i--) {
            Vec3 actualMoveCoords = nextMove.add(0, i, 0);
            BlockPos moveBlockPos = GeoHelper.Vec3ToBlockPos(actualMoveCoords);
            if (serverLevel.getBlockState(moveBlockPos).isSolid()) {
                if (!serverLevel.getBlockState(moveBlockPos.above()).isSolid()) {
                    this.moveTo(actualMoveCoords.add(0,1,0), serverLevel);
                }
            }
        }
    }


    public float getTornadoStrength() {
        return tornadoStrength;
    }

    public void setTornadoStrength(float tornadoStrength) {
        basicForce = Math.pow(2,tornadoStrength);
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

    @Override
    public void evolve(int factor, ServerLevel serverLevel) {
        this.setTornadoStrength(tornadoStrength + factor);
        this.setExpiryTick(getExpiryTick() + 200L *factor);
    }

    @Override
    public void devolve(int factor, ServerLevel serverLevel) {
        this.setTornadoStrength(tornadoStrength - factor);
        if(tornadoStrength == 0) {
            NeoForge.EVENT_BUS.post(new EmissorSelfRemovedEvent(this, serverLevel));
        }
    }

    public float getxComponent() {
        return xComponent;
    }

    public void setxComponent(float xComponent) {
        this.xComponent = xComponent;
    }

    public float getzComponent() {
        return zComponent;
    }

    public void setzComponent(float zComponent) {
        this.zComponent = zComponent;
    }

    public Vec2 getComponents() {
        return new Vec2(xComponent, zComponent);
    }

    @Override
    public void mergeWith(Mergeable b, ServerLevel serverLevel) {
        if(b instanceof TornadoEmissor other) {
            if(serverLevel.getRandom().nextFloat() < 0.5) {
                this.tornadoStrength = Math.max(this.tornadoStrength, other.tornadoStrength) + 1;
                this.setExpiryTick(Math.max(this.getExpiryTick(), other.getExpiryTick()) + 400);
                Vec2 newComponents = MathHelper.normalizedVectorSum(getComponents(), other.getComponents());
                this.setxComponent(newComponents.x);
                this.setzComponent(newComponents.y);
                NeoForge.EVENT_BUS.post(new EmissorUpdatedStateEvent(this, serverLevel));
            } else {
                NeoForge.EVENT_BUS.post(new EmissorSelfRemovedEvent(this, serverLevel));
            }
        }
    }

    @Override
    public double mergeDistance() {
        return basicForce*2;
    }

    @Override
    public boolean optimizedQuery() {
        return true;
    }
}
