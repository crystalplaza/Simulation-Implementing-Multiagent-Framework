package philosopher;

import simstation.*;

/**
 * Philosopher extends superclass agent. update eating state of each one.
 * 
 * @author xiaoli
 *
 */
class Philosopher extends Agent {

	private ChopStick leftStick, rightStick;
	private Phase phase;
	private int eatCount;

	/**
	 * constructor, invoke the superclass constructor. Initialize the phase and the
	 * count of eating
	 * 
	 * @param name Philosopher's name
	 */
	public Philosopher(String name) {
		super(name);
		phase = Phase.THINKING;
		eatCount = 0;
	}

	/**
	 * overload constructor
	 */
	public Philosopher() {
		this(null);
	}

	/**
	 * getter. Get the phase state
	 * 
	 * @return phase state
	 */
	public synchronized Phase getPhase() {
		return phase;
	}

	/**
	 * set the phase of each philosopher
	 * 
	 * @param phase
	 */
	public synchronized void setPhase(Phase phase) {
		this.phase = phase;
		world.changed();
	}

	/**
	 * get leftstick
	 * 
	 * @return chopstick object
	 */
	public ChopStick getLeftStick() {
		return leftStick;
	}

	/**
	 * setter,set leftstick
	 * 
	 * @param leftStick
	 */
	public void setLeftStick(ChopStick leftStick) {
		this.leftStick = leftStick;
	}

	/**
	 * getter, get right stick
	 * 
	 * @return chopstick object
	 */
	public ChopStick getRightStick() {
		return rightStick;
	}

	/**
	 * setter, set right chopstick
	 * 
	 * @param rightStick
	 */
	public void setRightStick(ChopStick rightStick) {
		this.rightStick = rightStick;
	}

	/**
	 * getter, get the number of count for each philosopher
	 * 
	 * @return integer number
	 */
	public int getEatCount() {
		return eatCount;
	}

	/**
	 * Philosopher is thinking, grab the two sticks and set new phase
	 */
	public void update() {
		if (getPhase().equals(Phase.THINKING)) {
			synchronized (leftStick) {
				synchronized (rightStick) {
					setPhase(Phase.EATING);
					eatCount++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException ie) {
						System.err.println(ie.getMessage());
					}
				}
			}
		}
		setPhase(Phase.THINKING);
	}
}
