package net.mcreator.artinjustice.procedures;

public class PlagueActiveTickConditionProcedure {
	public static boolean execute(double duration) {
		double baseRate = 0;
		double rateWithAmplifier = 0;
		baseRate = 400;
		rateWithAmplifier = baseRate;
		if (Math.floor(rateWithAmplifier) > 0) {
			return duration % Math.floor(rateWithAmplifier) == 0;
		}
		return true;
	}
}
