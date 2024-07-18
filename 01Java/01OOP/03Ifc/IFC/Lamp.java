package interefaces;

public class Lamp extends Item implements Breakable{
	private int watt;

	public Lamp(String name, int weight, int watt) {
		super(name, weight);
		this.watt=watt;
	}

	public int getWatt() {
		return watt;
	}

	public void setWatt(int watt) {
		this.watt = watt;
	}

	@Override
	public String toString() {
		if(watt==-99||getWeight()==-99){
			return getName()+" is broken";
		}
		return "Lamp [watt=" + watt +" "+ super.toString() + "]";
	}
	
	@Override
	public void broken() {
		watt=-99;
		setWeight(-99);
	}
	
}
