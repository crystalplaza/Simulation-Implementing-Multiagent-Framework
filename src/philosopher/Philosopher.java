package philosopher;

import simstation.*;

class Philosopher extends Agent {

	private ChopStick leftStick, rightStick;
	private Phase phase;
	private int eatCount;

	public Philosopher(String name) {
		super(name);
		phase = Phase.THINKING;
		eatCount = 0;
	}
	public Philosopher() { this(null); }
	public synchronized Phase getPhase() { return phase; }
	public synchronized void setPhase(Phase phase) {
		this.phase = phase;
		world.changed();
	}
	public ChopStick getLeftStick() { return leftStick; }
	public void setLeftStick(ChopStick leftStick) {
		this.leftStick = leftStick;
	}
	public ChopStick getRightStick() { return rightStick; }
	public void setRightStick(ChopStick rightStick) {
		this.rightStick = rightStick;
	}
	public int getEatCount() { return eatCount; }

	public void update() {
		if (getPhase().equals(Phase.THINKING)) {
			synchronized(leftStick) {
				synchronized(rightStick) {
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


