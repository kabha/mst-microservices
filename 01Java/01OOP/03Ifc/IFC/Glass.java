package interefaces;

public class Glass extends Item implements Breakable {
	private int capacity;

	public Glass(String name, int weight, int capacity) {
		super(name, weight);
		this.capacity=capacity;
	}

	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		if(capacity==-99||getWeight()==-99){
			return getName()+" is broken";
		}
		return "Glass [capacity=" + capacity +" "+ super.toString() + "]";
	}

	@Override
	public void broken() {
		capacity=-99;
		setWeight(-99);
	}
	
	
}
