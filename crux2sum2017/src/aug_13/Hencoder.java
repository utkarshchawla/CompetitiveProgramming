package aug_13;

import java.util.Comparator;
import java.util.HashMap;

import javax.xml.soap.Node;

import july_31.GenericHeap;

public class Hencoder {

	private static HashMap<Character, String> encoder = new HashMap<>();
	private static HashMap<String, Character> decoder = new HashMap<>();

	private static class Node {
		Character data;
		int freq;
		Node left;
		Node right;

		public static final nodecomaprator ctor = new nodecomaprator();

		private static class nodecomaprator implements Comparator<Node> {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.freq - o1.freq;
			}

		}
	}

	public Hencoder(String feeder) {

		HashMap<Character, Integer> freqmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			if (freqmap.containsKey(feeder.charAt(i))) {
				freqmap.put(feeder.charAt(i), freqmap.get(feeder.charAt(i)) + 1);
			} else {
				freqmap.put(feeder.charAt(i), 1);
			}
		}

		GenericHeap<Node> gh = new GenericHeap<>(Node.ctor);
		for (Character c : freqmap.keySet()) {
			Node node = new Node();
			node.data = c;
			node.freq = freqmap.get(c);
			gh.add(node);
		}

		while (gh.size() != 1) {
			Node one = gh.removeHP();
			Node two = gh.removeHP();

			Node merged = new Node();
			merged.freq = one.freq + two.freq;
			merged.right = one;
			merged.left = two;
			gh.add(merged);

		}

		Node last = gh.removeHP();
		fillEncoderDecoder(last, "");

	}

	public static void fillEncoderDecoder(Node a, String sf) {

		if (a == null) {
			return;
		}
		if (a.left == null && a.right == null) {
			encoder.put(a.data, sf);
			decoder.put(sf, a.data);
		}

		fillEncoderDecoder(a.left, sf + "0");
		fillEncoderDecoder(a.right, sf + "1");
	}

	public String compress(String a) {
		String rv = "";
		for (int i = 0; i < a.length(); i++) {
			rv += encoder.get(a.charAt(i));
		}

		return rv;
	}

	public String decompress(String comd) {
		String rv = "";
		String code = "";
		for (int i = 0; i < comd.length(); i++) {
			code += comd.charAt(i);
			if (decoder.containsKey(code)) {
				rv += decoder.get(code);
				code = "";
			}
		}

		return rv;
	}

}
