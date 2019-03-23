package assignment_SandQ.question2;

import july_17.queue;

public class PopEff {

	queue q1 = new queue();
	queue q2 = new queue();
	
	public void push(int val)throws Exception{
		q1.reverse();
		q1.enqueue(val);
		q1.reverse();
	}
	
	public int pop()throws Exception{
		return q1.dequeue();
	}
	
	public void display()throws Exception{
		q1.display();
	}
}
