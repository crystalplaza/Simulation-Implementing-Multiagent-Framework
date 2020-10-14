package traffic;

import simstation.*;
import mvc.*;
import randomWalk.Drunk;
import randomWalk.RandomWalkFactory;

public class Traffic extends Simulation{

	public Traffic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void populate() {
	    for(int i = 0; i < 50; i++) { 
	    	this.addAgent(new Car()); 
	    }
	 }
     
	public static void main(String[] agrs) {
		SimulationPanel panel = new SimulationPanel(new TrafficFactory());
		panel.display();
	}
}
