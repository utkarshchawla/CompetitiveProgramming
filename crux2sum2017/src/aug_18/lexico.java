package aug_18;

public class lexico {

	public static void main(String[] args) {

		lexico(1, 1000);
	}
	
	public static void lexico(int num, int max) {
		// print num itself
		System.out.println(num);

		// call to family
		for (int i = 0; i <= 9; i++) {
			if (num * 10 + i <= max) {
				lexico(num * 10 + i, max);
			}
		}

		// call to neighbor
		if (num < 9) {
			lexico(num + 1, max);
		}

	}

}
