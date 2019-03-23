package assignment_LL;

public class Client {

	public static void main(String[] args) throws Exception {

		LL l = new LL();

		l.addLast(11);
		l.addLast(12);
		l.addLast(22);
		l.addLast(55);
		l.addLast(66);
		l.addLast(33);
		l.addLast(44);
		// l.addLast(1000);
		// l.addLast(7);
		l.display();
//		l.insertionSort();
		l.ques1(3, 6);
		l.display();
	}

}
