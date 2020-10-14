
package simstation;

import java.util.*;

import mvc.Utilities;

/**
 * Enumation, there are four heading. A random heading can be obtained using
 * getRandomHeading() method.
 */
public enum Heading {
	North, South, East, West;

	/**
	 * generate random heading using random generator
	 * 
	 * @return heading
	 */
	public static Heading getRandomHeading() {
		return values()[Utilities.rng.nextInt(values().length)];
	}
}
