package com.art5019.art5019s_injustice.data.emissors;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.attachment.AttachmentSyncHandler;
import net.neoforged.neoforge.attachment.IAttachmentHolder;

import javax.annotation.Nullable;
import java.util.ArrayList;

import static com.art5019.art5019s_injustice.data.DataAttachments.*;

public class EmissorSyncHandler implements AttachmentSyncHandler<ArrayList<Emissor>> {

    @Override
    public void write(RegistryFriendlyByteBuf buf, ArrayList<Emissor> attachment, boolean initialSync) {
        EMISSOR_STREAM_CODEC_LIST.encode(buf, attachment);
    }

    @Override
    @Nullable
    public ArrayList<Emissor> read(IAttachmentHolder holder, RegistryFriendlyByteBuf buf, @Nullable ArrayList<Emissor> previousValue) {
        if (previousValue == null) {
            return new ArrayList<>(EMISSOR_STREAM_CODEC_LIST.decode(buf));
        } else {
            return previousValue;
        }
    }

    @Override
    public boolean sendToPlayer(IAttachmentHolder holder, ServerPlayer to) {
        if(holder instanceof Level level) {
            return to.level().equals(level);
        }
        return false;
    }
}


