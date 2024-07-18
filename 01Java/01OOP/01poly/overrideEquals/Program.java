
public class Program {

	public static void main(String[] args) {
		
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		
		if(p1.equals(p2)) {
			System.out.println("Both are equal.");
		}
		else {
			System.out.println("Both are not equal.");
		}
		
		Cat c = new Cat();
		if(p1.equals(c)) {
			System.out.println("Both are equal.");
		}
		else {
			System.out.println("Both are not equal.");
		}
	}
}
