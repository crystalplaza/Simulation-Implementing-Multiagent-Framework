
package simstation;

import mvc.*;

/**
 * SimulationFactory can makeMode(). It will get information on the simulation,
 * such as, title, command, version
 * 
 * @author xiaoli
 *
 */
public class SimulationFactory implements SimFactory {
	/**
	 * override superclass makeModel()
	 */
	public Model makeModel() {
		return new Simulation();
	}

	/**
	 * get Edit command
	 */
	public String[] getEditCommands() {
		return new String[] { "Start", "Suspend", "Resume", "Stop", "Stats" };
	}

	/**
	 * make commands, start, suspend, resume, stop
	 */
	public Command makeEditCommand(Model model, String type) {

		if (type == "Start")
			return new StartCommand(model);
		if (type == "Suspend")
			return new SuspendCommand(model);
		if (type == "Resume")
			return new ResumeCommand(model);
		if (type == "Stop")
			return new StopCommand(model);
		if (type == "Stats")
			return new StatsCommand(model);
		return null;

	}

	/**
	 * getter simulation title
	 */
	public String getTitle() {
		return "Simstation";
	}

	/**
	 * getter help
	 */
	public String[] getHelp() {
		return new String[] { "click buttons to make changes" };
	}

	/**
	 * add about information, eg,version, year
	 */
	public String about() {
		return "Simstation version1.0. Copyright 2020.";
	}

	/**
	 * getView() override method in superclass
	 */
	public View getView(Model model) {
		return new SimulationView(model);

	}

}
