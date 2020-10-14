
package plague;

import simstation.*;
import java.awt.Color;
import java.text.*;
import java.util.*;

public class Plague extends Simulation {
	
	private static final long serialVersionUID = 1L;
	public static int RESISTANCE = 80; // % chance of resisting infection
	
	int total = 50;
	public int initInfected = 1;	
	
	public Plague() {
		super();
	}
	
	public void populate() {
	    for(int i = 0; i < initInfected; i++) { 
	    	this.addAgent(new Host(Color.RED)); 
	    }
	    for(int i = initInfected; i < total; i++) { 
	    	this.addAgent(new Host(Color.GREEN)); 
	    }
	 }
	
	public synchronized String getInfected() {
		double count = 0.0;
		double res;

		Iterator<Agent> it = iterator();
		while(it.hasNext()) {
			Host agent = (Host) it.next();
			if(agent.color.equals(Color.RED)) {
				count += 1;
			}
		}
		res = (count / 50.0)*100;
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(res);
	}
	
	public String[] getStats() {
		String[] message = new String[3];
		message[0] = "#agent = " + Integer.toString(total);
		message[1] = "clock = " + Integer.toString(this.getClock());
		message[2] = "%infected = " + getInfected();
		return message;
	}
	    
	public static void main(String[] agrs) {
		SimulationPanel panel = new SimulationPanel(new PlagueFactory());
		panel.display();
	}
}
