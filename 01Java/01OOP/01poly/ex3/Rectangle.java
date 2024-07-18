
public class Rectangle extends Shape {

	private int width;
	private int height;
	
	public Rectangle() {
	}

	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		setWidth(width);
		setHeight(height);
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void display() {
		super.display();
		System.out.println("Width: " + width);
		System.out.println("Height: " + height);
	}

	public void draw() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
}
