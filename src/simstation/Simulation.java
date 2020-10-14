

package simstation;

import java.util.*;
import mvc.*;

public class Simulation extends Model {
    
	public static int size = 250;
	private Timer timer;
	private int clock;
	protected ArrayList<Agent> agents;
    
	public Simulation() {
		agents = new ArrayList<Agent>();
		clock = 0;	
	}
	
	public synchronized void start() {
		agents = new ArrayList<Agent>();
		clock = 0;
		populate();
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
		for (Agent a : agents) {
			a.start();
		}

//		for(int i=0; i< agents.size(); i++){
//			agents.get(i).start();
//		}
	}
	
	public synchronized void suspend() {
		for (Agent a : agents) {
			a.suspend();
		}
		stopTimer();
		//timer.cancel();
		//timer.purge();
//		for(int i=0; i< agents.size(); i++){
//			agents.get(i).suspend();
//		}
	}
	
	public synchronized void stop() {
		for(int i=0; i< agents.size(); i++){
			agents.get(i).stop();	
		}	
		stopTimer();
	}
	     
	public synchronized void resume() {
		//timer = new Timer();
		//timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
		startTimer();
		for(int i=0; i< agents.size(); i++){
		agents.get(i).resume();
	    }
	}
	
	public synchronized String[] getStats() {
		String[] massages = new String[2];
		massages[0] = "#agent = " +Integer.toString(getAgentSize());
		massages[1] = "clock = " + Integer.toString(getClock());
		return  massages;
	}
	
	
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
	
	public void addAgent(Agent a) {
		agents.add(a);
		a.setWorld(this);
	}
	public  void populate(){};
	
	public synchronized int computeDistance(Agent agent1, Agent agent2) {
		
		return (int) Math.sqrt(Math.pow(agent1.getXc() - agent2.getXc(), 2)
				+Math.pow(agent1.getYc() - agent2.getYc(), 2));	
	}
	
	private synchronized void startTimer() {
	   timer = new Timer();
       timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
	  timer.cancel();
	  timer.purge();
  }

   private class ClockUpdater extends TimerTask {
	  public void run() {
		  clock++;
		  //changed();
      }
  }
   
   public synchronized int getClock() {
	   return clock;
   }
   
   public int getAgentSize() {
	   return agents.size();
   }

   public Iterator<Agent> iterator() {
	   	return agents.iterator();
   }  
}