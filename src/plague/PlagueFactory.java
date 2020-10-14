/*
 /*
 * Edit history: 
 * Yunlin, 4/12: created
 * Yunlin, 4/13: added method
 */


package plague;


import mvc.*;
import simstation.*;


public class PlagueFactory extends SimulationFactory {

	public Model makeModel() {return new Plague();}
	
	public View getView(Model model) {
		return new PlagueView(model);
	}
	
	
}
