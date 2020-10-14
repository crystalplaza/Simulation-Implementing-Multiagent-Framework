package mvc;

/**
 * point will be used frequently when creating simulations. create a point class
 * here, other model can just utilize it without create each point within each
 * simulation.
 * 
 * @author xiaoli
 *
 */
public class Point {
	private double xc = 0, yc = 0;

	/**
	 * constructor, taking two value, x axis and y axis
	 * 
	 * @param xc the value on x axis
	 * @param yc the value on y axis
	 */
	public Point(double xc, double yc) {
		this.xc = xc;
		this.yc = yc;
	}

	/**
	 * getter, get the value on x axis
	 * 
	 * @return the value on x axis
	 */
	public double getXc() {
		return xc;
	}

	/**
	 * getter, get the value on y axis
	 * 
	 * @return the value on y axis
	 */
	public double getYc() {
		return yc;
	}

	/**
	 * override hashCode method
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(xc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * override equal method
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(xc) != Double.doubleToLongBits(other.xc))
			return false;
		if (Double.doubleToLongBits(yc) != Double.doubleToLongBits(other.yc))
			return false;
		return true;
	}

	// map this from CRT coordinates to canvas coordinates
	public Point transform(int canvasSize) {
		return new Point(canvasSize / 2 * this.xc + canvasSize / 2, canvasSize / 2 - canvasSize / 2 * this.yc);
	}
}