package simstation;

import java.awt.*;
import java.util.*;
import mvc.*;

/**
 * SimulationView extends view, paint the canvas
 *
 */
public class SimulationView extends View {

	/**
	 * constructor, invoke superclass constructor, and set canvas size
	 * 
	 * @param model
	 */
	public SimulationView(Model model) {
		super(model);
		setSize(Simulation.size, Simulation.size);
	}

	/**
	 * override paintComponent,add each agent on canvas
	 */
	public void paintComponent(Graphics gc) {
		Simulation simulation = (Simulation) model;
		Color oldColor = gc.getColor();
		Iterator<Agent> it = simulation.iterator();
		while (it.hasNext()) {
			Agent agent = it.next();
			gc.setColor(Color.red);
			gc.fillOval(agent.getXc(), agent.getYc(), 5, 5);
		}
		gc.setColor(oldColor);
	}

}
