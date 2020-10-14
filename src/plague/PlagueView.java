package plague;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import mvc.*;
import simstation.*;

/**
 * PlagueView extends superclass view. It contains paintComponent() method.
 * 
 * @author xiaoli
 *
 */
public class PlagueView extends View {

	private static final long serialVersionUID = 1L;

	/**
	 * constructor, invoke the constructor in superclass,and create a view with size
	 * 
	 * @param model
	 */
	public PlagueView(Model model) {
		super(model);
		setSize(Simulation.size, Simulation.size);
	}

	/**
	 * create graphic for the host
	 */
	public void paintComponent(Graphics gc) {
		Simulation simulation = (Simulation) model;
		Color oldColor = gc.getColor();
		Iterator<Agent> it = simulation.iterator();
		while (it.hasNext()) {
			Host agent = (Host) it.next();
			gc.setColor(agent.color);
			gc.fillOval(agent.getXc(), agent.getYc(), 5, 5);
		}
		gc.setColor(oldColor);
	}

}