package plague;

import mvc.*;
import simstation.*;

/***
 * PlagueFactory extends superclass SimulationFactory. It contains MakeModel(),
 * and getView() to create a model and get plagueview
 * 
 * @author xiaoli
 *
 */
public class PlagueFactory extends SimulationFactory {

	/**
	 * override method, override makeModel() from superclass
	 */
	public Model makeModel() {
		return new Plague();
	}

	/**
	 * override method, override gerView() from superclass
	 * 
	 * @return return plague view
	 */
	public View getView(Model model) {
		return new PlagueView(model);
	}

}
