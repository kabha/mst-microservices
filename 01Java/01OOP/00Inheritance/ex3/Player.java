public class Player extends Person 
{	
	private String job,coach;

	public Player(String name,int age,String job,String coach){
		super(name);
		setAge(age);
		this.job=job;
		this.coach=coach;
	}

	public void setCoach(String coach){
		this.coach=coach;
	}

	public void setJob(String job){
		this.job=job;
	}
	
	public String getJob(){
		return job;
	}

	public String getCoach(){
		return coach;
	}	
}
