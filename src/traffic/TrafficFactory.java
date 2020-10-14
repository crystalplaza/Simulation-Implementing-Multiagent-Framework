package traffic;

import mvc.*;
import simstation.*;

public class TrafficFactory extends SimulationFactory{
	public Model makeModel() {return new Traffic();}

}
