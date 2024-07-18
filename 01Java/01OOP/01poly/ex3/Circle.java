
public class Circle extends Shape {
	
	private double radius;
	
	public Circle() {
	}

	public Circle(int x, int y, double radius) {
		super(x, y);
		setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void display() {
		super.display();
		System.out.println("Radius: " + radius);
	}

	public void draw() {
		System.out.println("O");
	}

	
}
