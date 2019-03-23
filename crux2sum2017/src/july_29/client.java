package july_29;


public class client {

	public static void main(String[] args) {
//		Heap pq = new Heap(true);
		int[] arr = {300,500,700,800,100};
		Heap pq = new Heap(arr, true);
//		pq.add(300);
//		pq.add(100);
//		pq.add(500);
//		pq.add(700);
//		pq.add(800);
//		pq.add(600);
		
		
		pq.display();
		
		while(pq.size() != 0){
			System.out.println(pq.removeHP());
		}

	}

}
