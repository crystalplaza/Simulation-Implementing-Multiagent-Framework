package pdt;

/**
 * create one strategy class, AlwaysCooperate. It has one method, cooperate
 *
 */
public class AlwaysCooperate extends Strategy {
	public AlwaysCooperate() {
		super();
	}

	/**
	 * it always return true with AlwaysCooperate strategy
	 */
	public boolean cooperate() {
		return true;
	}
}
