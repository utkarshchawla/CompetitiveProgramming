package aug_13;

public class Client {

	public static void main(String[] args) {
		Hencoder h = new Hencoder(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccddd");
		System.out.println(h.compress("abacd"));
		System.out.println(h.decompress("0100110111"));

	}

}
