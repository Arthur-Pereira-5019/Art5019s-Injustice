package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.network.packets.PlayerUsesPowerPacket;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber(value = Dist.CLIENT)
public class RegisterKeyBinds {
    public static final KeyMapping.Category INJUSTICE_KEY_CATEGORY =
            new KeyMapping.Category(Identifier.fromNamespaceAndPath(MODID, "category"));

    public static final Lazy<KeyMapping> FIRST_POWER = Lazy.of(() -> new KeyMapping(
            "art5019sinjustice.key.power1",
            KeyConflictContext.UNIVERSAL,
            KeyModifier.NONE,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_Z,
            INJUSTICE_KEY_CATEGORY
            ));

    public static final Lazy<KeyMapping> FIRST_POWER_SECONDARY = Lazy.of(() -> new KeyMapping(
            "art5019sinjustice.key.power1_secondary",
            KeyConflictContext.UNIVERSAL,
            KeyModifier.SHIFT,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_Z,
            INJUSTICE_KEY_CATEGORY
    ));

    public static final Lazy<KeyMapping> SECOND_POWER = Lazy.of(() -> new KeyMapping(
            "art5019sinjustice.key.power2",
            KeyConflictContext.UNIVERSAL,
            KeyModifier.NONE,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_X,
            INJUSTICE_KEY_CATEGORY
    ));

    public static final Lazy<KeyMapping> SECOND_POWER_SECONDARY = Lazy.of(() -> new KeyMapping(
            "art5019sinjustice.key.power2_secondary",
            KeyConflictContext.UNIVERSAL,
            KeyModifier.SHIFT,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_X,
            INJUSTICE_KEY_CATEGORY
    ));



    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.registerCategory(INJUSTICE_KEY_CATEGORY);
        event.register(FIRST_POWER.get());
        event.register(FIRST_POWER_SECONDARY.get());
        event.register(SECOND_POWER.get());
        event.register(SECOND_POWER_SECONDARY.get());
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.gameMode == null || minecraft.gameMode.getPlayerMode() == GameType.SPECTATOR) {
            return;
        }
        while (FIRST_POWER.get().consumeClick()) {
            minecraft.getConnection().send(new PlayerUsesPowerPacket(0,false));
        }
        while (FIRST_POWER_SECONDARY.get().consumeClick()) {
            minecraft.getConnection().send(new PlayerUsesPowerPacket(0,true));
        }
        while (SECOND_POWER.get().consumeClick()) {
            minecraft.getConnection().send(new PlayerUsesPowerPacket(1,false));
        }
        while (SECOND_POWER_SECONDARY.get().consumeClick()) {
            minecraft.getConnection().send(new PlayerUsesPowerPacket(1,true));
        }
    }

}
