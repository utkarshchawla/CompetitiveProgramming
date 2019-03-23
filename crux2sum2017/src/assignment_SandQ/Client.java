package assignment_SandQ;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Client {

	public static void main(String[] args) throws Exception {

		QueueFromLl q = new QueueFromLl();
		StackFromLl s = new StackFromLl();

		 q.enqueue(10);
		 q.enqueue(20);
		 q.enqueue(30);
		 q.enqueue(40);
		 q.enqueue(50);
		 q.display();
//		 q.dequeue();
//		 q.dequeue();
//		 q.dequeue();
//		 q.display();
//		 System.out.println(q.dequeue());

//		s.push(10);
//		s.push(20);
//		s.push(30);
//		s.push(40);
//		s.push(50);
//		s.display();
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		s.display();
	}

}
