package net.mcreator.artinjustice.procedures;

public class ReturnNewsEventProcedure {
	public static String execute(double event, double eventm) {
		String eventname = "";
		if (event == 0) {
			eventname = "None";
		} else if (event == 1) {
			eventname = "Earth X Invasion";
		} else if (event == 2) {
			eventname = "Rise of the Inner Demons";
		}
		return "Event: " + eventname + ", Percentage: " + eventm * 100 + "%";
	}
}
