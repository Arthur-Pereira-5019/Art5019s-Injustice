package com.art5019.art5019s_injustice.network;

import com.art5019.art5019s_injustice.graphics.toast.SkillToast;
import net.minecraft.client.Minecraft;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientPayloadHandler {
    public static void handleDataOnMain(final SkillLevelUpPacket data, final IPayloadContext context) {
        handleSkillLevelUpToast(data);
    }

    private static void handleSkillLevelUpToast(SkillLevelUpPacket data) {
        Minecraft minecraft = Minecraft.getInstance();
        SkillToast.addOrUpdate(minecraft.gui.toastManager(),data);
    }

}
