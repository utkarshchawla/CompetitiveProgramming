package aug_6;

public class Client {

	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> popmap = new HashMap<>();
		popmap.put("a", 100);
		popmap.put("b", 200);
		popmap.put("c", 300);
		popmap.put("d", 400);
		popmap.put("e", 500);
		popmap.display();
		popmap.put("f", 600);
		popmap.put("g", 700);
		popmap.display();
	}

}
