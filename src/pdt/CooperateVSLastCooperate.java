/*
 * created by Xiaoli Tong on 4/14
 */

package pdt;

import simstation.*;
public class CooperateVSLastCooperate extends Strategy{

	public CooperateVSLastCooperate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean cooperate() {
		return owner.getLastResponse();
	}
}
