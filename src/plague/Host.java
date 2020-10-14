package plague;

import java.awt.Color;
import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

/**
 * Host extends Agent.If host has virus, it will show red. It contains update()
 * method, which is update the speed of the host,heading of the host, and color
 * of the host.
 * 
 * @author xiaoli
 *
 */
public class Host extends Agent {

	private static final long serialVersionUID = 1L;

	public Color color;
	public int speeds;

	/**
	 * construtor, each host invoke constructor in superclass. Each host has a
	 * heading and speed, and color
	 * 
	 * @param c the color of host will be assigned
	 */
	public Host(Color c) {
		super();
		super.heading = Heading.getRandomHeading();
		speeds = Utilities.rng.nextInt(10 + 1) + 1;
		color = c;
	}

	/**
	 * update() method will update the host color, if the neighbor got infected and
	 * greater than some resistance rate. The host will also randomly update its
	 * heading and speed.
	 */
	public void update() {
		int distance = 10;
		Host neighbor = (Host) world.getNeighbor(this, distance);
		if (neighbor != null && this.color == Color.green && neighbor.color.equals(Color.RED)) {
			if (Utilities.rng.nextInt(100) >= Plague.RESISTANCE) {
				color = Color.RED;
			}
		}
		heading = Heading.getRandomHeading();
		speeds = Utilities.rng.nextInt(10 + 1) + 1;
		move(speeds);
	}
}
