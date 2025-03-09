
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.artinjustice.network.SuitAbility1Message;
import net.mcreator.artinjustice.network.SetToolModeMessage;
import net.mcreator.artinjustice.network.ScratchMessage;
import net.mcreator.artinjustice.network.Ability5Message;
import net.mcreator.artinjustice.network.Ability4Message;
import net.mcreator.artinjustice.network.Ability3Message;
import net.mcreator.artinjustice.network.Ability2Message;
import net.mcreator.artinjustice.network.Ability1Message;
import net.mcreator.artinjustice.Art5019injusticeMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class Art5019injusticeModKeyMappings {
	public static final KeyMapping SET_TOOL_MODE = new KeyMapping("key.art5019injustice.set_tool_mode", GLFW.GLFW_KEY_K, "key.categories.inj") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new SetToolModeMessage(0, 0));
				SetToolModeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_1 = new KeyMapping("key.art5019injustice.ability_1", GLFW.GLFW_KEY_Z, "key.categories.inj") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new Ability1Message(0, 0));
				Ability1Message.pressAction(Minecraft.getInstance().player, 0, 0);
				ABILITY_1_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ABILITY_1_LASTPRESS);
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new Ability1Message(1, dt));
				Ability1Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_2 = new KeyMapping("key.art5019injustice.ability_2", GLFW.GLFW_KEY_X, "key.categories.inj") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new Ability2Message(0, 0));
				Ability2Message.pressAction(Minecraft.getInstance().player, 0, 0);
				ABILITY_2_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ABILITY_2_LASTPRESS);
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new Ability2Message(1, dt));
				Ability2Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_3 = new KeyMapping("key.art5019injustice.ability_3", GLFW.GLFW_KEY_C, "key.categories.inj") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new Ability3Message(0, 0));
				Ability3Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SUIT_ABILITY_1 = new KeyMapping("key.art5019injustice.suit_ability_1", GLFW.GLFW_KEY_N, "key.categories.inj") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new SuitAbility1Message(0, 0));
				SuitAbility1Message.pressAction(Minecraft.getInstance().player, 0, 0);
				SUIT_ABILITY_1_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SUIT_ABILITY_1_LASTPRESS);
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new SuitAbility1Message(1, dt));
				SuitAbility1Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_4 = new KeyMapping("key.art5019injustice.ability_4", GLFW.GLFW_KEY_V, "key.categories.inj") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new Ability4Message(0, 0));
				Ability4Message.pressAction(Minecraft.getInstance().player, 0, 0);
				ABILITY_4_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ABILITY_4_LASTPRESS);
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new Ability4Message(1, dt));
				Ability4Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_5 = new KeyMapping("key.art5019injustice.ability_5", GLFW.GLFW_KEY_B, "key.categories.inj") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new Ability5Message(0, 0));
				Ability5Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SCRATCH = new KeyMapping("key.art5019injustice.scratch", GLFW.GLFW_KEY_G, "key.categories.inj") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				Art5019injusticeMod.PACKET_HANDLER.sendToServer(new ScratchMessage(0, 0));
				ScratchMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long ABILITY_1_LASTPRESS = 0;
	private static long ABILITY_2_LASTPRESS = 0;
	private static long SUIT_ABILITY_1_LASTPRESS = 0;
	private static long ABILITY_4_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SET_TOOL_MODE);
		event.register(ABILITY_1);
		event.register(ABILITY_2);
		event.register(ABILITY_3);
		event.register(SUIT_ABILITY_1);
		event.register(ABILITY_4);
		event.register(ABILITY_5);
		event.register(SCRATCH);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SET_TOOL_MODE.consumeClick();
				ABILITY_1.consumeClick();
				ABILITY_2.consumeClick();
				ABILITY_3.consumeClick();
				SUIT_ABILITY_1.consumeClick();
				ABILITY_4.consumeClick();
				ABILITY_5.consumeClick();
				SCRATCH.consumeClick();
			}
		}
	}
}
