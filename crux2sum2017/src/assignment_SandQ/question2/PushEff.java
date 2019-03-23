package assignment_SandQ.question2;

import java.util.concurrent.ExecutionException;

import july_17.queue;

public class PushEff {

	queue q1 = new queue();
	queue q2 = new queue();

	public void push(int val) throws Exception {
		q1.enqueue(val);
	}

	public int pop() throws Exception {
		int rv;
		try {
			q1.reverse();
			rv = q1.dequeue();
			q1.reverse();
		} catch (Exception e) {
			throw new Exception("stack is empty");
		}
		return rv;
	}

	public void display() throws Exception {
		q1.reverse();
		q1.display();
		q1.reverse();

	}

}
