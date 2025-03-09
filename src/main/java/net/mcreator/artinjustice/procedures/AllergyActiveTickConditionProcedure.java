package net.mcreator.artinjustice.procedures;

public class AllergyActiveTickConditionProcedure {
	public static boolean execute(double duration) {
		double baseRate = 0;
		double rateWithAmplifier = 0;
		rateWithAmplifier = 120;
		if (Math.floor(rateWithAmplifier) > 0) {
			return duration % Math.floor(rateWithAmplifier) == 0;
		}
		return true;
	}
}
