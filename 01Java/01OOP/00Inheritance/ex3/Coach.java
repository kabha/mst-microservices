public class Coach extends Player 
{
	private int championship;

	public Coach(String name,int age,String job,String coach,int championship){
		super(name,age,job,coach);		
		setChampionship(championship);
	}

	public void setChampionship(int championship){
		if(championship>0)
			this.championship=championship;
	}

	public int getCampionship(){
		return championship;
	}
}
