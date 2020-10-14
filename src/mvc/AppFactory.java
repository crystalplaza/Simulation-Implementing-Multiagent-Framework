package mvc;

/**
 * Appfactory interface. In case we will add more methods,we do not need to
 * change the whole design structure.
 *
 */
public interface AppFactory {
	/**
	 * Create a model
	 * 
	 * @return model
	 */
	public Model makeModel();

	/**
	 * get commands, such as statics, time, etc. The subclass can override it
	 * 
	 * @return string of commands
	 */
	public String[] getEditCommands();

	/**
	 * make edit commands, eg,start, run, stop for each model.
	 * 
	 * @param model model which edit commands apply on
	 * @param type
	 * @return command
	 */
	public Command makeEditCommand(Model model, String type);

	/**
	 * getter, get title for each model
	 * 
	 * @return title
	 */
	public String getTitle();

	/**
	 * getter, get help command
	 * 
	 * @return string of help command
	 */
	public String[] getHelp();

	/***
	 * information about the model, version, create time, etc.
	 * 
	 * @return string about the model
	 */
	public String about();

}
