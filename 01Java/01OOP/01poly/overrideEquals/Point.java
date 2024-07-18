
public class Point {
	private int x;
	private int y;
	
	public Point() {
	}
	
	public Point(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void display() {
		System.out.println("X = " + x + ", Y = " + y);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Point && this.x == ((Point)obj).x && this.y == ((Point)obj).y;
	}
	
}









