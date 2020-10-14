package mvc;

/**
 * This is an abstract class, exending superclass Bean. Subclasses implement or
 * override the methods. We can added methods later, without changing other
 * subclasses
 * 
 * @author xiaoli
 *
 */
public abstract class Model extends Bean {
	private String fName; // name of the file where model is saved
	private Boolean unSavedChanges; // true if there are unsaved changes

	/**
	 * getter, get file name
	 * 
	 * @return string of a file name
	 */
	public String getFileName() {
		return fName;
	}

	/**
	 * setter, set file name
	 * 
	 * @param name the name of a file
	 */
	public void setFileName(String name) {
		this.fName = name;
	}

	/**
	 * check the unsavedChange status
	 * 
	 * @return true if unsavedchange is true, otherwise, return false
	 */
	public Boolean hasUnsavedChanges() {
		return unSavedChanges;
	}

	/**
	 * setter, set the unsaved changes to the current status
	 * 
	 * @param status
	 */
	public void setUnsavedChanges(boolean status) {
		unSavedChanges = status;
	}

	/**
	 * change the saved changes status, and also fire Property change to listener
	 */
	public void changed() {
		unSavedChanges = true;
		firePropertyChange(null, null, null);
	}
}