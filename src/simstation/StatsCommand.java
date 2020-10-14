
package simstation;

import javax.swing.JOptionPane;

import mvc.*;
import java.util.*;

/**
 * statsCommand extends superclass, get statistics on simulation.
 *
 */
public class StatsCommand extends Command {
	/**
	 * constructor, invoke the superclass constructor
	 * 
	 * @param model
	 */
	public StatsCommand(Model model) {
		super(model);
	}

	/**
	 * get simulaton statistics. notify listener
	 */
	public void execute() {
		Simulation simulation = (Simulation) model;
		String[] massages = simulation.getStats();

		Utilities.inform(massages);
		simulation.changed();
	}
}
