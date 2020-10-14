package randomWalk;

import mvc.*;
import simstation.*;

/**
 * RandomWalkFactory extends superclass SimulationFactory, override makeModel()
 * in superclass
 * 
 * @author xiaoli
 *
 */
public class RandomWalkFactory extends SimulationFactory {
	/**
	 * override method, override the makeModel()method in super class
	 * 
	 */
	public Model makeModel() {
		return new RandomWalk();
	}

}
