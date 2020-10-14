package sugarScape;

import java.awt.Color;
import mvc.*;
import simstation.*;

/**
 * ant extends agent. An ant can eat sugarcape, then ant becomes bigger,
 * increase speed, and increase fitness.
 * 
 * @author xiaoli
 *
 */
public class Ant extends Agent {

	private static final long serialVersionUID = 1L;
	private int speeds;
	private int fitness;
	int size;

	/**
	 * constructor, invoke the superclass constructor. Initialize fitness, and
	 * speeds and size.
	 */
	public Ant() {
		super();
		fitness = 1;
		heading = Heading.getRandomHeading();
		speeds = Utilities.rng.nextInt(5) + 1;
		size = 1;
	}

	/**
	 * overload constructor
	 * 
	 * @param name ant name
	 */
	public Ant(String name) {
		super(name);
	}

	/**
	 * override update() method. remove the point, increase speed, size and fitness.
	 * change to random heading
	 */
	public void update() {
		SugarScape sim = (SugarScape) world;
		Point antPoint = new Point(this.xc, this.yc);
		if (sim.contains(antPoint)) {
			sim.remove(antPoint);
			speeds = speeds + 1;
			size = size + 1;
			fitness = fitness + 1;
		}
		this.heading = Heading.getRandomHeading();
		move(speeds);
	}

	/**
	 * getter, get the size of ant
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * setter, set size of ant
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
