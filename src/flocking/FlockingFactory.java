/*
 * created by Zihui Chen on 4/14
 */

package flocking;

import mvc.*;
import simstation.*;


public class FlockingFactory extends SimulationFactory {
    public Model makeModel() {return new Flocking();}
}