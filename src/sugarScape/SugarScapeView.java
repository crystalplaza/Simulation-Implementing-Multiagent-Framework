package sugarScape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import mvc.*;
import plague.Host;
import simstation.*;

public class SugarScapeView extends View{
	private static final long serialVersionUID = 1L;

	public SugarScapeView(Model model) {
		super(model);
		setSize(Simulation.size, Simulation.size);
	}
	

	public void paintComponent(Graphics gc) {
		SugarScape sugarScape = (SugarScape) model;
		Color oldColor = gc.getColor();
		Iterator<Agent> it = sugarScape.iterator();
		gc.setColor(Color.red);
		while(it.hasNext()) {
			Ant agent = (Ant) it.next();
			gc.fillOval(agent.getXc(), agent.getYc(), agent.getSize(), agent.getSize());
		}
		
		gc.setColor(Color.black);
        Iterator<Point> it2 = sugarScape.podIterator();
		while(it2.hasNext()) {
			Point point = it2.next();
			gc.fillOval((int)point.getXc(),  (int)point.getYc(), 5, 5);
	}
	gc.setColor(oldColor);
}
		
	

}
