package id.ac.its.kelompok;

public class Circle extends Shape {
	private double radius;
	public static final double phi = 3.14;
	
	public Circle() {
		super();
//		System.out.println("[Circle]: Default Constructor");
		this.radius = 0.0;
	}
	
	public Circle(double radius) {
		super();
//		System.out.println("[Circle]: Constructor with radius");
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return phi * Math.pow(getRadius(), 2);
	}
	
	@Override
	public double getAround() {
		return 2 * phi * getRadius();
	}
	
	
	
	
}
