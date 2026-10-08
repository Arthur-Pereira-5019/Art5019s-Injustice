package com.art5019.art5019s_injustice.data.records.emissors;

import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.client.particle.HeartParticle;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.core.particles.ParticleTypes.CLOUD;

public class TornadoEmissor extends Emissor{
    private float tornadoStrength;

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
        super.unpackParameters(parameters);
    }

    @Override
    public void handle(ServerLevel serverLevel) {
        List<LivingEntity> entities = GeoHelper.getEntitiesAt(this.getBlockPos(), 6, serverLevel);
        double x = this.getPosX();
        double y = this.getPosY();
        double z = this.getPosZ();
        serverLevel.sendParticles(CLOUD, false, true, x, y, z, 8, 0.1, 0.1, 0.1, 0.2);
        serverLevel.sendParticles(CLOUD, false, true, x, y+4, z, 12, 1.5, 1.5, 1.5, 0.3);
        serverLevel.sendParticles(CLOUD, false, true, x, y+8, z, 18, 3, 3, 3, 0.4);
        for (LivingEntity e: entities) {
            e.addDeltaMovement(new Vec3(1,1,1));
        }
    }

    public float getTornadoStrength() {
        return tornadoStrength;
    }

    public void setTornadoStrength(float tornadoStrength) {
        this.tornadoStrength = tornadoStrength;
    }
}
