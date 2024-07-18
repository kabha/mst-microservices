public class Rectangle extends Shape{
	
	public Rectangle (int weight, int height){
		setHeight(height);
		setWeight(weight);
}	

	public void draw(){
		for(int y=0;y<getHeight();y++){
			for(int x=0;x<getWeight();x++){
				System.out.print("*");
			}
			System.out.println("");
		}		
	}
}