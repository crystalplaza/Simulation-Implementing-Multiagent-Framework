package philosopher;

import mvc.*;
import java.awt.*;
import javax.swing.*;
import simstation.*;
import java.util.*;

class GoldenDragonView extends View {
	public GoldenDragonView(Model model) { super(model); }
	
	public void paintComponent(Graphics gc) {
		Color oldColor = gc.getColor();
		GoldenDragon sim = (GoldenDragon)model;
		Iterator<Agent> it = sim.iterator();
		while(it.hasNext()) {
			Agent a = it.next();
			if (((Philosopher)a).getPhase().equals(Phase.EATING))
				gc.setColor(Color.RED);
			else
				gc.setColor(Color.green);
			gc.fillOval(a.getXc(), a.getYc(), 8, 8);
		}
		gc.setColor(oldColor);
	}
}