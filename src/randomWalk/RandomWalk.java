
package randomWalk;

import simstation.*;

/**
 * Randomwalk class extends superclass simulation.It create 50 drunks. And main method 
 * is include in the class.
 * @author xiaoli
 *
 */
public class RandomWalk extends Simulation {

	/**
	 * constructor, invoke the superclass constructor
	 */
	public RandomWalk() {
		super();
	}
	
	/**
	 * create 50 drunks
	 */
	public void populate() {
	    for(int i = 0; i < 50; i++) { 
	    	this.addAgent(new Drunk()); 
	    }
	 }
    /**
     * main method, display the panel for drunks
     * @param agrs arguments
     */
	public static void main(String[] agrs) {
		SimulationPanel panel = new SimulationPanel(new RandomWalkFactory());
		panel.display();
	}
}
