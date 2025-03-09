package net.mcreator.artinjustice.procedures;

public class FluEffectStartedappliedProcedure {
	public static boolean execute(double amplifier, double duration) {
		double baseRate = 0;
		double rateWithAmplifier = 0;
		baseRate = 1300;
		rateWithAmplifier = baseRate / (2 * (amplifier + 1));
		if (Math.floor(rateWithAmplifier) > 0) {
			return duration % Math.floor(rateWithAmplifier) == 0;
		}
		return true;
	}
}
