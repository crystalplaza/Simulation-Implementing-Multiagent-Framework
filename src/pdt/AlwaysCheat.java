package pdt;

/**
 * create alwaysCheat strategy, extends from superclass. It contain one method,
 * cooperate().
 * 
 * @author xiaoli
 *
 */
public class AlwaysCheat extends Strategy {

	/**
	 * constructor, invoke superclass constructor
	 */
	public AlwaysCheat() {
		super();
	}

	/**
	 * cooperate method, always return false.
	 */
	public boolean cooperate() {
		return false;
	}

}
