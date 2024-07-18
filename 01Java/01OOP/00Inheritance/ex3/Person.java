public abstract class Person
{
	private int age;
	private String name;

	public Person(String name){
		this.name=name;
		age=1;
	}

	public Person(String name,int age){
		this.name=name;
		setAge(age);
	}

	public void setAge(int age){
		if(age>0&&age<=120)
			this.age=age;
		else
			this.age=1;
	}
	
	public int getAge(){
		return age;
	}

	public String getName(){
		return name;
	}

	public abstract String getJob();
}
