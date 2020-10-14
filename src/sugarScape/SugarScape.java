package sugarScape;

import simstation.*;
import mvc.Point;
import mvc.*;
import java.util.*;
import java.awt.*;

/**
 * sugarCape holds ants and pods. After ant eats sugar pods, pods will be
 * removed.
 * 
 * @author xiaoli
 *
 */
public class SugarScape extends Simulation {

	private Set<Point> sugarPods;
	public static int numPods = 100;
	public static int numAnts = 50;

	/**
	 * constructor, invoke superclass constructor.Add pods to sugarScape.
	 */
	public SugarScape() {
		super();
		sugarPods = new HashSet<Point>();
		for (int i = 0; i < numPods; i++) {
			int xc = mvc.Utilities.rng.nextInt(size);
			int yc = mvc.Utilities.rng.nextInt(size);
			Point p = new Point(xc, yc);
			sugarPods.add(p);
		}

	}

	/**
	 * check if the sugarscape contains sugar pod.
	 * 
	 * @param pod sugar pod
	 * @return true if has sugar pod, otherwise, return false
	 */
	public boolean contains(Point pod) {
		return sugarPods.contains(pod);
	}

	/**
	 * remove sugar pod from sugarscape
	 * 
	 * @param pod sugar pod
	 * @return true if remove successful, otherwise, return false
	 */
	public boolean remove(Point pod) {
		return sugarPods.remove(pod);
	}

	/**
	 * iterate pods
	 * 
	 * @return iterator of pods
	 */
	public Iterator<Point> podIterator() {
		return sugarPods.iterator();
	}

	/**
	 * getter, get sugarpod
	 * 
	 * @return point of pod
	 */
	public Set<Point> getSuarPod() {
		return sugarPods;
	}

	/**
	 * add ants to simulation
	 */
	public void populate() {
		for (int i = 0; i < numAnts; i++) {
			this.addAgent(new Ant());
		}
	}

	/**
	 * main method, display panel
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		SimulationPanel panel = new SimulationPanel(new SugarScapeFactory());
		panel.display();
	}
}