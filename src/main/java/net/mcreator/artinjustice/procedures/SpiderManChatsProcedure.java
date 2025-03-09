package net.mcreator.artinjustice.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class SpiderManChatsProcedure {
	public static boolean execute(Entity entity, String text) {
		if (entity == null || text == null)
			return false;
		double Scaling = 0;
		ItemStack bottle = ItemStack.EMPTY;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.INTERFERENCE.get()))
				|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.INTERFERENCE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.INTERFERENCE.get()).getAmplifier() : 0) < 1) {
			if ((text).equals("Instakill")) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("instaKill")) {
					InstaKillDesactivateProcedure.execute(entity);
					return true;
				} else {
					InstaKillActivateProcedure.execute(entity);
					return true;
				}
			} else if ((text).equals("Police Radio")) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("policeRadio")) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Jarvis> Shutting down the connection to the Police Frequence"), false);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Jarvis> Connecting to Police Frequence"), false);
				}
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("policeRadio",
						(!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("policeRadio"))));
				return true;
			} else if ((text).equals("Voice Commands")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal("<Karen> Welcome to the assisted help guide, Type: 1- Instant Kill Mode Help; 2- Heater Function Help; 3- Parachute Gadget Help; 4 - Radio Mode; 5 - Police Radio Mode; 0 - Exit the Help Guide."), false);
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("helpMode", true);
				return true;
			} else if ((text).equals("Radio")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Karen> Activating Radio Mode"), false);
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("radioMode", true);
				return true;
			} else if (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(text) <= 10) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("radioMode") && new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(text) > 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("<Karen> Now listening to Frequency: " + new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(text))), false);
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble("listeningId", new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(text));
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("radioMode", false);
					return true;
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("radioMode") && new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(text) <= 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Karen> Unknown frequency, shutting down Radio Mode"), false);
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble("listeningId", 0);
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("radioMode", false);
					return true;
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("helpMode")) {
					if ((text).equals("0")) {
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("helpMode", false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Karen> Exiting the Help Guide."), false);
						return true;
					} else if ((text).equals("1")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(
									"<Karen> The Instant Kill Mode allows the Tier 2 Webshooters to activate lethal force shots. Increasing the damage of regular shots, allowing Web Dashes to go farther, giving more shots and reducing the cadency of Rapid Webs, increasing the voltage of Electrical Web and the overall power of Impact Webs. All the shots go faster and the Web Shooter have a slower cooldown time, but in exchange, the Web Shooter takes more damage between shots. To activate the Instant Kill Mode. Press the Set Tool Mode button while sneaking in a dangerous situation or simply type \"Instakill\". For desactivating the mode, repeat any of both steps again in a safer environment."),
									false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Karen> Exiting the Help Guide."), false);
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("helpMode", false);
						return true;
					} else if ((text).equals("2")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Karen> Each piece of the suit comes with a Heater Function that immediately activates when the player is freezing. Can be desactivated and doesn't damage the suit."),
									false);
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("helpMode", false);
						return true;
					} else if ((text).equals("3")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal(
											"<Karen> The Suit chestplate comes with a embed Parachute, that slows down the player fall speed. To toggle the Parachute, press the Set Tool Mode key while Sneaking. Disactivates immediately on ground."),
									false);
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("helpMode", false);
						return true;
					} else if ((text).equals("4")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal(
											"<Karen> The mask comes with an embeded radio, which can be turned on by simply saying \"Radio\". After that, just type the frequency, and after it, anything said on that frequency will be sent to you."),
									false);
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("helpMode", false);
						return true;
					} else if ((text).equals("5")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal(
											"<Karen> The mask comes with an embeded radio, which can be used to connect on the local police frequency, by simply saying \"Police Radio\", wich will allow you to know about any crime related events."),
									false);
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("helpMode", false);
						return true;
					}
				}
			}
		} else if ((text).equals("Radio") || (text).equals("Voice Commands") || (text).equals("Instakill") || new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(text) <= 10 && ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("helpMode")
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("radioMode"))) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c<Karen> Something... went... wrong..."), false);
			return true;
		}
		return false;
	}
}
