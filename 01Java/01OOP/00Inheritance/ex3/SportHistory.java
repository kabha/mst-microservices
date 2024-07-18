public class SportHistory{

	Person [] p=new Person[7];

	private void fillArray(){
		p[0]=new Player("aaa",20,"Football","Ohanna");
		p[1]=new Player("bbb",20,"Football","Biton");
		p[2]=new Player("ccc",20,"Basketball","Pini");
		p[3]=new Player("ddd",20,"Basketball","Pini");
		p[4]=new Player("eee",20,"Football","Dalglish");
		p[5]=new Coach("Ohanna",20,"Basketball","fff",2);
		p[6]=new Coach("Pini",20,"Basketball","ggg",1);
	}

	private void printPlayers(){
		for(int i=0;i<7;i++){
			if(p[i] instanceof Player && !(p[i] instanceof Coach)){
				System.out.print("Player no' "+(i+1)+":  "+p[i].getName()+"   ");
				checkCoach((Player)p[i]);
				System.out.println("");
			}
		}
	}

	private void checkCoach(Player player){
		String name=player.getCoach();
		for(int i=0;i<7;i++){
			if(p[i] instanceof Coach){
				if(name.equalsIgnoreCase(p[i].getName()))
					System.out.print("Coatch: "+p[i].getName()+" Champ: "+((Coach)p[i]).getCampionship());
			}
		}
	}

	public static void main(String[] args) 
	{
		SportHistory sh=new SportHistory();
		sh.fillArray();
		sh.printPlayers();
	}
}
