package assignment_SandQ.question1;

public class Client {

	public static void main(String[] args)throws Exception {

		EnqEff q = new EnqEff();
//		DeqEff q = new DeqEff();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.display();
		q.dequeue();
		q.dequeue();
		q.display();
//		q.enqueue(100);
//		q.display();
	}

}
