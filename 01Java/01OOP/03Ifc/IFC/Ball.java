package interefaces;

public class Ball extends Item {
	private String color;

	public Ball(String name, int weight, String color) {
		super(name, weight);
		this.color=color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Ball [color=" + color +" "+ super.toString() + "]";
	}
	
	
}
