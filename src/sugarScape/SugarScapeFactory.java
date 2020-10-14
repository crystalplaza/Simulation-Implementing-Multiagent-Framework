package sugarScape;

import mvc.*;
import plague.PlagueView;
import simstation.*;

public class SugarScapeFactory extends SimulationFactory{
	public Model makeModel() {return new SugarScape();}
	
	public View getView(Model model) {
		return new SugarScapeView(model);
	}

}
