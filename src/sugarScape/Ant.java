package sugarScape;

import java.awt.Color;
import mvc.*;
import simstation.*;



public class Ant extends Agent {

	private static final long serialVersionUID = 1L;
	private int speeds;
	private int fitness;
	//public Color color;
	int size;

	public Ant() {
		super();
		// TODO Auto-generated constructor stub
		fitness = 1;
		heading = Heading.getRandomHeading();
		speeds = Utilities.rng.nextInt(5) + 1;
		size = 1;
	}

	public Ant(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
			SugarScape sim = (SugarScape)world; 
			Point antPoint = new Point(this.xc,this.yc);
            if(sim.contains(antPoint)) {
            	sim.remove(antPoint);
            	speeds = speeds + 1;
        		size = size+1;
        		fitness = fitness+1;
            }
            this.heading = Heading.getRandomHeading();
    		move(speeds);
	}
    
	public int getSize() {
		return size;
	}
    
	public void setSize(int size) {
		this.size = size; 
	}
}
