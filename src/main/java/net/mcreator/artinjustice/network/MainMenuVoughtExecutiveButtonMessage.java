
package net.mcreator.artinjustice.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.world.inventory.MainMenuVoughtExecutiveMenu;
import net.mcreator.artinjustice.procedures.VoughtExecutiveMerchandisingButtonProcedure;
import net.mcreator.artinjustice.procedures.SuitSchemeVoughtExecutiveBuyButtonProcedure;
import net.mcreator.artinjustice.procedures.OpenInfluenceMenuVoughtExecutiveProcedure;
import net.mcreator.artinjustice.procedures.MainMenuVoughtExecutivePowersButtonPressedProcedure;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MainMenuVoughtExecutiveButtonMessage {
	private final int buttonID, x, y, z;

	public MainMenuVoughtExecutiveButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MainMenuVoughtExecutiveButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MainMenuVoughtExecutiveButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MainMenuVoughtExecutiveButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = MainMenuVoughtExecutiveMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MainMenuVoughtExecutivePowersButtonPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SuitSchemeVoughtExecutiveBuyButtonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenInfluenceMenuVoughtExecutiveProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			VoughtExecutiveMerchandisingButtonProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		Art5019injusticeMod.addNetworkMessage(MainMenuVoughtExecutiveButtonMessage.class, MainMenuVoughtExecutiveButtonMessage::buffer, MainMenuVoughtExecutiveButtonMessage::new, MainMenuVoughtExecutiveButtonMessage::handler);
	}
}
