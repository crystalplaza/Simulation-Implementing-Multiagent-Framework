package flocking;

import mvc.*;
import simstation.*;

/**
 * This class extends superclass, override makeModel
 * 
 * @author xiaoli
 *
 */
public class FlockingFactory extends SimulationFactory {
	/**
	 * MakModel override the method in superclass
	 */
	public Model makeModel() {
		return new Flocking();
	}
}