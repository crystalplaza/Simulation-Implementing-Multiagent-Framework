
package simstation;

import mvc.*;

public interface SimFactory extends AppFactory{
	public View getView(Model model);
	//public String getStats();
}
