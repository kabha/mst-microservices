
public class Program {

	public static void showReport(Shape s) {
		System.out.println("---------------------");
		s.display();
		s.draw();
		
		if(s instanceof Circle) {
			System.out.println("Diameter: " + ((Circle)s).getRadius() * 2);
		}
		
		if(s instanceof Rectangle) {
			int perimeter = (((Rectangle)s).getWidth() + ((Rectangle)s).getHeight()) * 2;
			System.out.println("Rectangle's Perimeter: " + perimeter);
		}

		System.out.println("---------------------");
	}

	public static void main(String[] args) {
		
		// First advantage of Polymorphism - local reference which can contain different objects: 
		Shape myShape = null;
		switch(getRandom(1, 3)) {
			case 1: myShape = new Square(10, 20, 30);
					break;
			case 2: myShape = new Circle(40, 50, 60);
					break;
			case 3: myShape = new Rectangle(11, 22, 33, 44);
					break;
		}
		myShape.display();
		myShape.draw();
		
		if(myShape instanceof Circle) {
			System.out.println("Diameter: " + ((Circle)myShape).getRadius() * 2);
		}
		
		if(myShape instanceof Square) {
			System.out.println("Square Area: " + ((Square)myShape).getSide() * ((Square)myShape).getSide());
		}
		

		// Second advantage of Polymorphism - a function which can get different objects to an argument: 
		Square s = new Square(getRandom(1, 100), getRandom(1, 100), getRandom(1, 100));
		Circle c = new Circle(getRandom(1, 100), getRandom(1, 100), getRandom(1, 100));
		Rectangle r = new Rectangle(getRandom(1, 100), getRandom(1, 100), getRandom(1, 100), getRandom(1, 100));
		showReport(s);
		showReport(c);
		showReport(r);
		
		// Third advantage of Polymorphism - an array which can contain different objects: 
		Shape[] shapeArray = new Shape[50];
		for (int i = 0; i < shapeArray.length; i++) {
			switch(getRandom(1, 3)) {
				case 1: shapeArray[i] = new Square(getRandom(1, 100), getRandom(1, 100), getRandom(1, 100));
						break;
				case 2: shapeArray[i] = new Circle(getRandom(1, 100), getRandom(1, 100), getRandom(1, 100));
						break;
				case 3: shapeArray[i] = new Rectangle(getRandom(1, 100), getRandom(1, 100), getRandom(1, 100), getRandom(1, 100));
						break;
			}
			shapeArray[i].display();
			
			if(shapeArray[i] instanceof Circle) {
				System.out.println("Diameter: " + ((Circle)shapeArray[i]).getRadius() * 2);
			}
			
			shapeArray[i].draw();
		}
	}
	
	
	public static int getRandom(int min, int max) {
		return min + (int)(Math.random() * (max - min + 1));
	}
}