
package simstation;

import java.util.*;

import mvc.Utilities;

public enum Heading {
	North, South, East, West;
	
	public static Heading getRandomHeading() {
        //Random random = new Random();
        //return values()[random.nextInt(values().length)];
		return values()[Utilities.rng.nextInt(values().length)];
    }
}
