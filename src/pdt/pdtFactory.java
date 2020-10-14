package pdt;

import mvc.*;
import simstation.*;

/**
 * pdtfactory extend superclass SimulationFactory. It override one method
 * makeModel() in superclass
 *
 */
public class pdtFactory extends SimulationFactory {
	/**
	 * constructor, override the constructor in superclass
	 */
	public Model makeModel() {
		return new PDTournament();
	}

}