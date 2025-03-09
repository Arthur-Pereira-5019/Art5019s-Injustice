package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.Entity;

public class RandomNamingProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		double names = 0;
		double probs = 0;
		probs = Math.random();
		if (!world.isClientSide()) {
			if (entity instanceof Wolf) {
				names = 20;
				if (probs < (1 / names) * 1) {
					return "Thor";
				} else if (probs < (1 / names) * 2) {
					return "Rex";
				} else if (probs < (1 / names) * 3) {
					return "Krypto";
				} else if (probs < (1 / names) * 4) {
					return "Ace";
				} else if (probs < (1 / names) * 5) {
					return "Winston";
				} else if (probs < (1 / names) * 6) {
					return "Zeus";
				} else if (probs < (1 / names) * 7) {
					return "Rinque";
				} else if (probs < (1 / names) * 8) {
					return "Perla";
				} else if (probs < (1 / names) * 9) {
					return "Cristal";
				} else if (probs < (1 / names) * 10) {
					return "Esmeralda";
				} else if (probs < (1 / names) * 11) {
					return "Valente";
				} else if (probs < (1 / names) * 12) {
					return "Mada";
				} else if (probs < (1 / names) * 13) {
					return "Emerald";
				} else if (probs < (1 / names) * 14) {
					return "Flash";
				} else if (probs < (1 / names) * 15) {
					return "Hulk";
				} else if (probs < (1 / names) * 16) {
					return "Jack";
				} else if (probs < (1 / names) * 17) {
					return "Bolt";
				} else if (probs < (1 / names) * 18) {
					return "Pen\u00E9lope";
				} else if (probs < (1 / names) * 19) {
					return "Chewbaka";
				} else if (probs < (1 / names) * 20) {
					return "Floyd";
				}
			} else if (entity instanceof Cat) {
				names = 26;
				if (Math.random() == (1 / names) * 1) {
					return "Streaky";
				} else if (probs == (1 / names) * 2) {
					return "Tuti";
				} else if (probs == (1 / names) * 3) {
					return "Krypto";
				} else if (probs == (1 / names) * 4) {
					return "Dexter";
				} else if (probs == (1 / names) * 5) {
					return "Luffy";
				} else if (probs == (1 / names) * 6) {
					return "Moby";
				} else if (probs == (1 / names) * 7) {
					return "Safira";
				} else if (probs == (1 / names) * 8) {
					return "Dick";
				} else if (probs == (1 / names) * 9) {
					return "Mirtilo";
				} else if (probs == (1 / names) * 10) {
					return "Fuma\u00E7a";
				} else if (probs == (1 / names) * 11) {
					return "Preta";
				} else if (probs == (1 / names) * 12) {
					return "Desastrado";
				} else if (probs == (1 / names) * 13) {
					return "Gat\u00E3o";
				} else if (probs == (1 / names) * 14) {
					return "Vinicius";
				} else if (probs == (1 / names) * 15) {
					return "She-Ra";
				} else if (probs == (1 / names) * 16) {
					return "On\u00E7a";
				} else if (probs == (1 / names) * 17) {
					return "Johnny";
				} else if (probs == (1 / names) * 18) {
					return "Cash";
				} else if (probs == (1 / names) * 19) {
					return "Shine";
				} else if (probs == (1 / names) * 20) {
					return "Nutella";
				} else if (probs == (1 / names) * 21) {
					return "Dora";
				} else if (probs == (1 / names) * 22) {
					return "Hyuga";
				} else if (probs == (1 / names) * 23) {
					return "Freya";
				} else if (probs == (1 / names) * 24) {
					return "Nene";
				} else if (probs == (1 / names) * 25) {
					return "Lola";
				} else if (probs == (1 / names) * 26) {
					return "Zuli";
				}
			} else if (entity instanceof Parrot) {
				names = 7;
				if (Math.random() == (1 / names) * 1) {
					return "Blu";
				} else if (Math.random() == (1 / names) * 2) {
					return "Jade";
				} else if (Math.random() == (1 / names) * 3) {
					return "Kaiser";
				} else if (Math.random() == (1 / names) * 4) {
					return "Shell";
				} else if (Math.random() == (1 / names) * 5) {
					return "Nina";
				} else if (Math.random() == (1 / names) * 6) {
					return "Toto";
				} else if (Math.random() == (1 / names) * 7) {
					return "Maria";
				}
			}
		}
		return "";
	}
}
