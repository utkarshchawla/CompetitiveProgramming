package assignment_SandQ.question1;


import july_12.DynamicStack;
import july_12.stack;

public class EnqEff {

	stack s1 = new DynamicStack();
	stack s2 = new DynamicStack();

	public void enqueue(int val) throws Exception {
		s1.push(val);
	}

	public int dequeue() throws Exception {
		int rv;
		try {
			int count = s1.size();
			for (int i = 0; i < count; i++) {
				s2.push(s1.pop());
			}
			rv = s2.pop();
			count = s2.size();
			for (int i = 0; i < count; i++) {
				s1.push(s2.pop());
			}
		} catch (Exception e) {
			throw new Exception("queue is empty");
		}

		return rv;
	}

	public void display() throws Exception {
		System.out.println("---------------------------------");
		s1.reverseDisplay();
		System.out.println();
		System.out.println("---------------------------------");

	}

}
