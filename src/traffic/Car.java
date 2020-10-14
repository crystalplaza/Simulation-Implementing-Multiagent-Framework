package traffic;

import mvc.Utilities;
import randomWalk.Drunk;
import simstation.*;

public class Car extends Agent{
	private int speed;
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
		speed = 1;
	}

	public void update() {
		int distance = 2;
		Car neighbor = (Car) world.getNeighbor(this, distance);
		if(neighbor != null) {
		    Heading neighborHeading = neighbor.getHeading();
			if(neighborHeading.equals(Heading.East)) {
				heading = Heading.West;
			}else if(neighborHeading.equals(Heading.West)){
				heading = Heading.East;
			}else if(neighborHeading.equals(Heading.North)){
				heading = Heading.South;
			}else {
				heading = Heading.North;
			}
		}
		 move(speeds);
	}
	public synchronized int getSpeed() { return speed; }
}
