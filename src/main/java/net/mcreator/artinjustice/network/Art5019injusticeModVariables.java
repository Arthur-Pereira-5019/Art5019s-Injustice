package net.mcreator.artinjustice.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Art5019injusticeModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		Art5019injusticeMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		Art5019injusticeMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.powerid = original.powerid;
			clone.regenerationlevel = original.regenerationlevel;
			clone.jumpboostlevel = original.jumpboostlevel;
			clone.ability1holding = original.ability1holding;
			clone.fallimmune = original.fallimmune;
			clone.spidersensedisplay = original.spidersensedisplay;
			clone.powerlvl = original.powerlvl;
			clone.deathstrokeid = original.deathstrokeid;
			clone.ranToday = original.ranToday;
			clone.ability1_toggle = original.ability1_toggle;
			clone.ability3toggle = original.ability3toggle;
			clone.flyspeed = original.flyspeed;
			clone.flyingspeed = original.flyingspeed;
			clone.ability33toggle = original.ability33toggle;
			clone.ability1cooldown = original.ability1cooldown;
			clone.fearimmune = original.fearimmune;
			clone.ability4cooldown = original.ability4cooldown;
			clone.alignment = original.alignment;
			clone.suitability1holding = original.suitability1holding;
			clone.toxicRes = original.toxicRes;
			clone.ability2cooldown = original.ability2cooldown;
			clone.maxSpeed = original.maxSpeed;
			clone.currentSpeed = original.currentSpeed;
			clone.masspunch = original.masspunch;
			clone.ability2toggle = original.ability2toggle;
			clone.lucklevel = original.lucklevel;
			clone.hungerlevel = original.hungerlevel;
			clone.ability2holding = original.ability2holding;
			clone.powerxp = original.powerxp;
			clone.suitability1cooldown = original.suitability1cooldown;
			clone.suitid = original.suitid;
			clone.hastelevel = original.hastelevel;
			clone.wbreathes = original.wbreathes;
			clone.ability4toggle = original.ability4toggle;
			clone.ability3cooldown = original.ability3cooldown;
			clone.ability3duration = original.ability3duration;
			clone.ability4duration = original.ability4duration;
			clone.trackerid = original.trackerid;
			clone.listeningid = original.listeningid;
			clone.ability5cooldown = original.ability5cooldown;
			clone.ability5duration = original.ability5duration;
			clone.quickuse = original.quickuse;
			clone.ability6cooldown = original.ability6cooldown;
			clone.powerphase = original.powerphase;
			clone.resistancelevel = original.resistancelevel;
			clone.sunWeakness = original.sunWeakness;
			clone.lang = original.lang;
			clone.dub = original.dub;
			clone.visionq = original.visionq;
			clone.ability7cooldown = original.ability7cooldown;
			clone.electricityresistance = original.electricityresistance;
			clone.targetid = original.targetid;
			clone.powermeter = original.powermeter;
			clone.uncontrolledpowercooldown = original.uncontrolledpowercooldown;
			clone.uncontrolledpoweractivated = original.uncontrolledpoweractivated;
			clone.ability4holding = original.ability4holding;
			clone.res_fire = original.res_fire;
			clone.tp_n2 = original.tp_n2;
			clone.tp_res = original.tp_res;
			clone.tp_idop = original.tp_idop;
			clone.gossipid = original.gossipid;
			if (!event.isWasDeath()) {
				clone.selfdestructtick = original.selfdestructtick;
				clone.runningt = original.runningt;
				clone.possessed = original.possessed;
				clone.possessedhealth = original.possessedhealth;
				clone.lost_blood = original.lost_blood;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					Art5019injusticeMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					Art5019injusticeMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					Art5019injusticeMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "art5019injustice_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				Art5019injusticeMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "art5019injustice_mapvars";
		public double event_id = 0;
		public double today_news = 0;
		public double criminality_rate = 1.0;
		public double event_meter = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			event_id = nbt.getDouble("event_id");
			today_news = nbt.getDouble("today_news");
			criminality_rate = nbt.getDouble("criminality_rate");
			event_meter = nbt.getDouble("event_meter");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("event_id", event_id);
			nbt.putDouble("today_news", today_news);
			nbt.putDouble("criminality_rate", criminality_rate);
			nbt.putDouble("event_meter", event_meter);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				Art5019injusticeMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("art5019injustice", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double powerid = 0;
		public double regenerationlevel = 0;
		public double jumpboostlevel = 0;
		public boolean ability1holding = false;
		public boolean fallimmune = false;
		public double spidersensedisplay = 0;
		public double powerlvl = 0;
		public double deathstrokeid = 0;
		public double ranToday = 0;
		public boolean ability1_toggle = false;
		public boolean ability3toggle = false;
		public double flyspeed = 0;
		public double flyingspeed = 0.5;
		public double ability33toggle = 0;
		public double ability1cooldown = 0;
		public boolean fearimmune = false;
		public double ability4cooldown = 0;
		public double selfdestructtick = 0;
		public double alignment = 0;
		public boolean suitability1holding = false;
		public double toxicRes = 0;
		public double ability2cooldown = 0;
		public double maxSpeed = 0;
		public double currentSpeed = 0;
		public double masspunch = 0;
		public boolean ability2toggle = false;
		public double lucklevel = 0;
		public double hungerlevel = 0;
		public boolean ability2holding = false;
		public double powerxp = 0;
		public double suitability1cooldown = 0;
		public double suitid = 0;
		public double hastelevel = 0;
		public boolean wbreathes = false;
		public boolean ability4toggle = false;
		public double ability3cooldown = 0;
		public double ability3duration = 0;
		public double ability4duration = 0;
		public double trackerid = 0;
		public double listeningid = 0;
		public double ability5cooldown = 0;
		public double ability5duration = 0;
		public double quickuse = 0;
		public double ability6cooldown = 0;
		public double powerphase = 0;
		public double resistancelevel = 0;
		public boolean sunWeakness = false;
		public double runningt = 0;
		public double lang = 0;
		public boolean dub = false;
		public double visionq = 0;
		public double ability7cooldown = 0;
		public double electricityresistance = 0;
		public boolean possessed = false;
		public double possessedhealth = 0;
		public String targetid = "\"\"";
		public double powermeter = 0;
		public double uncontrolledpowercooldown = 0;
		public double uncontrolledpoweractivated = 0;
		public boolean ability4holding = false;
		public double res_fire = 0;
		public double tp_n2 = 0;
		public double tp_res = 0;
		public double tp_idop = 0;
		public double lost_blood = 0;
		public double gossipid = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				Art5019injusticeMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("powerid", powerid);
			nbt.putDouble("regenerationlevel", regenerationlevel);
			nbt.putDouble("jumpboostlevel", jumpboostlevel);
			nbt.putBoolean("ability1holding", ability1holding);
			nbt.putBoolean("fallimmune", fallimmune);
			nbt.putDouble("spidersensedisplay", spidersensedisplay);
			nbt.putDouble("powerlvl", powerlvl);
			nbt.putDouble("deathstrokeid", deathstrokeid);
			nbt.putDouble("ranToday", ranToday);
			nbt.putBoolean("ability1_toggle", ability1_toggle);
			nbt.putBoolean("ability3toggle", ability3toggle);
			nbt.putDouble("flyspeed", flyspeed);
			nbt.putDouble("flyingspeed", flyingspeed);
			nbt.putDouble("ability33toggle", ability33toggle);
			nbt.putDouble("ability1cooldown", ability1cooldown);
			nbt.putBoolean("fearimmune", fearimmune);
			nbt.putDouble("ability4cooldown", ability4cooldown);
			nbt.putDouble("selfdestructtick", selfdestructtick);
			nbt.putDouble("alignment", alignment);
			nbt.putBoolean("suitability1holding", suitability1holding);
			nbt.putDouble("toxicRes", toxicRes);
			nbt.putDouble("ability2cooldown", ability2cooldown);
			nbt.putDouble("maxSpeed", maxSpeed);
			nbt.putDouble("currentSpeed", currentSpeed);
			nbt.putDouble("masspunch", masspunch);
			nbt.putBoolean("ability2toggle", ability2toggle);
			nbt.putDouble("lucklevel", lucklevel);
			nbt.putDouble("hungerlevel", hungerlevel);
			nbt.putBoolean("ability2holding", ability2holding);
			nbt.putDouble("powerxp", powerxp);
			nbt.putDouble("suitability1cooldown", suitability1cooldown);
			nbt.putDouble("suitid", suitid);
			nbt.putDouble("hastelevel", hastelevel);
			nbt.putBoolean("wbreathes", wbreathes);
			nbt.putBoolean("ability4toggle", ability4toggle);
			nbt.putDouble("ability3cooldown", ability3cooldown);
			nbt.putDouble("ability3duration", ability3duration);
			nbt.putDouble("ability4duration", ability4duration);
			nbt.putDouble("trackerid", trackerid);
			nbt.putDouble("listeningid", listeningid);
			nbt.putDouble("ability5cooldown", ability5cooldown);
			nbt.putDouble("ability5duration", ability5duration);
			nbt.putDouble("quickuse", quickuse);
			nbt.putDouble("ability6cooldown", ability6cooldown);
			nbt.putDouble("powerphase", powerphase);
			nbt.putDouble("resistancelevel", resistancelevel);
			nbt.putBoolean("sunWeakness", sunWeakness);
			nbt.putDouble("runningt", runningt);
			nbt.putDouble("lang", lang);
			nbt.putBoolean("dub", dub);
			nbt.putDouble("visionq", visionq);
			nbt.putDouble("ability7cooldown", ability7cooldown);
			nbt.putDouble("electricityresistance", electricityresistance);
			nbt.putBoolean("possessed", possessed);
			nbt.putDouble("possessedhealth", possessedhealth);
			nbt.putString("targetid", targetid);
			nbt.putDouble("powermeter", powermeter);
			nbt.putDouble("uncontrolledpowercooldown", uncontrolledpowercooldown);
			nbt.putDouble("uncontrolledpoweractivated", uncontrolledpoweractivated);
			nbt.putBoolean("ability4holding", ability4holding);
			nbt.putDouble("res_fire", res_fire);
			nbt.putDouble("tp_n2", tp_n2);
			nbt.putDouble("tp_res", tp_res);
			nbt.putDouble("tp_idop", tp_idop);
			nbt.putDouble("lost_blood", lost_blood);
			nbt.putDouble("gossipid", gossipid);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			powerid = nbt.getDouble("powerid");
			regenerationlevel = nbt.getDouble("regenerationlevel");
			jumpboostlevel = nbt.getDouble("jumpboostlevel");
			ability1holding = nbt.getBoolean("ability1holding");
			fallimmune = nbt.getBoolean("fallimmune");
			spidersensedisplay = nbt.getDouble("spidersensedisplay");
			powerlvl = nbt.getDouble("powerlvl");
			deathstrokeid = nbt.getDouble("deathstrokeid");
			ranToday = nbt.getDouble("ranToday");
			ability1_toggle = nbt.getBoolean("ability1_toggle");
			ability3toggle = nbt.getBoolean("ability3toggle");
			flyspeed = nbt.getDouble("flyspeed");
			flyingspeed = nbt.getDouble("flyingspeed");
			ability33toggle = nbt.getDouble("ability33toggle");
			ability1cooldown = nbt.getDouble("ability1cooldown");
			fearimmune = nbt.getBoolean("fearimmune");
			ability4cooldown = nbt.getDouble("ability4cooldown");
			selfdestructtick = nbt.getDouble("selfdestructtick");
			alignment = nbt.getDouble("alignment");
			suitability1holding = nbt.getBoolean("suitability1holding");
			toxicRes = nbt.getDouble("toxicRes");
			ability2cooldown = nbt.getDouble("ability2cooldown");
			maxSpeed = nbt.getDouble("maxSpeed");
			currentSpeed = nbt.getDouble("currentSpeed");
			masspunch = nbt.getDouble("masspunch");
			ability2toggle = nbt.getBoolean("ability2toggle");
			lucklevel = nbt.getDouble("lucklevel");
			hungerlevel = nbt.getDouble("hungerlevel");
			ability2holding = nbt.getBoolean("ability2holding");
			powerxp = nbt.getDouble("powerxp");
			suitability1cooldown = nbt.getDouble("suitability1cooldown");
			suitid = nbt.getDouble("suitid");
			hastelevel = nbt.getDouble("hastelevel");
			wbreathes = nbt.getBoolean("wbreathes");
			ability4toggle = nbt.getBoolean("ability4toggle");
			ability3cooldown = nbt.getDouble("ability3cooldown");
			ability3duration = nbt.getDouble("ability3duration");
			ability4duration = nbt.getDouble("ability4duration");
			trackerid = nbt.getDouble("trackerid");
			listeningid = nbt.getDouble("listeningid");
			ability5cooldown = nbt.getDouble("ability5cooldown");
			ability5duration = nbt.getDouble("ability5duration");
			quickuse = nbt.getDouble("quickuse");
			ability6cooldown = nbt.getDouble("ability6cooldown");
			powerphase = nbt.getDouble("powerphase");
			resistancelevel = nbt.getDouble("resistancelevel");
			sunWeakness = nbt.getBoolean("sunWeakness");
			runningt = nbt.getDouble("runningt");
			lang = nbt.getDouble("lang");
			dub = nbt.getBoolean("dub");
			visionq = nbt.getDouble("visionq");
			ability7cooldown = nbt.getDouble("ability7cooldown");
			electricityresistance = nbt.getDouble("electricityresistance");
			possessed = nbt.getBoolean("possessed");
			possessedhealth = nbt.getDouble("possessedhealth");
			targetid = nbt.getString("targetid");
			powermeter = nbt.getDouble("powermeter");
			uncontrolledpowercooldown = nbt.getDouble("uncontrolledpowercooldown");
			uncontrolledpoweractivated = nbt.getDouble("uncontrolledpoweractivated");
			ability4holding = nbt.getBoolean("ability4holding");
			res_fire = nbt.getDouble("res_fire");
			tp_n2 = nbt.getDouble("tp_n2");
			tp_res = nbt.getDouble("tp_res");
			tp_idop = nbt.getDouble("tp_idop");
			lost_blood = nbt.getDouble("lost_blood");
			gossipid = nbt.getDouble("gossipid");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.powerid = message.data.powerid;
					variables.regenerationlevel = message.data.regenerationlevel;
					variables.jumpboostlevel = message.data.jumpboostlevel;
					variables.ability1holding = message.data.ability1holding;
					variables.fallimmune = message.data.fallimmune;
					variables.spidersensedisplay = message.data.spidersensedisplay;
					variables.powerlvl = message.data.powerlvl;
					variables.deathstrokeid = message.data.deathstrokeid;
					variables.ranToday = message.data.ranToday;
					variables.ability1_toggle = message.data.ability1_toggle;
					variables.ability3toggle = message.data.ability3toggle;
					variables.flyspeed = message.data.flyspeed;
					variables.flyingspeed = message.data.flyingspeed;
					variables.ability33toggle = message.data.ability33toggle;
					variables.ability1cooldown = message.data.ability1cooldown;
					variables.fearimmune = message.data.fearimmune;
					variables.ability4cooldown = message.data.ability4cooldown;
					variables.selfdestructtick = message.data.selfdestructtick;
					variables.alignment = message.data.alignment;
					variables.suitability1holding = message.data.suitability1holding;
					variables.toxicRes = message.data.toxicRes;
					variables.ability2cooldown = message.data.ability2cooldown;
					variables.maxSpeed = message.data.maxSpeed;
					variables.currentSpeed = message.data.currentSpeed;
					variables.masspunch = message.data.masspunch;
					variables.ability2toggle = message.data.ability2toggle;
					variables.lucklevel = message.data.lucklevel;
					variables.hungerlevel = message.data.hungerlevel;
					variables.ability2holding = message.data.ability2holding;
					variables.powerxp = message.data.powerxp;
					variables.suitability1cooldown = message.data.suitability1cooldown;
					variables.suitid = message.data.suitid;
					variables.hastelevel = message.data.hastelevel;
					variables.wbreathes = message.data.wbreathes;
					variables.ability4toggle = message.data.ability4toggle;
					variables.ability3cooldown = message.data.ability3cooldown;
					variables.ability3duration = message.data.ability3duration;
					variables.ability4duration = message.data.ability4duration;
					variables.trackerid = message.data.trackerid;
					variables.listeningid = message.data.listeningid;
					variables.ability5cooldown = message.data.ability5cooldown;
					variables.ability5duration = message.data.ability5duration;
					variables.quickuse = message.data.quickuse;
					variables.ability6cooldown = message.data.ability6cooldown;
					variables.powerphase = message.data.powerphase;
					variables.resistancelevel = message.data.resistancelevel;
					variables.sunWeakness = message.data.sunWeakness;
					variables.runningt = message.data.runningt;
					variables.lang = message.data.lang;
					variables.dub = message.data.dub;
					variables.visionq = message.data.visionq;
					variables.ability7cooldown = message.data.ability7cooldown;
					variables.electricityresistance = message.data.electricityresistance;
					variables.possessed = message.data.possessed;
					variables.possessedhealth = message.data.possessedhealth;
					variables.targetid = message.data.targetid;
					variables.powermeter = message.data.powermeter;
					variables.uncontrolledpowercooldown = message.data.uncontrolledpowercooldown;
					variables.uncontrolledpoweractivated = message.data.uncontrolledpoweractivated;
					variables.ability4holding = message.data.ability4holding;
					variables.res_fire = message.data.res_fire;
					variables.tp_n2 = message.data.tp_n2;
					variables.tp_res = message.data.tp_res;
					variables.tp_idop = message.data.tp_idop;
					variables.lost_blood = message.data.lost_blood;
					variables.gossipid = message.data.gossipid;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
