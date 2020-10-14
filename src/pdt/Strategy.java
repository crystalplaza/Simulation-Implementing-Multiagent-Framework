
package pdt;

public abstract class Strategy {
	  protected Prisoner owner;
	  public Strategy() { this.owner = null; }
	  public void setOwner(Prisoner owner) {
		  this.owner = owner;
	  }
	  public abstract boolean cooperate();

}
