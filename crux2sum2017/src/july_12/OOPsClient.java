package july_12;

public class OOPsClient {

	public static void main(String[] args) {

//		person p1 = new person();
//		p1.name = "A";
//		p1.age = 10;
//		p1.saysHi();
//		
//		person p2 = p1;
//		
//		p2.age = 20;
//		
//		System.out.println(p2.age);
//		System.out.println(p1.age);
//		
		person p3 = new person();
		p3.age = 10;
		p3.name = "A";
		
		person p4 = new person();
		p4.age = 20;
		p4.name = "B";
//		
		System.out.println(p3.age + " " + p3.name);
		System.out.println(p4.age + " " + p4.name);
//		Test2(p3, p4);
		System.out.println(p3.age + " " + p3.name);
		System.out.println(p4.age + " " + p4.name);
//		
		person p5 = new person("A", 10);
		p5.saysHi();
//	}
//	
	}
	
//	public static void Test2(person p1, person p2){
//		int tempa = p1.age;
//		p1.age = p2.age;
//		p2.age = tempa;
//		
//		p1 = new person();
//		p2 = new person();
//		
//		String tempn = p1.name;
//		p1.name = p2.name;
//		p2.name = tempn;
//	}
//	
	
//	public static void Test1(person p1, person p2){
//		person temp = p1;
//		p1 = p2;
//		p2 = temp;
//	
//	}

}

