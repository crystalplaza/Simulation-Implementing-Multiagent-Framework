
package simstation;

import mvc.*;

/**
 * extends superclass, and override superclass method
 * 
 * @author xiaoli
 *
 */
public interface SimFactory extends AppFactory {
	/**
	 * abstract method, override getView() method
	 * 
	 * @param model the view for the model
	 * @return view
	 */
	public View getView(Model model);
}
