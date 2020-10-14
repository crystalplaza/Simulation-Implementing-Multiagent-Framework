/*
 * creaed by Xiaoli Tong on 4/14
 */

package pdt;

import mvc.*;
import simstation.*;

public class pdtFactory extends SimulationFactory{
	public Model makeModel() {return new PDTournament();}

}