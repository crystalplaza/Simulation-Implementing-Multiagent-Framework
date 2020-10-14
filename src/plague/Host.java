/*
 * Edit history: 
 * Yunlin, 4/12: created
 * Yunlin, 4/13: updated method and added probability
 * Yunlin, 4/14: updated method
 * Yunlin, 4/15: updated method
 * Xiaoli, 4/15: updated method
 */


package plague;

import java.awt.Color;
import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;


public class Host extends Agent {

	
	private static final long serialVersionUID = 1L;
	
	public Color color;
	public int speeds;
	
	public Host(Color c) {
		super();
		super.heading = Heading.getRandomHeading();
		speeds = Utilities.rng.nextInt(10 + 1) + 1;
		color = c;
	}
		
	public void update() { 
		int distance = 10;
		Host neighbor = (Host) world.getNeighbor(this, distance);
		if(neighbor != null && this.color == Color.green && neighbor.color.equals(Color.RED)) {
			if(Utilities.rng.nextInt(100) >= Plague.RESISTANCE) {
				color = Color.RED;
		     }
        }
		heading = Heading.getRandomHeading();
		speeds = Utilities.rng.nextInt(10 + 1) + 1;
		move(speeds);
	}
}
