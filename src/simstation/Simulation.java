
package simstation;

import java.util.*;
import mvc.*;

/**
 * Simulation class have operations, such as start, stop, suspend,resume. The
 * neighbor can be obtained. The distance can be computed between neighbor and
 * agent. It generates Statistic information.
 * 
 * @author xiaoli
 *
 */
public class Simulation extends Model {

	public static int size = 250;
	private Timer timer;
	private int clock;
	protected ArrayList<Agent> agents;

	/**
	 * constructor, initialize agent and clock.
	 */
	public Simulation() {
		agents = new ArrayList<Agent>();
		clock = 0;
	}

	/**
	 * start the agent, and start clock.
	 */
	public synchronized void start() {
		agents = new ArrayList<Agent>();
		clock = 0;
		populate();
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
		for (Agent a : agents) {
			a.start();
		}
	}

	/**
	 * suspend angent
	 */
	public synchronized void suspend() {
		for (Agent a : agents) {
			a.suspend();
		}
		stopTimer();
	}

	/**
	 * stop all of the agent
	 */
	public synchronized void stop() {
		for (int i = 0; i < agents.size(); i++) {
			agents.get(i).stop();
		}
		stopTimer();
	}

	/**
	 * resume all agents to previous running state, and start the timer
	 */
	public synchronized void resume() {
		startTimer();
		for (int i = 0; i < agents.size(); i++) {
			agents.get(i).resume();
		}
	}

	/**
	 * get the number of agents, time agents have run
	 * 
	 * @return string list with integer and time
	 */
	public synchronized String[] getStats() {
		String[] massages = new String[2];
		massages[0] = "#agent = " + Integer.toString(getAgentSize());
		massages[1] = "clock = " + Integer.toString(getClock());
		return massages;
	}

	/**
	 * get a neighbor within a specific distance
	 * 
	 * @param agent    a agent
	 * @param distance
	 * @return
	 */
	public synchronized Agent getNeighbor(Agent agent, int distance) {
		boolean found = false;
		Agent neighbor = null;
		int i = Utilities.rng.nextInt(agents.size());
		int start = i;

		while (!found) {
			Agent candidate = agents.get(i);

			int candidateDistance = computeDistance(agent, candidate);
			if (candidate != agent && candidateDistance < distance) {
				neighbor = agents.get(i);
				found = true;
			} else {
				i = (i + 1) % agents.size();
				if (i == start) {
					break;
				}
			}
		}
		return neighbor;
	}

	/**
	 * add agent to agents list, and also send notification
	 * 
	 * @param a agent
	 */
	public void addAgent(Agent a) {
		agents.add(a);
		a.setWorld(this);
	}

	/**
	 * populate() method to be override
	 */
	public void populate() {
	};

	/**
	 * compute the distance between two agents
	 * 
	 * @param agent1 first agent
	 * @param agent2 second agent
	 * @return distance
	 */
	public synchronized int computeDistance(Agent agent1, Agent agent2) {

		return (int) Math
				.sqrt(Math.pow(agent1.getXc() - agent2.getXc(), 2) + Math.pow(agent1.getYc() - agent2.getYc(), 2));
	}

	/**
	 * start timer
	 */
	private synchronized void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}

	/**
	 * stop timer
	 */
	private void stopTimer() {
		timer.cancel();
		timer.purge();
	}

	// private class
	private class ClockUpdater extends TimerTask {
		public void run() {
			clock++;
		}
	}

	/**
	 * get the running time
	 * 
	 * @return integer
	 */
	public synchronized int getClock() {
		return clock;
	}

	/**
	 * get the number of agents
	 * 
	 * @return size of agents
	 */
	public int getAgentSize() {
		return agents.size();
	}

	/**
	 * iterate through agents
	 * 
	 * @return iterator
	 */
	public Iterator<Agent> iterator() {
		return agents.iterator();
	}
}