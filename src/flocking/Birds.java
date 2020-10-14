
package flocking;

import mvc.*;
import simstation.*;

/**
 * Birds are agents. Each bird has a heading and speed. The bird will copy
 * neighbor's speed and direction.
 * 
 * @author xiaoli
 *
 */
public class Birds extends Agent {
	private int speeds;

	/**
	 * constructor for birds, each bird will have a random speed.
	 */
	public Birds() {
		super();
		speeds = Utilities.rng.nextInt(10) + 1;
	}

	/**
	 * override method update(), extends update() method from Agent
	 */
	public void update() {
		int distance = 10;
		Birds neighbor = (Birds) world.getNeighbor(this, distance); // if birds within distance
		if (neighbor != null) {
			this.heading = neighbor.heading;
			this.speeds = neighbor.speeds;
		}
		move(speeds);
	}

}