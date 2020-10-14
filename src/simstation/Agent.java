
package simstation;

import java.io.*;
import mvc.*;

public abstract class Agent implements Runnable,Serializable {
	protected Heading heading;
	protected AgentState state;
	protected String name;
	protected int xc;
	protected int yc;
	protected Simulation world;
	private Thread thread;
	protected int speeds;
	
	public Agent(String name) {
		this.name = name;
		state = AgentState.READY;
		thread = null;
		heading = Heading.getRandomHeading();
		this.xc = Utilities.rng.nextInt(Simulation.size);
		this.yc = Utilities.rng.nextInt(Simulation.size);
		this.speeds = Utilities.rng.nextInt(8)+1;
	}
	
	public Agent() {
		this("agent_" + Utilities.getID());
	}
	
	public synchronized void stop() { 
		state = AgentState.STOPPED; 
	}
	
	public synchronized boolean isStopped() { 
		return state == AgentState.STOPPED; 
	}
	
	public synchronized void suspend() { 
		state = AgentState.SUSPENDED;
	}
	
	public synchronized boolean isSuspended() { 
		return state == AgentState.SUSPENDED;  
	}


	public synchronized void resume() {
		state = AgentState.READY;
		notify();
	}
	public synchronized boolean finished() {
		return (state == AgentState.STOPPED 
				|| thread != null && thread.getState()==Thread.State.TERMINATED);
	}
	
	public synchronized void start() {

		state = AgentState.READY;
		if (thread == null) {
			thread = new Thread(this, name);
		}
		thread.start();
	}
	
	public String getName() { 
		return name; 
	}
	
	public synchronized AgentState getState() { 
		return state; 
	}
	
	public synchronized void join() throws InterruptedException {
		if (thread != null) thread.join();
	}
		
	public void run() {
		thread = Thread.currentThread(); 
		//while(!isStopped()) {
		while(!finished()) {
			state = AgentState.RUNNNING;
			update();
			try {
				Thread.sleep(100); 
				synchronized(this) {
					while(isSuspended()) { wait(); }
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	// for override
	public abstract void update();

	public synchronized void move(int speeds) {
		switch(heading) {
		case North:{
			yc = (yc- speeds) % Simulation.size;
			if(yc < 0) {
				yc = yc + Simulation.size;
			}
			world.changed();
			break;
		}
		case South:{
			yc = (yc+ speeds) % Simulation.size;
			if(yc < 0) {
				yc = yc + Simulation.size;
			}
			world.changed();
			break;
		}
		case West:{
			xc = (xc - speeds) % Simulation.size;
			if(xc < 0) {
				xc = xc + Simulation.size;
			}
			world.changed();
			break;
		}
		case East:{
			xc = (xc + speeds) % Simulation.size;
			if(xc < 0) {
				xc = xc + Simulation.size;
			}
			world.changed();
			break;
		}
	}
   }
   
	public synchronized int getXc() {
		return xc;
	}
	
	public synchronized int getYc() {
		return yc;
	}
	
	public synchronized void setXc(int xc) {
		this.xc = xc;
	}
	
	public synchronized void setYc(int yc) {
		this.yc = yc;
	}

	public Simulation getWorld() {
		return world;
	}
	
	public void setWorld(Simulation world) {
		this.world = world;
		
	}
	public synchronized Heading getHeading() {
		return Heading.getRandomHeading();
	}
	
	public synchronized int getSpeed() {
		return speeds;
	}
	
}



