package mvc;

/**
 * create an abstract class, subclass can implement or override it.
 *
 */
public abstract class Command {

	protected Model model;

	/**
	 * constructor, take model as argument.
	 * 
	 * @param model the model where command will apply on
	 */
	public Command(Model model) {
		this.model = model;
	}

	/**
	 * abstract method to execute the command, subclass will override it
	 */
	protected abstract void execute();
}
