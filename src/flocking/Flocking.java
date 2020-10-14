
package flocking;

import simstation.*;

/**
 * Flocking class add a population of birds, and also contains main method.
 * 
 * @author xiaoli
 *
 */
public class Flocking extends Simulation {
	/**
	 * constructor, Flocking class invoke the constructor from super class
	 * Simulation
	 */
	public Flocking() {
		super();
	}

	/**
	 * override method. 50 birds are added to this flock.
	 */
	public void populate() {
		for (int i = 0; i < 50; i++) {
			this.addAgent(new Birds());
		}
	}

	/**
	 * main method
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		SimulationPanel panel = new SimulationPanel(new FlockingFactory());
		panel.display();
	}

}