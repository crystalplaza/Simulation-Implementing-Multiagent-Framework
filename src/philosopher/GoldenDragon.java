package philosopher;

import simstation.*;
import mvc.*;

/**
 * GoldenDragon extends superclass. It will add philosophers, and get statistics
 * information. It also include main methods.
 * 
 * @author xiaoli
 *
 */
public class GoldenDragon extends Simulation {
	Philosopher[] philosopher;
	ChopStick[] chopstick;
	public static int NumPhilosophers = 5;
	public static String[] Name = new String[] { "Socrates", "Lao Tzu", "Wittgenstein", "Ramanuja", "Rumi" };

	/**
	 * constructor, it will create philosophers & chopsticks. Each philosopher has a
	 * position
	 */
	public GoldenDragon() {
		chopstick = new ChopStick[NumPhilosophers];
		philosopher = new Philosopher[NumPhilosophers];
		for (int i = 0; i < NumPhilosophers; i++) {
			chopstick[i] = new ChopStick();
		}
		double angle = 2 * Math.PI / NumPhilosophers;
		for (int i = 0; i < NumPhilosophers; i++) {
			philosopher[i] = new Philosopher(Name[i]);
			philosopher[i].setRightStick(chopstick[(i == 0) ? NumPhilosophers - 1 : i - 1]);
			philosopher[i].setLeftStick(chopstick[i]);
			// position in a circle for asthetics:
			double xc = Math.cos(i * angle);
			double yc = Math.sin(i * angle);
			Point p = new Point(xc, yc);
			Point q = p.transform(Simulation.size);

			philosopher[i].setXc((int) q.getXc());
			philosopher[i].setYc((int) q.getYc());
		}
	}

	/**
	 * add philosopher
	 */
	public void populate() {
		for (int i = 0; i < NumPhilosophers; i++) {
			this.addAgent(philosopher[i]);
		}
	}

	/**
	 * get information on clock, the number of philosopher, and how many times each
	 * one eats
	 */
	public String[] getStats() {
		String[] basicStats = super.getStats();
		String[] stats = new String[NumPhilosophers + 2];
		stats[0] = basicStats[0];
		stats[1] = basicStats[1];
		for (int i = 2; i < stats.length; i++) {
			stats[i] = philosopher[i - 2].getName() + ".eatCount = " + philosopher[i - 2].getEatCount();
		}
		return stats;
	}

	/**
	 * main method, create panel for philosopher
	 * 
	 * @param args argument
	 */
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new GoldenDragonFactory());
		panel.display();
	}

}
