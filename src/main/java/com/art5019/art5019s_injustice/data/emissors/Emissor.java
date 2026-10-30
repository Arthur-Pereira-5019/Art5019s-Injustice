package com.art5019.art5019s_injustice.data.emissors;

import com.art5019.art5019s_injustice.event.custom.EmissorUpdatedState;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;

import java.util.Objects;

public abstract class Emissor {
    private long expiryTick;
    private double posX;
    private double posY;
    private double posZ;
    private String uuid;

    public abstract MapCodec<? extends Emissor> type();
    public abstract StreamCodec<? super RegistryFriendlyByteBuf, ? extends Emissor> streamCodec();

    public Emissor(long expiryTick, double posX, double posY, double posZ, String uuid) {
        this.expiryTick = expiryTick;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.uuid = uuid;
    }

    public long getExpiryTick() {
        return expiryTick;
    }


    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public BlockPos getBlockPos() {
        return new BlockPos((int) posX, (int) posY, (int) posZ);
    }

    public Vec3 getVec3() {
        return new Vec3(posX, posY, posZ);
    }

    public abstract void handle(ServerLevel serverLevel);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Emissor emissor = (Emissor) o;
        return Objects.equals(uuid, emissor.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    public void moveTo(Vec3 vec3, ServerLevel serverLevel) {
        this.posX = vec3.x;
        this.posY = vec3.y;
        this.posZ = vec3.z;
        NeoForge.EVENT_BUS.post(new EmissorUpdatedState(this, serverLevel));
    }

    public String getUuid() {
        return uuid;
    }
}
