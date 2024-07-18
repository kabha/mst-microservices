package comparable;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Person [] people=new Person[3];
		people[0]=new Person("aaa",30);
		people[1]=new Person("bbb",21);
		people[2]=new Person("ccc",56);

		Arrays.sort(people);
		for(Person p:people){
			System.out.println(p);
		}
	}

}
