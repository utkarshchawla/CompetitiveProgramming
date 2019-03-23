package assignment_SandQ.question1;

import july_12.DynamicStack;
import july_12.stack;

public class DeqEff {

	stack s1 = new DynamicStack();
	stack s2 = new DynamicStack();
	
	public void enqueue(int val)throws Exception{
			int count = s1.size();
			for (int i = 0; i < count; i++) {
				s2.push(s1.pop());
			}
			s2.push(val);
			count = s2.size();
			for (int i = 0; i < count; i++) {
				s1.push(s2.pop());
			}
	}
	
	public int dequeue()throws Exception{
		try {
			return s1.pop();
		} catch (Exception e) {
			throw new Exception("queue is empty");
		}
	}
	
	public void display(){
		s1.display();
	}

}
