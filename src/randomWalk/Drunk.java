
package randomWalk;

import simstation.*;
import mvc.*;

/**
 * The drunk class extends superclass Agent, it updates its speed and heading.
 * 
 * @author xiaoli
 *
 */
public class Drunk extends Agent {

	private int speeds;

	/**
	 * constructor, invoke the super class constructor
	 */
	public Drunk() {
		super();
	}

	/**
	 * update() method, will update the heading and speed randomly
	 */
	public void update() {
		int distance = 25;
		Drunk neighbor = (Drunk) world.getNeighbor(this, distance);
		if (neighbor != null) {
			heading = Heading.getRandomHeading();
			speeds = Utilities.rng.nextInt(8) + 1;
		}
		move(speeds);
	}

}
