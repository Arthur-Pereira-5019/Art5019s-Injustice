package net.mcreator.artinjustice.procedures;

public class PolioActiveTickConditionProcedure {
	public static boolean execute(double duration) {
		if (duration <= 12000) {
			if (duration % 160 == 0) {
				return true;
			}
		} else if (duration <= 24000) {
			if (duration % 300 == 0) {
				return true;
			}
		} else if (duration <= 36000) {
			if (duration % 480 == 0) {
				return true;
			}
		} else if (duration <= 48000) {
			if (duration % 680 == 0) {
				return true;
			}
		} else {
			if (duration % 900 == 0) {
				return true;
			}
		}
		if (duration % 1180 == 0) {
			return true;
		}
		return false;
	}
}
