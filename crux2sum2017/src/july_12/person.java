package july_12;

public class person {

	String name = "default"; // data variables
	int age = -1; // data variables

	public void saysHi() {
		System.out.println(this.name + " [" + this.age + "] years old says hello");
	}

	public person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public person() {

	}
}
