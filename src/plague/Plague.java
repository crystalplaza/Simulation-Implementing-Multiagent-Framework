package plague;

import simstation.*;
import java.awt.Color;
import java.text.*;
import java.util.*;

/**
 * plague class extends superclass Simulation. It contains populate(),
 * getInfected(),getStats(), and main() method.
 * 
 * @author xiaoli
 *
 */
public class Plague extends Simulation {

	private static final long serialVersionUID = 1L;
	public static int RESISTANCE = 80; // % chance of resisting infection

	int total = 50;
	public int initInfected = 1;

	/**
	 * constructor, it invokes constructor in super class
	 */
	public Plague() {
		super();
	}

	/**
	 * populate create some infected hosts, and non-infected hosts.Red for infected
	 * host, green for non-infected host
	 */
	public void populate() {
		for (int i = 0; i < initInfected; i++) {
			this.addAgent(new Host(Color.RED));
		}
		for (int i = initInfected; i < total; i++) {
			this.addAgent(new Host(Color.GREEN));
		}
	}

	/**
	 * iterate the host, get the number of host who got infected
	 * 
	 * @return the percentage of hosts who got infected
	 */
	public synchronized String getInfected() {
		double count = 0.0;
		double res;

		Iterator<Agent> it = iterator();
		while (it.hasNext()) {
			Host agent = (Host) it.next();
			if (agent.color.equals(Color.RED)) {
				count += 1;
			}
		}
		res = (count / 50.0) * 100;
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(res);
	}

	/**
	 * get statitical information for the host, the number of agents, how long it
	 * takes, and how many host got infected
	 */
	public String[] getStats() {
		String[] message = new String[3];
		message[0] = "#agent = " + Integer.toString(total);
		message[1] = "clock = " + Integer.toString(this.getClock());
		message[2] = "%infected = " + getInfected();
		return message;
	}

	/**
	 * main method, create panel
	 * 
	 * @param agrs arguments
	 */
	public static void main(String[] agrs) {
		SimulationPanel panel = new SimulationPanel(new PlagueFactory());
		panel.display();
	}
}
