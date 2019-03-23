package july_30;

import java.util.HashMap;

public class Trie {
	public class Node {
		Character data;
		boolean eow;
		HashMap<Character, Node> children = new HashMap<>();
	}

	private Node root = new Node();
	int numWords = 0;
	int numNods = 1;

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = true;
			numWords++;
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = node.children.get(ch);

		if (child == null) {
			Node t = new Node();
			numNods++;
			t.data = ch;
			node.children.put(ch, t);
			addWord(t, ros);

		} else {
			addWord(child, ros);
		}
	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(ch);

		if (child == null) {
			return false;
		} else {
			return searchWord(child, ros);
		}

	}

	public void removeWord(String word) {
		removeWord(root, word);
	}

	private void removeWord(Node node, String word) {
		if (word.length() == 0) {
			if (node.eow) {
				node.eow = false;
				this.numWords--;
			}
			return;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(ch);

		if (child == null) {
			System.out.println("word not present");
			return;
		}

		removeWord(child, ros);

		if (child.eow == false && child.children.size() == 0) {
			node.children.remove(ch);
			this.numWords--;
		}

	}

	public void display() {
		display(root, "");
	}

	private void display(Node node, String osf) {
		if (node.eow == true) {
			System.out.println(osf);
		}

		for (char key : node.children.keySet()) {
			Node child = node.children.get(key);
			display(child, osf + key);
		}

	}

	public void displaytree() {
		displaytree(root);
	}

	private void displaytree(Node node) {

		System.out.print(node.data + " => ");

		for (char key : node.children.keySet()) {
			System.out.print(key + ", ");
		}

		System.out.println();

		for (char key : node.children.keySet()) {
			Node child = node.children.get(key);
			displaytree(child);
		}

	}
}
