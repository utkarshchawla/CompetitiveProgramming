package assignment_SandQ;

import july_18.linkedList;

public class QueueFromLl {

	linkedList list = new linkedList();

	public void enqueue(int val) {
		list.addLast(val);
	}

	public int dequeue() throws Exception {
		try {
			return list.removeFirst();
		} catch (Exception e) {
			throw new Exception("queue is empty");
		}
	}

	public void display() {
		list.display();
	}

}
