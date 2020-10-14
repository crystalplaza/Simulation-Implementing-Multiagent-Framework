/*
 * created by Xiaoli Tong on 4/13
 * revised by Yunlin Xie on 4/14
 * revised by zihui Chen on 4/14
 * revised by Xiaoli Tong on 4/14 add synchronized
 */

package pdt;

import mvc.Utilities;
import simstation.*;
public class Prisoner extends Agent{
	private double score;
	private Strategy strategy;
	private boolean lastResponse;
	private Prisoner owner;
	public int speeds;
	
	public Prisoner(Strategy strategy) {
		super();
		this.strategy = strategy;
		score = 0.0;
		lastResponse = false;
		strategy.setOwner(this);
		speeds = Utilities.rng.nextInt(15)+1;	
	}
	
	public synchronized Strategy getStrategy() {
		return strategy;
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
		strategy.setOwner(owner);
	}
	
	public synchronized boolean getLastResponse() {
		return lastResponse;
	}
	
	public synchronized void setLastResponse(boolean lastResponse) {
		this.lastResponse = lastResponse;
	}
	
	public synchronized double getScore() {
		return score;
	}
	
	public synchronized boolean cooperate() {
		return strategy.cooperate();
	}
	
	public synchronized void updateScore(boolean myCooperate, boolean neighborCooperate) {
		if(myCooperate) {
			if(neighborCooperate) {
				score += 3;
				lastResponse = true;
			}else {
				score += 0;
			}
		}else {
			if(neighborCooperate) {
				score += 5;
				lastResponse = true;
			}else {
				score += 1;
			}
		}
	}
	public  void update() {
		int distance = 15;
		Prisoner neighbor = (Prisoner)world.getNeighbor(this, distance);
		if(neighbor != null) {
			boolean myCooperate = cooperate();
			boolean neighborCooperate = neighbor.cooperate();
			updateScore(myCooperate, neighborCooperate);
			neighbor.updateScore(neighborCooperate, myCooperate);
			heading = Heading.getRandomHeading();
			speeds = Utilities.rng.nextInt(15)+1;
		}
		move(speeds);
	}	
}