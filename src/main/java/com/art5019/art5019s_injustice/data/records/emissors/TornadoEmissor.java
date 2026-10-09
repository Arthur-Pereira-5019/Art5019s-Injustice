package com.art5019.art5019s_injustice.data.records.emissors;

import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.core.particles.ParticleTypes.CLOUD;

public class TornadoEmissor extends Emissor{
    private float tornadoStrength;
    private double basicForce;

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
        serverLevel.sendParticles(CLOUD, false, true, x, y, z, 8, 0.1, 0.1, 0.1, 0.2);
        serverLevel.sendParticles(CLOUD, false, true, x, y+4, z, 12, 1.5, 1.5, 1.5, 0.3);
        serverLevel.sendParticles(CLOUD, false, true, x, y+8, z, 18, 3, 3, 3, 0.4);
        for (Entity e: entities) {
            applyMovement(e);
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

    public void applyMovement(Entity e) {
        BlockPos a = e.blockPosition();
        BlockPos b = this.getBlockPos();
        double distance = GeoHelper.horizontalDistance(a, b)+0.1;
        double relativeForce = Math.max((basicForce- distance)/40, 0.0);
        double rotationSpeed = relativeForce*1.1;
        double dx = GeoHelper.dx(a,b);
        double dz = GeoHelper.dz(a,b);
        double deltaMovementX = -relativeForce*(dx/ distance)+rotationSpeed*(dz/ distance);
        double deltaMovementZ = -relativeForce*(dz/ distance)-rotationSpeed*(dx/ distance);
        Vec3 vecna = new Vec3(deltaMovementX, relativeForce,deltaMovementZ);
        e.addDeltaMovement(vecna);
    }
}
