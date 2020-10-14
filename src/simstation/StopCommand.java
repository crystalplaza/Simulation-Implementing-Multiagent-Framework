
package simstation;

import mvc.*;

/**
 * extends superclass from mvc package. Stop the simulation
 *
 */
public class StopCommand extends Command {
	/**
	 * constructor, invoke superclass constructor
	 * 
	 * @param model the model will stop command apply
	 */
	public StopCommand(Model model) {
		super(model);
	}

	/**
	 * stop the simulation, add notify the listener
	 */
	public void execute() {
		Simulation simulation = (Simulation) model;
		simulation.stop();
		simulation.changed();
	}
}
