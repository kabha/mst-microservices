package comparable;

public class Person implements Comparable {
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		return;
	}
	
	public String toString(){
		return age+"";
	}

	public int compareTo(Object o) {
		return age-((Person)o).getAge();
	}
	
}
