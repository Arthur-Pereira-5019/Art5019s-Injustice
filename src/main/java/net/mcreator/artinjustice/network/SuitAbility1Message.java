
package net.mcreator.artinjustice.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.artinjustice.procedures.SuitAbility1OnKeyReleasedProcedure;
import net.mcreator.artinjustice.procedures.SuitAbility1OnKeyPressedProcedure;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SuitAbility1Message {
	int type, pressedms;

	public SuitAbility1Message(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public SuitAbility1Message(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(SuitAbility1Message message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(SuitAbility1Message message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			SuitAbility1OnKeyPressedProcedure.execute(world, x, y, z, entity);
		}
		if (type == 1) {

			SuitAbility1OnKeyReleasedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		Art5019injusticeMod.addNetworkMessage(SuitAbility1Message.class, SuitAbility1Message::buffer, SuitAbility1Message::new, SuitAbility1Message::handler);
	}
}
