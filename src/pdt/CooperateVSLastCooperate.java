package pdt;

import simstation.*;

/**
 * create a strategy class, CooperateVSLastCooperate. Cooperation depends on the
 * owner's last response.
 *
 */
public class CooperateVSLastCooperate extends Strategy {
	/**
	 * constructor, invoke superclass constructor
	 */
	public CooperateVSLastCooperate() {
		super();
	}

	/**
	 * If the owner's last response is cooperate, it will return true. otherwise,
	 * return false.
	 */
	public boolean cooperate() {
		return owner.getLastResponse();
	}
}
