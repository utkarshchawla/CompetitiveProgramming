package july_12;

public class stackClient {

	public static void main(String[] args)throws Exception {
		stack s1 = new DynamicStack();
		stack temp = new stack();

		
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
//		s1.pop();
//		s1.pop();
//		s1.pop();
		s1.push(50);
//		s1.push(60);
//		s1.push(70);
//		s1.push(80);
//		s1.push(90);
		s1.display();
		s1.reverse(temp);
		s1.display();
//		s1.reverseDisplay();
//		s1.reverseDisplay();
//		System.out.println();
//		s1.display();
//		s1.size();
//		System.out.println(s1.size());
//		System.out.println(s1.pop());
//		s1.display();
//		System.out.println(s1.pop());
//		s1.display();
//		System.out.println(s1.top());

	}

}
