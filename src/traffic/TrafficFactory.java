package traffic;

import mvc.*;
import simstation.*;

/**
 * TrafficFactory extends superclass, override makeModel()
 */
public class TrafficFactory extends SimulationFactory {
	/**
	 * override method
	 */
	public Model makeModel() {
		return new Traffic();
	}

}
