package interefaces;

public class Store {

	
	public static void main(String[] args) {

		//fill store
		Item[] items=new Item[10];
		items[0]=new Ball("Ball-1", 15, "Black");
		items[1]=new Lamp("Lamp-1", 20, 300);
		items[2]=new Glass("Glass-1", 6, 200);
		items[3]=new Ball("Ball-2", 10, "Orange");
		items[4]=new PainBoard("PainBoard-1", 2500, 30);
		items[5]=new PainBoard("PainBoard-1", 3000, 60);
		items[6]=new Glass("Glass-2", 15, 200);
		items[7]=new Ball("Ball-3", 5, "Yellow");
		items[8]=new Glass("Glass-3", 10, 150);
		items[9]=new Lamp("Lamp-2", 30, 400);
		
		//print items
		for(int i=0;i<items.length;i++){
			System.out.println(items[i]);
		}
		
		//break what is breakable:
		for(int i=0;i<items.length;i++){
			if(items[i] instanceof Breakable){
				((Breakable)items[i]).broken();
			}
		}
		System.out.println();
		
		//print items again..
		for(int i=0;i<items.length;i++){
			System.out.println(items[i]);
		}

	}

}
