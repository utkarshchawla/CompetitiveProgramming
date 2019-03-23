package july_17;

import java.util.Scanner;

public class QueueClient {

	public static void main(String[] args)throws Exception {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		queue q = new queue();

		while(n> 0){
			q.enqueue(scn.nextInt());
		}
		
		q.reverse();
		q.display();

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
//		q.dequeue();
//		q.dequeue();
//		q.enqueue(50);
//		q.enqueue(60);
//		q.enqueue(70);
		q.display();
//		q.reverse();
		q.reversedisplay(0);
		System.out.println();
		q.display();
		
	}

}
