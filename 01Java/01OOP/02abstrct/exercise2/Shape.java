public abstract class Shape{
	
	private int height, weight;

	public void setHeight(int height){
		this.height=height;
	}

	public void setWeight(int weight){
		this.weight=weight;
	}	
	
	public int getHeight(){
		return height;
	}	

	public int getWeight(){
		return weight;
	}	

	public abstract void draw();
		
}