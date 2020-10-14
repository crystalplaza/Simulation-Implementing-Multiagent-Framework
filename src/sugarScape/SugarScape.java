package sugarScape;

import simstation.*;
import mvc.Point;
import mvc.*;
import java.util.*;
import java.awt.*;

public class SugarScape extends Simulation {

	private Set<Point> sugarPods;
	public static int numPods = 100;
	public static int numAnts = 50;

	public SugarScape() {
		super();
		sugarPods = new HashSet<Point>();
		for(int i = 0; i < numPods; i++) {
			int xc = mvc.Utilities.rng.nextInt(size);
			int yc = mvc.Utilities.rng.nextInt(size);
			Point p = new Point(xc, yc);
			sugarPods.add(p);
		}

	}

	// delegators:
	public boolean contains(Point pod) { return sugarPods.contains(pod); }
	public boolean remove(Point pod) { return sugarPods.remove(pod); }
	public Iterator<Point> podIterator() { return sugarPods.iterator(); }
    
	public Set<Point> getSuarPod(){
		return sugarPods;
	}
	public void populate() {
		for(int i = 0; i < numAnts; i++) {
			this.addAgent(new Ant());
		}
	}

	public static void main(String[] args) {
		SimulationPanel panel = new SimulationPanel(new SugarScapeFactory());
		panel.display();
	}
}