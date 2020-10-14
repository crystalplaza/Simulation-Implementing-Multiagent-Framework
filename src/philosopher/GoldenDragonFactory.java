package philosopher;

import simstation.*;
import mvc.*;

class GoldenDragonFactory extends SimulationFactory {
	public Model makeModel() { return new GoldenDragon(); }
	public View getView(Model model) {return new GoldenDragonView(model); }
	public String getTitle() { return "Dining Philosophers"; }
}