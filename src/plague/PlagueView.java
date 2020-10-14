
package plague;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import mvc.*;
import simstation.*;


public class PlagueView extends View{

	
	private static final long serialVersionUID = 1L;

	public PlagueView(Model model) {
		super(model);
		setSize(Simulation.size, Simulation.size);
	}
	

	public void paintComponent(Graphics gc) {
		Simulation simulation = (Simulation) model;
		Color oldColor = gc.getColor();
		Iterator<Agent> it = simulation.iterator();
		while(it.hasNext()) {
			Host agent = (Host) it.next();
			gc.setColor(agent.color);
			gc.fillOval(agent.getXc(), agent.getYc(), 5, 5);
		}
		gc.setColor(oldColor);
	}

		
	
}