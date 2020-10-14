package traffic;

import simstation.*;
import mvc.*;
import randomWalk.Drunk;
import randomWalk.RandomWalkFactory;

/**
 * traffic will add cars, and display panel
 *
 */
public class Traffic extends Simulation {
	/**
	 * constructor, invoke superclass constructor
	 */
	public Traffic() {
		super();
	}

	/**
	 * add cars
	 */
	public void populate() {
		for (int i = 0; i < 50; i++) {
			this.addAgent(new Car());
		}
	}

	/**
	 * display panel
	 * @param agrs arguments
	 */
	public static void main(String[] agrs) {
		SimulationPanel panel = new SimulationPanel(new TrafficFactory());
		panel.display();
	}
}
