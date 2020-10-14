package philosopher;

import mvc.*;
import java.awt.*;
import javax.swing.*;
import simstation.*;
import java.util.*;

/**
 * GoldenDragonView extends superclass View. Paint Philosopher on the panel
 * 
 * @author xiaoli
 *
 */
class GoldenDragonView extends View {
	/**
	 * constructor, invoke superclass constructor
	 * 
	 * @param model model it will take
	 */
	public GoldenDragonView(Model model) {
		super(model);
	}

	/**
	 * paintComponent() is an override method, it will add each philosopher to the
	 * panel, and color the philosopher according to the eating state
	 */
	public void paintComponent(Graphics gc) {
		Color oldColor = gc.getColor();
		GoldenDragon sim = (GoldenDragon) model;
		Iterator<Agent> it = sim.iterator();
		while (it.hasNext()) {
			Agent a = it.next();
			if (((Philosopher) a).getPhase().equals(Phase.EATING))
				gc.setColor(Color.RED);
			else
				gc.setColor(Color.green);
			gc.fillOval(a.getXc(), a.getYc(), 8, 8);
		}
		gc.setColor(oldColor);
	}
}