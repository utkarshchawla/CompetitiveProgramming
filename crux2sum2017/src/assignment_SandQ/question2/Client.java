package assignment_SandQ.question2;

public class Client {

	public static void main(String[] args)throws Exception {

		PushEff s = new PushEff();
//		PopEff s = new PopEff();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
//		s.push(60);
		s.display();
//		s.pop();
		System.out.println(s.pop());
		s.display();
		s.push(100);
		s.display();
	}

}
