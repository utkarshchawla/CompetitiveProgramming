package july_30;

import java.util.HashSet;

public class Client {

	public static void main(String[] args) {

		String[] words = new String[7];
		Trie t = new Trie();
		t.addWord("art");
		t.addWord("ant");
		t.addWord("an");
		t.addWord("and");
		t.addWord("arc");
		t.addWord("bug");
		t.addWord("bugs");
		t.addWord("sea");
		t.addWord("see");
		t.addWord("seen");
//		System.out.println(t.searchWord("ant"));
//		System.out.println(t.searchWord("an"));
//		t.removeWord("buy");
//		System.out.println(t.searchWord("bug"));
//		t.display();
		t.displaytree();
	}

}
