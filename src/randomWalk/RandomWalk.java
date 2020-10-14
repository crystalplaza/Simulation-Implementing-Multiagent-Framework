/*
 * created by Xiaoli Tong on 4/9
 * revised by Xiaoli Tong on 4/13
 */

package randomWalk;

import simstation.*;

public class RandomWalk extends Simulation {

	public RandomWalk() {
		super();
	}
	
	public void populate() {
	    for(int i = 0; i < 50; i++) { 
	    	this.addAgent(new Drunk()); 
	    }
	 }
     
	public static void main(String[] agrs) {
		SimulationPanel panel = new SimulationPanel(new RandomWalkFactory());
		panel.display();
	}
}
