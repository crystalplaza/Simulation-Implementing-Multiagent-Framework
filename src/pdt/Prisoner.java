package pdt;

import mvc.Utilities;
import simstation.*;

/**
 * prisoner class create prisoner object. Each prisoner has score, strategy.
 * prisoner can update the scores.
 *
 */

public class Prisoner extends Agent {
	private double score;
	private Strategy strategy;
	private boolean lastResponse;
	private Prisoner owner;
	public int speeds;

	/**
	 * constructor, invoke superclass constructor, and initialze strategy, score,
	 * and lastResponse.
	 * 
	 * @param strategy
	 */
	public Prisoner(Strategy strategy) {
		super();
		this.strategy = strategy;
		score = 0.0;
		lastResponse = false;
		strategy.setOwner(this);
		speeds = Utilities.rng.nextInt(15) + 1;
	}

	/**
	 * getter, get the strategy from the prisoner
	 * 
	 * @return strategy
	 */
	public synchronized Strategy getStrategy() {
		return strategy;
	}

	/**
	 * setter strategy
	 * 
	 * @param strategy
	 */
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
		strategy.setOwner(owner);
	}

	/**
	 * get prisoner's last response. Last response is a boolean variable
	 * 
	 * @return true is last reponse if ture, otherwise, false
	 */
	public synchronized boolean getLastResponse() {
		return lastResponse;
	}

	/**
	 * setter, set the last response new status
	 * 
	 * @param lastResponse
	 */
	public synchronized void setLastResponse(boolean lastResponse) {
		this.lastResponse = lastResponse;
	}

	/**
	 * get the prisoner's total score
	 * 
	 * @return score
	 */
	public synchronized double getScore() {
		return score;
	}

	/**
	 * check if the strategy is cooperate
	 * 
	 * @return true if cooperate, otherwise, false
	 */
	public synchronized boolean cooperate() {
		return strategy.cooperate();
	}

	/**
	 * update the score, the score depends on prisioner's strategy and also the
	 * opponent's strategy.
	 * 
	 * @param myCooperate       prisoner cooperate status
	 * @param neighborCooperate opponent cooperate status
	 */
	public synchronized void updateScore(boolean myCooperate, boolean neighborCooperate) {
		if (myCooperate) {
			if (neighborCooperate) {
				score += 3;
				lastResponse = true;
			} else {
				score += 0;
			}
		} else {
			if (neighborCooperate) {
				score += 5;
				lastResponse = true;
			} else {
				score += 1;
			}
		}
	}

	/**
	 * override update method from superclass. Update scores of prisoner and also
	 * opponents
	 */
	public void update() {
		int distance = 15;
		Prisoner neighbor = (Prisoner) world.getNeighbor(this, distance);
		if (neighbor != null) {
			boolean myCooperate = cooperate();
			boolean neighborCooperate = neighbor.cooperate();
			updateScore(myCooperate, neighborCooperate);
			neighbor.updateScore(neighborCooperate, myCooperate);
			heading = Heading.getRandomHeading();
			speeds = Utilities.rng.nextInt(15) + 1;
		}
		move(speeds);
	}
}