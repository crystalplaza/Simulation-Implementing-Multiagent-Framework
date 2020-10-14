/*
 * created by Xiaoli Tong on 4/14
 * revised by Xiaoli Tong on 4/14
 */
package pdt;

import java.util.*;
import mvc.*;

public class RandomCooperate extends Strategy{

	public RandomCooperate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean cooperate() {
		if(Utilities.rng.nextBoolean()) {
			return true;
		}
		return false;
	}
}
