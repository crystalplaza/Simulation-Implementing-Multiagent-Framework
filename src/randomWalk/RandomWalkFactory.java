/*
 * created by Xiaoli Tong on 4/9
 * 
 */
package randomWalk;

import mvc.*;
import simstation.*;

public class RandomWalkFactory extends SimulationFactory{
	public Model makeModel() {return new RandomWalk();}

}
