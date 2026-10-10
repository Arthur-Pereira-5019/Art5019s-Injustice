package com.art5019.art5019s_injustice.data.emissors;

import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.core.particles.ParticleTypes.CLOUD;
import static net.minecraft.world.damagesource.DamageTypes.GENERIC;

public class TornadoEmissor extends Emissor{
    private float tornadoStrength;
    private double basicForce;
    private DamageSource damageSource;

    public TornadoEmissor(long expiryTick, float tornadoStrength, double posX, double posY, double posZ) {
        super(expiryTick, Emissor.packParameters(tornadoStrength), posX, posY, posZ);
    }

    @Override
    public List<Float> getParameters() {
        return new ArrayList<>(List.of(tornadoStrength));
    }

    @Override
    public void unpackParameters(List<Float> parameters) {
        this.tornadoStrength = parameters.getFirst();
        this.basicForce = Math.pow(2,tornadoStrength);
        super.unpackParameters(parameters);
    }

    @Override
    public void handle(ServerLevel serverLevel) {
        List<Entity> entities = GeoHelper.getEntitiesAt(this.getBlockPos(), basicForce, serverLevel);
        double x = this.getPosX();
        double y = this.getPosY();
        double z = this.getPosZ();
        damageSource = new DamageSource(serverLevel.holderLookup(Registries.DAMAGE_TYPE).getOrThrow(GENERIC));
        int si = 0;
        for (int i = 0; i < tornadoStrength; i++) {
            serverLevel.sendParticles(CLOUD, false, true, x, y+0+3*i+si, z, 8+i*6, 0.1+i*0.8, 0.1+i, 0.1+i*0.8, (double) i /20);
            si += i;
        }
        for (Entity e: entities) {
            applyMovement(e, serverLevel);
            if(e instanceof ServerPlayer serverPlayer) {
                serverPlayer.hurtMarked = true;
            }
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
        double relativeForce = Math.max((basicForce- distance)/40, 0.0);
        double rotationSpeed = relativeForce*0.9;
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
}
