
package simstation;

import mvc.*;

/**
 * The class will execute the resume command, and notify property listener.
 *
 */
public class ResumeCommand extends Command {
	/**
	 * constructor
	 * 
	 * @param model model that command will apply
	 */
	public ResumeCommand(Model model) {
		super(model);
	}

	/**
	 * execute() method resumes command, and notify the property listener
	 */
	public void execute() {
		Simulation simulation = (Simulation) model;
		simulation.resume();
		simulation.changed();
	}
}
