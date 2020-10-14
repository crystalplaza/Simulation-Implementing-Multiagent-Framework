
package simstation;

import java.io.*;
import mvc.*;

/**
 * Agent class can stop, start,suspend,resume,finish. We can also check the
 * status by using isstop(), issuspend()methods.
 *
 */
public abstract class Agent implements Runnable, Serializable {
	protected Heading heading;
	protected AgentState state;
	protected String name;
	protected int xc;
	protected int yc;
	protected Simulation world;
	private Thread thread;
	protected int speeds;

	/**
	 * constructor, initialize the heading, position at x axis,y axis, and speed.
	 * 
	 * @param name agent name
	 */
	public Agent(String name) {
		this.name = name;
		state = AgentState.READY;
		thread = null;
		heading = Heading.getRandomHeading();
		this.xc = Utilities.rng.nextInt(Simulation.size);
		this.yc = Utilities.rng.nextInt(Simulation.size);
		this.speeds = Utilities.rng.nextInt(8) + 1;
	}

	/**
	 * overload constructor
	 */
	public Agent() {
		this("agent_" + Utilities.getID());
	}

	/**
	 * Implement this method, the agent will stop
	 */
	public synchronized void stop() {
		state = AgentState.STOPPED;
	}

	/**
	 * check the agent is stop or not
	 * 
	 * @return true if stopped, otherwise return false
	 */
	public synchronized boolean isStopped() {
		return state == AgentState.STOPPED;
	}

	/**
	 * make agent suspend
	 */
	public synchronized void suspend() {
		state = AgentState.SUSPENDED;
	}

	/**
	 * check the agent is suspend or not
	 * 
	 * @return true if agent is suspend, otherwise return false
	 */
	public synchronized boolean isSuspended() {
		return state == AgentState.SUSPENDED;
	}

	/**
	 * resume the previous state
	 */
	public synchronized void resume() {
		state = AgentState.READY;
		notify();
	}

	/**
	 * define 3 states that is the finished state
	 * 
	 * @return if either of three conditions satisfied,return true. Otherwise,
	 *         return false
	 */
	public synchronized boolean finished() {
		return (state == AgentState.STOPPED || thread != null && thread.getState() == Thread.State.TERMINATED);
	}

	/**
	 * start the agent
	 */
	public synchronized void start() {

		state = AgentState.READY;
		if (thread == null) {
			thread = new Thread(this, name);
		}
		thread.start();
	}

	/**
	 * getter, get the name of agent
	 * 
	 * @return agent name
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter, get agent state
	 * 
	 * @return agent current state
	 */
	public synchronized AgentState getState() {
		return state;
	}

	/**
	 * wait for another thread to complete
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void join() throws InterruptedException {
		if (thread != null)
			thread.join();
	}

	/**
	 * run thread
	 */
	public void run() {
		thread = Thread.currentThread();

		while (!finished()) {
			state = AgentState.RUNNNING;
			update();
			try {
				Thread.sleep(100);
				synchronized (this) {
					while (isSuspended()) {
						wait();
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * override methods, update the heading, to make sure agent is within the canvas
	 */
	public abstract void update();

	public synchronized void move(int speeds) {
		switch (heading) {
		case North: {
			yc = (yc - speeds) % Simulation.size;
			if (yc < 0) {
				yc = yc + Simulation.size;
			}
			world.changed();
			break;
		}
		case South: {
			yc = (yc + speeds) % Simulation.size;
			if (yc < 0) {
				yc = yc + Simulation.size;
			}
			world.changed();
			break;
		}
		case West: {
			xc = (xc - speeds) % Simulation.size;
			if (xc < 0) {
				xc = xc + Simulation.size;
			}
			world.changed();
			break;
		}
		case East: {
			xc = (xc + speeds) % Simulation.size;
			if (xc < 0) {
				xc = xc + Simulation.size;
			}
			world.changed();
			break;
		}
		}
	}

	/**
	 * getter, get the x axis
	 * 
	 * @return the x axis position
	 */
	public synchronized int getXc() {
		return xc;
	}

	/**
	 * get the y axis
	 * 
	 * @return the y axis position
	 */
	public synchronized int getYc() {
		return yc;
	}

	/**
	 * setter, set the x axis position
	 * 
	 * @param xc xc position
	 */
	public synchronized void setXc(int xc) {
		this.xc = xc;
	}

	/**
	 * setter, set the y axis position
	 * 
	 * @param yc the y axis position
	 */
	public synchronized void setYc(int yc) {
		this.yc = yc;
	}

	/**
	 * get the canvas
	 * 
	 * @return world object
	 */
	public Simulation getWorld() {
		return world;
	}

	/**
	 * setter, set the world
	 * 
	 * @param world
	 */
	public void setWorld(Simulation world) {
		this.world = world;

	}

	/**
	 * getter, get random heading by random generator
	 * 
	 * @return a random heading
	 */
	public synchronized Heading getHeading() {
		return Heading.getRandomHeading();
	}

	/**
	 * get the speed of agents
	 * 
	 * @return current agent speed
	 */
	public synchronized int getSpeed() {
		return speeds;
	}

}
