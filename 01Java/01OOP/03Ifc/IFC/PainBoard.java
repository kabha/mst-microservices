package interefaces;

public class PainBoard extends Item {
	private int width;

	public PainBoard(String name, int weight, int width) {
		super(name, weight);
		this.width=width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "PainBoard [width=" + width +" "+ super.toString() + "]";
	}
	
	
}
