package test;

public class C {

	public static void main(String[] args) {
		H pq = new H(true);
		pq.add(300);
		pq.add(700);
		pq.add(800);
		pq.add(100);
		pq.add(500);
		pq.display();

		while (pq.size() != 0) {
			System.out.println(pq.removeHP());
		}
	}

}
