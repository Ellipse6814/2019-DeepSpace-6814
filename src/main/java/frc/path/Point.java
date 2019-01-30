package frc.path;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** This is a class that holds a 2d point that has a X and Y coordinate. */

public class Point {
	public double x;
	public double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		x = y = 0;
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public Point add(Point p) {
		return new Point(this.x + p.x, this.y + p.y);
	}

	public Point subtract(Point p) {
		return new Point(this.x - p.x, this.y - p.y);
	}

	public Point scale(double scale) {
		return new Point(this.x * scale, this.y * scale);
	}

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void set(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	/**
	 * Use this when you want two separate objects instead of two references of the
	 * same thing
	 * 
	 * @return a NEW point that is independent from this point that just happened to
	 *         have the same values as this one
	 */
	public Point copy() {
		return new Point(this.x, this.y);
	}

	@Override
	public String toString() {
		return round(x, 2) + "; " + round(y, 2);
	}

	public static double round(double value, int places) {
		return value;
		// if (places < 0)
		// throw new IllegalArgumentException();

		// BigDecimal bd = new BigDecimal(value);
		// bd = bd.setScale(places, RoundingMode.HALF_UP);
		// return bd.doubleValue();
	}

	@Deprecated
	public double getX() {
		return x;
	}

	@Deprecated
	public void setX(double x) {
		this.x = x;
	}

	@Deprecated
	public double getY() {
		return y;
	}

	@Deprecated
	public void setY(double y) {
		this.y = y;
	}

}
