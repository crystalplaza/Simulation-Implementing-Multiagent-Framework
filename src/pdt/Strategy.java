
package pdt;

/**
 * create an abstract class. It constains cooperate() method
 * 
 * @author xiaoli
 *
 */
public abstract class Strategy {
	protected Prisoner owner; // the owner of strategy

	/***
	 * constructor, set the owner to null
	 */
	public Strategy() {
		this.owner = null;
	}

	/**
	 * overload constructor
	 * 
	 * @param owner
	 */
	public void setOwner(Prisoner owner) {
		this.owner = owner;
	}

	/**
	 * abstract methods. It will be implement in the subclass
	 * 
	 * @return true if cooperate, otherwise, false
	 */
	public abstract boolean cooperate();

}
