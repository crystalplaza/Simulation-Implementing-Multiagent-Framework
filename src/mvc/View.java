package mvc;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.beans.*;

/**
 * View is a superclass. It contains getter and setter method.It also contains
 * property change method.
 *
 */
public class View extends JComponent implements PropertyChangeListener {

	protected Model model;

	/**
	 * constructor, takes model as parameter, and adds property change listener to
	 * the model.
	 * 
	 * @param model
	 */
	public View(Model model) {
		super();
		this.model = model;
		model.addPropertyChangeListener(this);
		// optional border around the view component
		setBorder(LineBorder.createBlackLineBorder());
	}

	/**
	 * getter, get the model
	 * 
	 * @return model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * setter, set the model
	 * 
	 * @param model
	 */
	public void setModel(Model model) {
		if (this.model != null)
			this.model.removePropertyChangeListener(this);
		this.model = model;
		if (model != null) {
			this.model.addPropertyChangeListener(this);
			repaint();
		}
	}

	@Override

	public void propertyChange(PropertyChangeEvent arg0) {
		repaint();
	}
}