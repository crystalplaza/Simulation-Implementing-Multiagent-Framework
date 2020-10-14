package traffic;

import mvc.Utilities;
import randomWalk.Drunk;
import simstation.*;

/**
 * car extends agent. Car update its heading same with its' neighbor's.
 */
public class Car extends Agent {
	private int speed;

	/**
	 * constructor, invoke superclass constructor. Initialize speed.
	 */
	public Car() {
		super();
		speed = 1;
	}

	/**
	 * Change car's heading to neighbor's heading, if within specific distance with
	 * neighbor
	 */
	public void update() {
		int distance = 2;
		Car neighbor = (Car) world.getNeighbor(this, distance);
		if (neighbor != null) {
			Heading neighborHeading = neighbor.getHeading();
			if (neighborHeading.equals(Heading.East)) {
				heading = Heading.West;
			} else if (neighborHeading.equals(Heading.West)) {
				heading = Heading.East;
			} else if (neighborHeading.equals(Heading.North)) {
				heading = Heading.South;
			} else {
				heading = Heading.North;
			}
		}
		move(speeds);
	}

	/**
	 * get car's speed
	 */
	public synchronized int getSpeed() {
		return speed;
	}
}
