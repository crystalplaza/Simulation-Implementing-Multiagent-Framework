/*
 * created by Xiaoli Tong on 4/9
 * revised by Xiaoli Tong on 4/13
 * revised by Xiaoli Tong on 4/15
 */

package randomWalk;

import simstation.*;
import mvc.*;
public class Drunk extends Agent{

   private int speeds;
   
	public Drunk() {
		super();
		//speeds = Utilities.rng.nextInt(8);	
	}
	
	public  void update() {
		int distance = 25;
		Drunk neighbor = (Drunk) world.getNeighbor(this, distance);
		if(neighbor != null) {
			heading = Heading.getRandomHeading();
			speeds = Utilities.rng.nextInt(8)+1;
		}
		 move(speeds);
	}
    
}
