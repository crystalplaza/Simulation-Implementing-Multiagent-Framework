
package simstation;

import mvc.*;

/**
 * execute start command, simulation start, and notify property listener
 *
 */
public class StartCommand extends Command {

	/**
	 * constructor, invoke superclass constructor
	 * 
	 * @param model
	 */
	public StartCommand(Model model) {
		super(model);
	}

	/**
	 * override method, make the simulation start and notify changes
	 */
	public void execute() {
		Simulation simulation = (Simulation) model;
		simulation.start();
		simulation.changed();
	}
}
