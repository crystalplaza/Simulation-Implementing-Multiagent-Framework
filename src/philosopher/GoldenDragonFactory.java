package philosopher;

import simstation.*;
import mvc.*;

/**
 * GoldenDragonFactory extends superclass SimulationFactory, override three
 * methods in superclass
 * 
 * @author xiaoli
 *
 */
class GoldenDragonFactory extends SimulationFactory {
	/**
	 * override makeModel method, create a new model
	 */
	public Model makeModel() {
		return new GoldenDragon();
	}

	/**
	 * override getView method, create a new view
	 */
	public View getView(Model model) {
		return new GoldenDragonView(model);
	}

	/**
	 * override getTitle() methods, generate new title
	 */
	public String getTitle() {
		return "Dining Philosophers";
	}
}