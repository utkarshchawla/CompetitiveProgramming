package assignment_SandQ;

import july_18.linkedList;

public class StackFromLl {

	linkedList ll = new linkedList();

	public void push(int data) {
		ll.addFirst(data);
	}

	public int pop() throws Exception {
		try {
			return ll.removeFirst();
		} catch (Exception e) {
			throw new Exception("stack is empty");
		}
	}

	public void display() {
		ll.display();
	}
}
