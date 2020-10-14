package pdt;

import java.util.*;
import mvc.*;

/**
 * The class create a random cooperate strategy. The prisoner randomly choose
 * the strategy.
 *
 */
public class RandomCooperate extends Strategy {
	/**
	 * constructor, invoke superclass constructor
	 */
	public RandomCooperate() {
		super();
	}

	/**
	 * randomly choose strategy using random generator
	 */
	public boolean cooperate() {
		if (Utilities.rng.nextBoolean()) {
			return true;
		}
		return false;
	}
}
