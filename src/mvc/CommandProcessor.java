package mvc;

public class CommandProcessor {
	/**
	 * it will execute the command.
	 * 
	 * @param commd the command which will execute
	 */
	public static void execute(Command commd) {
		commd.execute();

	}

}
