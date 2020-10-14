package sugarScape;

import mvc.*;
import plague.PlagueView;
import simstation.*;

/**
 * SugarScapeFactory extends superclass, override methods in superclass
 *
 */
public class SugarScapeFactory extends SimulationFactory {
	/**
	 * constructor, override superclass constructor
	 */
	public Model makeModel() {
		return new SugarScape();
	}

	/**
	 * override method
	 */
	public View getView(Model model) {
		return new SugarScapeView(model);
	}

}
