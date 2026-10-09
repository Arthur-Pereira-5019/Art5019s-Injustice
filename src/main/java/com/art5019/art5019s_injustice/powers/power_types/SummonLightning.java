package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.helper.EmissorHelper;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.cubemob.Slime;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public class SummonLightning extends PowerType{
    int radius;
    int lightningPower;
    SummonLightningBooster summonLightningBooster;


    public SummonLightning(String defaultTranslatable, Identifier defaultIconSource, String defaultDescription, int defaultCooldownTicks, int radius, int lightningPower, @Nullable SummonLightningBooster summonLightningBooster) {
        super(defaultTranslatable, defaultIconSource, defaultDescription, defaultCooldownTicks);
        this.radius = radius;
        this.lightningPower = lightningPower;
        this.summonLightningBooster = summonLightningBooster;
    }

    public SummonLightning(int radius, int lightningPower) {
        this.lightningPower = lightningPower;
        this.radius = radius;
        super("art5019sinjustice.powertype.summon_lightning.name",
                Identifier.fromNamespaceAndPath(MODID,""),
                "art5019sinjustice.powertype.summon_lightning.description",
                6000);
    }

    @Override
    public boolean use(ServerPlayer serverPlayer) {
        if(serverPlayer.level() instanceof ServerLevel serverLevel) {
            int radiusBoost = 0;
            int powerBoost = 0;
            if(summonLightningBooster != null) {
                radiusBoost = summonLightningBooster.radiusModifier();
                powerBoost = summonLightningBooster.lightningPowerModifier();
            }
            LightningBolt lightningBolt = EntityTypes.LIGHTNING_BOLT.create(serverLevel, EntitySpawnReason.TRIGGERED);
            Vec3 collision = GeoHelper.rayCastTillHit(radius+radiusBoost, 0.5F, serverPlayer, serverLevel);
            if(collision == null) {
                return false;
            }
            double x = collision.x;
            double y = collision.y;
            double z = collision.z;
            if(lightningBolt != null) {
                serverLevel.addFreshEntity(lightningBolt);
                lightningBolt.snapTo(x, y, z, serverLevel.getRandom().nextFloat() * 360.0F, 0.0F);
                serverLevel.explode(null, x, y, z, lightningPower+powerBoost, true, Level.ExplosionInteraction.MOB);
            } else {
                return false;
            }
        }
        return true;
    }
}
