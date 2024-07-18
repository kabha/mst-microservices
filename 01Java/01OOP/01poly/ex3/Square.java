
public class Square extends Shape {
	
	private int side;
	
	public Square() {
	}

	public Square(int x, int y, int side) {
		super(x, y);
		setSide(side);
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	public void display() {
		super.display();
		System.out.println("Side: " + side);
	}

	public void draw() {
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
