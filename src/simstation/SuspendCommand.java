
package simstation;

import mvc.*;

/**
 * extend superclass Command,suspend the simulation
 *
 */
public class SuspendCommand extends Command {
	/**
	 * constructor, invoke superclass constructor
	 * 
	 * @param model
	 */
	public SuspendCommand(Model model) {
		super(model);
	}

	/**
	 * suspend the simulation,and notify listener
	 */
	public void execute() {
		Simulation simulation = (Simulation) model;
		simulation.suspend();
		simulation.changed();
	}
}
